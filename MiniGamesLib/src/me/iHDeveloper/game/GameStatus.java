package me.iHDeveloper.game;


public enum GameStatus {
 
    PRE_LOBBY(true, "game.join.prelobby", "&6&lPre-Lobby"), 
    LOBBY(true, "game.join.lobby", "&e&lLobby"),
    IN_GAME(true, "game.join.ingame", "&cIn Game"), 
    FINISH(true, "game.join.finish", "&aFinish"), 
    RESTARTING(false, "", "&4Restarting");
    
    private boolean canStart;
    private String permission;
    private String displayName;
    
    private GameStatus(boolean canStart, String permission, String displayName) {
    	this.canStart = canStart;
    	this.permission = permission;
    	this.displayName = displayName;
    }
    
    public String getPermission(){
    	return permission;
    }
    
    public boolean canStart(){
    	return canStart;
    }
    
    public String getDisplayName(){
    	return displayName;
    }
    
}
