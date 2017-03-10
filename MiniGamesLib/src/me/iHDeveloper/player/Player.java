package me.iHDeveloper.player;

import org.bukkit.Location;


public interface Player {
    
    public org.bukkit.entity.Player getPlayer();
    
    public PlayerChat getMessager();
    
    public Location getLocation();
    
    public String getName();
    
}
