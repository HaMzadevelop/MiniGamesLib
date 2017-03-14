package me.iHDeveloper.game;

import me.iHDeveloper.player.Player;


public interface Game {
     
    public GamePlayerList getPlayers();
    
    public GameInfo getInfo();
    
    public GameTimer getTimer();
    
    public GameStatus getStatus();
    
    public GameRules getRules();
    
    public GameScoreboard getScoreboard();
    
    public GameMap getMap();
    
    public GameSettings getSettings();
    
    public int getId();
    
    public void start();
    
    public void stop();
    
    public void join(Player p);
    
    public void quit(Player p);
    
}
