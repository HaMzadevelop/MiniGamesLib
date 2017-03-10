package me.iHDeveloper.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener{

	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		e.setQuitMessage("");
		// TODO say to the game this player is left from game
	}
	
}
