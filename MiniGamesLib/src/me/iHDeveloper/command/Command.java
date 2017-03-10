package me.iHDeveloper.command;

import me.iHDeveloper.player.Player;


public abstract class Command {
    
    public abstract boolean onCommand(Player player, String[] args);
    
}
