package me.iHDeveloper.game;


public interface Game {
     
    public GamePlayerList getPlayers();
    
    public GameInfo getInfo();
    
    public GameTimer getTimer();
    
    public GameScoreboard getScoreboard();
    
    public int getId();
    
    public void start();
    
    public void stop();
    
}
