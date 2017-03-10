package me.iHDeveloper.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class MonsterSpawnEvent implements Listener{

	@EventHandler
	public void onMonsterSpawn(CreatureSpawnEvent e){
		e.setCancelled(true);
	}
	
}
