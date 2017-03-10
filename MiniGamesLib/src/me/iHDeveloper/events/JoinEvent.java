package me.iHDeveloper.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener{

	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		e.setJoinMessage("");
		// TODO on join auto join the game
	}
	
}
