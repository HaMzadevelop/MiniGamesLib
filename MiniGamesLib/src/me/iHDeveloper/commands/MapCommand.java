package me.iHDeveloper.commands;

import me.iHDeveloper.command.Command;
import me.iHDeveloper.command.CommandInfo;
import me.iHDeveloper.map.MapAPI;
import me.iHDeveloper.player.Player;
import me.iHDeveloper.player.PlayerChat;

@CommandInfo(command = "map", description = "To change the map settings", isOp = true)
public class MapCommand extends Command{

	@Override
	public boolean onCommand(Player player, String[] args) {
		PlayerChat messager = player.getMessager();
		if(args.length == 2){
                    String name = args[1];
                    if(args[0].equalsIgnoreCase("create")){
				MapAPI.create(name);
                                messager.send("&aComplete! &ecreate map &9"+name);
				return true;
                    } else if(args[0].equalsIgnoreCase("remove")){
                        messager.send("&aComplete! &eremove map &9"+name);
			return true;
                    }else{
                       messager.send("&cnot found the command! &btype &9/map help");
                       return true;
                    }
		}
		messager.sendSub();
		messager.send("&9/map &ecreate &7<name>");
		messager.send("&9/map &eremove &7<name>");
		messager.sendSub();
		return true;
	}

}
