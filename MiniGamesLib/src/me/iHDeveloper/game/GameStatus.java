package me.iHDeveloper.game;


public enum GameStatus {
 
    PRE_LOBBY(true, "game.join.prelobby"), LOBBY(true, "game.join.lobby"),
    
    IN_GAME(true, "game.join.ingame"), FINISH(true, "game.join.finish"), 
    RESTARTING(false, "");
    
    private boolean canStart;
    private String permission;
    
    private GameStatus(boolean canStart, String permission) {
    	this.canStart = canStart;
    	this.permission = permission;
    }
    
    public String getPermission(){
    	return permission;
    }
    
    public boolean canStart(){
    	return canStart;
    }
    
}
