package me.iHDeveloper.tools;

import java.io.File;
import org.bukkit.configuration.file.YamlConfiguration;


public class Settings {
    
    public static YamlConfiguration getConfig(File file){
        try{
            file.createNewFile();
            YamlConfiguration config = new YamlConfiguration();
            config.load(file);
            return config;
        }
        catch(Exception ex){
            
        }
        return null;
    }
    
}
