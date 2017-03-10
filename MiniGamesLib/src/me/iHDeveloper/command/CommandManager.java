package me.iHDeveloper.command;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import me.iHDeveloper.MiniGamesLib;
import me.iHDeveloper.debug.Debug;
import me.iHDeveloper.player.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;


public class CommandManager implements Listener{
    
    private static List<Command> commands = new LinkedList<Command>();
    
    public static void addCommand(Command command){
        commands.add(command);
    }
    
    @EventHandler
    public void onPreProcessCommand(PlayerCommandPreprocessEvent e){
        org.bukkit.entity.Player p = e.getPlayer();
        String message = e.getMessage();
        Debug.info("The "+p.getName()+" enter command "+message);
        message = message.substring(0, message.length());
        List<String> args = new LinkedList<String>(Arrays.asList(message.split(" ")));
        if(args.size() > 1){
            String name = args.get(0);
            args.remove(0);
            Command wanted = null;
            Player player = MiniGamesLib.getPlayer(p.getName());
            for (Command command : commands) {
                CommandInfo info = command.getClass().getAnnotation(CommandInfo.class);
                if(info != null){
                    if(info.command().equalsIgnoreCase(name)){
                        if(info.isOp()){
                            if(p.isOp()){
                                wanted = command;
                            }else{
                                player.getMessager().send("&cThis is command is blocked!");
                                break;
                            }
                        }else{
                            wanted = command;
                        }
                    }
                }
            }
            if(wanted == null){
                showhelp(player);
                e.setCancelled(true);
                if(p.isOp()){
                    e.setCancelled(false);
                    return;
                }
            }else{
                boolean b = wanted.onCommand(player, args.toArray(new String[0]));
                if(!b){showhelp(player);}
                e.setCancelled(true);
                return;
            }
        }
        if(p.isOp())return;
        e.setCancelled(true);
    }

    protected static void showhelp(Player player) {
        for (Command command : commands) {
            CommandInfo info = command.getClass().getAnnotation(CommandInfo.class);
            if(info != null){
                player.getMessager().send("&9/"+info.command()+" &e"+info.description());
            }
        }
    }
    
}
