package me.iHDeveloper.game;

import java.io.File;
import java.io.IOException;

import me.iHDeveloper.MiniGamesLib;
import me.iHDeveloper.debug.Debug;
import me.iHDeveloper.map.Map;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;

import com.onarandombox.MultiverseCore.api.MultiverseWorld;
import com.onarandombox.MultiverseCore.utils.WorldManager;


public class GameMap {

    private Game game;
    private Map map;
    private World world;
    
    public GameMap(Game game) {
        this.game = game;
    }
    
    public void setup(Map map){
        this.map = map;
        File dataFolder = new File("Maps");
        String path = "G"+game.getId()+"-"+map.getName().toUpperCase();
        File mapFolder = new File(path);
        File mapCopy = new File(map.getName());
        if(mapCopy.exists())
        	mapCopy.delete();
        if(!dataFolder.exists()){
            dataFolder.mkdir();
        if(!mapFolder.exists())
                mapFolder.mkdir();
        try {
			FileUtils.copyDirectory(mapFolder, mapCopy);
		} catch (IOException e) {
			e.printStackTrace();
			Debug.err("&cError on copy map folder data");
			return;
		}
        WorldManager wm = new WorldManager(MiniGamesLib.getMultiverseCore());
        boolean isInstalled = wm.loadWorld(path);
        if(!isInstalled){
            Debug.err("&cNot install &9"+mapFolder.getPath());
            return;
        } 
        World world = Bukkit.getWorld(map.getName());
        if(world == null){
            Debug.err("&4Not found the world");
            return;
        }
        this.world = world;
        Debug.info("&aInstalled map world in game id "+game.getId());
    }
    }
    
    public World getWorld(){
        return world;
    }
    
    public Game getGame(){
    	return game;
    }
    
    public Map getMap(){
    	return map;
    }
    
}
