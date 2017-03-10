package   me.iHDeveloper;

import java.util.HashMap;
import java.util.Map;

import me.iHDeveloper.command.CommandManager;
import me.iHDeveloper.command.HelpCommand;
import me.iHDeveloper.commands.SettingsCommand;
import me.iHDeveloper.debug.Debug;
import me.iHDeveloper.player.Player;
import me.iHDeveloper.player.PlayerCreator;
import me.iHDeveloper.tools.TempleteData;
import me.iHDeveloper.util.ConsoleChat;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MiniGamesLib extends JavaPlugin implements Listener{
  
  private static Map<String, Player> players = new HashMap<>();
  
  public static String getDataPath(){
	  return "plugins//MiniGamesLib//";
  }
  
  @Override
  public void onEnable(){
	  for (org.bukkit.entity.Player player : Bukkit.getOnlinePlayers()) {
		addPlayer(player);
	  }
      getConfig().options().copyDefaults();
      saveDefaultConfig();
      loadSettings();
      registerEvents();
      addCommands();
      ConsoleChat.info("&aEnabled!");
  }
  
  private void loadSettings() {
	  TempleteData.load();
  }

  private void registerEvents() {
	PluginManager pm = getServer().getPluginManager();
    pm.registerEvents(this, this);
	pm.registerEvents(new CommandManager(), this);
  }
  
  private void addCommands(){
      CommandManager.addCommand(new HelpCommand());
      CommandManager.addCommand(new SettingsCommand());
  }
  
  private void saveSettings(){
	  TempleteData.save();
  }
  
  @Override
  public void onDisable(){
	  saveSettings();
      ConsoleChat.info("&cDisabled!");
  }
  
  @EventHandler(priority = EventPriority.HIGHEST)
  public void onJoin(PlayerJoinEvent e){
      org.bukkit.entity.Player p = e.getPlayer();
      addPlayer(p);
  }

  public static Player getPlayer(String name){
      return players.get(name);
  }
  
  private static void addPlayer(org.bukkit.entity.Player p){
	  Player player = PlayerCreator.create(p);
      players.put(player.getName(), player);
      Debug.info("The "+player.getName()+" added to the players list");
  }
  
  @EventHandler(priority = EventPriority.HIGHEST)
  public void onQuit(PlayerQuitEvent e){
      Player player = getPlayer(e.getPlayer().getName());
      players.remove(player.getName());
      Debug.info("The "+player.getName()+" removed to the players list");
  }
  
}
