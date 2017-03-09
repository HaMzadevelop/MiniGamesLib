package me.iHDeveloper.tools;

import java.io.File;

import me.iHDeveloper.debug.Debug;

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
        	ex.printStackTrace();
        	Debug.err(ex.getMessage());
        }
        return null;
    }
    
}
