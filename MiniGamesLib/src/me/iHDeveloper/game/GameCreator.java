package me.iHDeveloper.game;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import me.iHDeveloper.debug.Debug;
import me.iHDeveloper.map.MapAPI;

public class GameCreator {

	public static Game create(int id){
		GameCreatorItem game = new GameCreatorItem(id);
		return game;
	}
	
}
class GameCreatorItem implements Game{

	private final GamePlayerList players;
	private final GameInfo info;
	private final GameRules rules;
	private GameStatus status;
	private final GameMap map;
	
	public GameCreatorItem(int id) {
		this.info = new GameInfo(id);
		this.players = new GamePlayerList();
		this.rules = new GameRules();
		this.map = new GameMap(this);
		map.setup(MapAPI.get(0));
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
		Debug.info("Hosting game "+getId());
		status = GameStatus.PRE_LOBBY;
		GameManager.addGame(this); // Add game to the list
	}

	@Override
	public void stop() {
		GameManager.removeGame(this); // Remove game from the list
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

	@Override
	public GameStatus getStatus() {
		// TODO Auto-generated method stub
		return status;
	}

	@Override
	public GameRules getRules() {
		return rules;
	}

	@Override
	public GameMap getMap() {
		return null;
	}
	
}
class GameCreatorTimerItem implements GameTimer, Runnable{
	
	private final UUID public_id;
	private final Map<UUID, Timer> timers = new HashMap<UUID, GameCreatorTimerItem.Timer>();
	
	public GameCreatorTimerItem() {
		public_id = UUID.randomUUID();
		usedId = public_id;
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
	
	private UUID usedId = null;
	
	@Override
	public void run() {
		while(true){
			if(usedId.equals(public_id)){

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				Debug.info("Closed Game timer");
				return;
			}
		}
	}
	
	class Timer{
		int ms;
		Runnable run;
		boolean pasue = false;
		boolean stop = false;
	}
	
}