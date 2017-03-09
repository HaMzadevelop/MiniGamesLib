package   me.iHDeveloper;

import me.iHDeveloper.util.ConsoleChat;
import org.bukkit.plugin.java.JavaPlugin;

public class MiniGamesAPI extends JavaPlugin{
  
  @Override
  public void onEnable(){
      getConfig().options().copyDefaults();
      saveDefaultConfig(); 
      ConsoleChat.info("&aEnabled!");
  }
  
  @Override
  public void onDisable(){
      ConsoleChat.info("&cDisabled!");
  }
  
}
