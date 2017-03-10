package me.iHDeveloper.game;

import java.util.UUID;

 
public interface GameTimer {
    
    public UUID runTimer(Runnable run, int ms);
    
    public void pasueTimer(UUID id);
    
    public void resumeTimer(UUID id);
    
}
