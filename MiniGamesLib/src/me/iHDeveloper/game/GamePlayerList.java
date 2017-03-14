package me.iHDeveloper.game;

import java.util.ArrayList;
import java.util.List;

import me.iHDeveloper.player.Player;

 
public class GamePlayerList {
    
    private final List<Player> list;

    public GamePlayerList() {
        this.list = new ArrayList<>();
    }
    
    protected void add(Player p){
        list.add(p);
    }
    
    protected void delete(Player p){
        list.remove(p);
    }
    
    public boolean contains(Player player){
    	return list.contains(player);
    }
 
    public List<Player> get(){
        return list;
    }

	public int size() {
		return list.size();
	}    
}
