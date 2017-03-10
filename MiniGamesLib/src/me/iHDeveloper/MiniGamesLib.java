package   me.iHDeveloper;

import java.util.HashMap;
import java.util.Map;
import me.iHDeveloper.command.CommandManager;
import me.iHDeveloper.command.HelpCommand;
import me.iHDeveloper.debug.Debug;
import me.iHDeveloper.player.Player;
import me.iHDeveloper.player.PlayerCreator;
import me.iHDeveloper.util.ConsoleChat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MiniGamesLib extends JavaPlugin implements Listener{
  
  private static Map<String, Player> players = new HashMap<>();
  
  @Override
  public void onEnable(){
      getConfig().options().copyDefaults();
      saveDefaultConfig();
      registerEvents();
      addCommands();
      ConsoleChat.info("&aEnabled!");
  }
  
  private void registerEvents() {
	PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(this, this);
	pm.registerEvents(new CommandManager(), this);
  }
  
  private void addCommands(){
      CommandManager.addCommand(new HelpCommand());
  }
  
  @Override
  public void onDisable(){
      ConsoleChat.info("&cDisabled!");
  }
  
  @EventHandler(priority = EventPriority.HIGHEST)
  public void onJoin(PlayerJoinEvent e){
      org.bukkit.entity.Player p = e.getPlayer();
      Player player = PlayerCreator.create(p);
      players.put(player.getName(), player);
      Debug.info("The "+player.getName()+" added to the players list");
  }

  public static Player getPlayer(String name){
      return players.get(name);
  }
  
  @EventHandler(priority = EventPriority.HIGHEST)
  public void onQuit(PlayerQuitEvent e){
      Player player = getPlayer(e.getPlayer().getName());
      players.remove(player.getName());
      Debug.info("The "+player.getName()+" removed to the players list");
  }
  
}
