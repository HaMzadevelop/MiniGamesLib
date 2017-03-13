package me.iHDeveloper.game;

import java.io.File;
import me.iHDeveloper.debug.Debug;
import me.iHDeveloper.map.Map;
import org.bukkit.Bukkit;
import org.bukkit.World;


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
        File mapFolder = new File("Maps//"+map.getName());
        if(!dataFolder.exists()){
            dataFolder.mkdir();
        if(!mapFolder.exists())
                mapFolder.mkdir();
        boolean isInstalled = Bukkit.unloadWorld(mapFolder.getPath(), false);
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
    
    public World getWorld(){
        return world;
    }
}
}
