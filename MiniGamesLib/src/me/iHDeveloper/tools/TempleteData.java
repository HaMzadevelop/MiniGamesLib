package me.iHDeveloper.tools;

import java.io.File;

import me.iHDeveloper.MiniGamesLib;

import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

public class TempleteData {

	private static Location waitSpawn;
	private static Location spactateSpawn;
	
	public static void setWaitSpawn(Location location){
		waitSpawn = location;
	}
	
	public static void setSpactateSpawn(Location location){
		spactateSpawn = location;
	}
	
	public static void load(){
		File file = new File(MiniGamesLib.getDataPath()+"tem.yml");
		YamlConfiguration config = Settings.getConfig(file);
		waitSpawn = (Location)config.get("wait");
		spactateSpawn = (Location)config.get("spactate");
	}
	
	public static void save(){
		File file = new File(MiniGamesLib.getDataPath()+"tem.yml");
		YamlConfiguration config = Settings.getConfig(file);
		config.set("wait", waitSpawn);
		config.set("spactate", spactateSpawn);
                Settings.save(file, config);
	}
	
}
