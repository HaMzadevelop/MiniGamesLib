package me.iHDeveloper.game;

public class GameSettings {

	private String joinMsg;
	
	public GameSettings() {
	}
	
	public void setJoinMessage(String message){
		joinMsg = message;
	}
	
	public String getJoinMessage(){
		return joinMsg;
	}
	
}
