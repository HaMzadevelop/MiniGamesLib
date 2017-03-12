package me.iHDeveloper.tools;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public static void save(File file, YamlConfiguration config){
        try {
            config.save(file);
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
