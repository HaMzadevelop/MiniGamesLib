package me.iHDeveloper.team;

import java.util.ArrayList;
import java.util.List;

import me.iHDeveloper.debug.Debug;
import me.iHDeveloper.player.Player;

import org.bukkit.Location;

public class Team {

	private String prefix, name;
	private PlayerList players;
	private Location spawn;
	
	public Team(String name, String prefix, Location spawn) {
        this.name = name;
        this.prefix = prefix;
        this.spawn = spawn;
        players = new PlayerList();
        Debug.info("Create team "+toString());
    }
    
    public void addPlayer(Player player){
        players.add(player);
        Debug.info("Add " + player.getName() + " to team "+name);
    }
    
    public void removePlayer(Player player){
        players.remove(player);
        Debug.info("Delete " + player.getName() + " from team "+name);
    }
    
    public boolean isHere(Player player){
        return players.contains(player);
    }
    
    public List<Player> getPlayers(){
        return players.get();
    }
	
    public String getName(){
    	return name;
    }
    
    public String getPrefix(String prefix){
    	return prefix;
    }
    
    public Location getSpawn(){
		return spawn;	
    }
    
    public String toString(){
    	return String.format("{name='%s',prefix='%s',player{%s}", 
    			name, prefix, players.get().toArray());
    }
    
}
class PlayerList{
    private final List<Player> list;

    PlayerList() {
        this.list = new ArrayList<>();
    }
    
    void add(Player player){
        list.add(player);
    }
    
    void remove(Player player){
        list.remove(player);
    }
    
    boolean contains(Player player){
        return list.contains(player);
    }
    
    List<Player> get(){
        return list;
    }
}
