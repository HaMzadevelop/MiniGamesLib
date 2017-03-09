package   me.iHDeveloper;

import me.iHDeveloper.command.CommandManager;
import me.iHDeveloper.util.ConsoleChat;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MiniGamesLib extends JavaPlugin{
  
  @Override
  public void onEnable(){
      getConfig().options().copyDefaults();
      saveDefaultConfig();
      registerEvents();
      ConsoleChat.info("&aEnabled!");
  }
  
  private void registerEvents() {
	PluginManager pm = getServer().getPluginManager();
	pm.registerEvents(new CommandManager(), this);
}
  
  @Override
  public void onDisable(){
      ConsoleChat.info("&cDisabled!");
  }
  
}
