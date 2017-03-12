package me.iHDeveloper.map;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import me.iHDeveloper.MiniGamesLib;
import me.iHDeveloper.debug.Debug;
import me.iHDeveloper.tools.Settings;

import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;


public class MapProfile {

    private java.util.Map<String, Location> locations;
    private Location wait;
    private Location spactate;
    private final Map map;
    
    public MapProfile(Map map) {
        this.map = map;
        this.wait = null;
        this.spactate = null;
        this.locations = new HashMap<>();
    }
    
    public void setWaitSpawn(Location location){
        this.wait = location;
        update();
        
    }
    
    public void setSpactateSpawn(Location location){
        this.spactate = location;
        update();
    }
    
    public void putSpawn(String team, Location location){
        locations.put(team, location);
        update();
    }
    
    public void removeSpawn(String team){
        locations.remove(team);
        update();
    }
    
    private void update(){
        MapAPI.update(map.getName(), map);
    }
    
    public Location getWaitSpawn(){
        return wait;
    }
    
    public Location getSpactateSpawn(){
        return spactate;
    }
    
    public Location getSpawn(String team){
        return locations.get(team);
    }
    
    public Map getMap(){
        return map;
    }
    
    @Override
    public String toString(){
    	return "Map|"+map.getName();
    }
    
    public static void load(String name){
        File file = new File(MiniGamesLib.getDataPath()+"maps.yml");
        YamlConfiguration config = Settings.getConfig(file);
        Map map = MapAPI.create(name);
        MapProfile profile = map.getProfile();
        String path = "data."+name+".";
        profile.setWaitSpawn(getFromConfig(config, path+"wait"));
        profile.setSpactateSpawn(getFromConfig(config, path+"spactate"));
        List<String> list = config.getStringList(path+"spawns.list"); // teams list
        for (String team : list) {
            String spawn = path+"spawns."+team;
            Location location = getFromConfig(config, spawn);
            if(location != null){
                profile.putSpawn(team, location);
            }
        }
        Debug.info("Loaded Map "+map.toString());
    }
    
    private static Location getFromConfig(YamlConfiguration config, String path){
        return (Location)config.get(path);
    }
    
    public void save(String name){
    	File file = new File(MiniGamesLib.getDataPath()+"maps.yml");
        YamlConfiguration config = Settings.getConfig(file);
        String path = "data."+name+".";
        config.set(path+"wait", getWaitSpawn());
        config.set(path+"spactate", getSpactateSpawn());
        Set<String> teams = locations.keySet();
        config.set(path+"spawns.list", teams);
        for (String team : teams) {
			config.set(path+"spawns."+team, getSpawn(team));
		}
        Debug.info("Saved Map "+toString());
    }
    
}
