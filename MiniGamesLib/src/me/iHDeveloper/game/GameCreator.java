package me.iHDeveloper.game;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GameCreator {

	public static Game create(int id){
		GameCreatorItem game = new GameCreatorItem(id);
		return game;
	}
	
}
class GameCreatorItem implements Game{

	private final GamePlayerList players;
	private final GameInfo info;
	
	public GameCreatorItem(int id) {
		this.info = new GameInfo(id);
		this.players = new GamePlayerList();
	}
	
	@Override
	public GamePlayerList getPlayers() {
		return players;
	}

	@Override
	public GameInfo getInfo() {
		return info;
	}

	@Override
	public int getId() {
		return getInfo().getId();
	}

	@Override
	public void start() {
		
	}

	@Override
	public void stop() {
		
	}

	@Override
	public GameTimer getTimer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameScoreboard getScoreboard() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
class GameCreatorTimerItem implements GameTimer, Runnable{
	
	private final UUID public_id;
	private final Map<UUID, Timer> timers = new HashMap<UUID, GameCreatorTimerItem.Timer>();
	
	public GameCreatorTimerItem() {
		public_id = UUID.randomUUID();
	}

	@Override
	public UUID runTimer(Runnable run, int ms) {
		UUID id = UUID.randomUUID();
		Timer timer = new Timer();
		timer.ms = ms;
		timer.run = run;
		timer.stop = false;
		timers.put(id, timer);
		return null;
	}

	@Override
	public void pasueTimer(UUID id) {
		Timer timer = timers.get(id);
		if(timer == null)return;
		timer.pasue = true;
	}

	@Override
	public void resumeTimer(UUID id) {
		Timer timer = timers.get(id);
		if(timer == null)return;
		timer.pasue = false;
	}
	
	@Override
	public void run() {
		
	}
	
	class Timer{
		int ms;
		Runnable run;
		boolean pasue = false;
		boolean stop = false;
	}
	
}