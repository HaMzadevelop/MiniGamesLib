package me.iHDeveloper.game;


public interface Game {
     
    public GamePlayerList getPlayers();
    
    public GameInfo getInfo();
    
    public int getId();
    
    public void start();
    
    public void stop();
    
}
