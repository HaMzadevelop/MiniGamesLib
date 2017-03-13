package me.iHDeveloper.game;

import java.util.ArrayList;
import java.util.List;

import me.iHDeveloper.MiniGamesLib;
import me.iHDeveloper.player.Player;


public class GameManager {

	private static List<Game> games = new ArrayList<Game>();
	
	protected static void addGame(Game game) {
		games.add(game);
	}
	
	protected static void removeGame(Game game) {
		games.remove(game);
	}
	
	public static Game getGame(org.bukkit.entity.Player player){
		return getGame(MiniGamesLib.getPlayer(player.getName()));
	}
	
	public static Game getGame(Player player){
		for (Game game : games) {
			if(game.getPlayers().contains(player)){
				return game;
			}
		}
		return null;
	}
	
}
