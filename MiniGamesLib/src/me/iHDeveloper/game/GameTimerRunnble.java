package me.iHDeveloper.game;

public abstract class GameTimerRunnble {
	
	private int timer;
	
	public GameTimerRunnble(int timer) {
		setTimer(timer);
	}
	
	public abstract void run();
	
	public int getTimer(){
		return timer;
	}
	
	protected void setTimer(int timer) {
		this.timer = timer;
	}
	
}
