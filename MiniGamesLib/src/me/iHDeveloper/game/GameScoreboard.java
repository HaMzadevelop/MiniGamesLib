package me.iHDeveloper.game;

import me.iHDeveloper.debug.Debug;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;


public class GameScoreboard {
    
	private Game game;
	
	public GameScoreboard(Game game) {
		this.game = game;
		for (me.iHDeveloper.player.Player p : game.getPlayers().get()) {
			setup(p.getPlayer());
		}
	}
	
	public Game getGame(){
		return game;
	}
	
	public void setup(Player p){
		Debug.info("Setuping player "+p.getName());
		Scoreboard sb = p.getScoreboard();
		Team normal = createTeam(sb, "normal");
		Team owner = createTeam(sb, "!!!!!__owner");owner.setPrefix(color("&3&l"));
		Team co_owner = createTeam(sb, "!!!!_co_owner");co_owner.setPrefix(color("&4&l"));
		Team heads = createTeam(sb, "!!!_heads");heads.setPrefix(color("&b&l"));
		Team youtubers = createTeam(sb, "!!!_youtubers");youtubers.setPrefix(color("&c&l"));
		Team builders = createTeam(sb, "!_builders");builders.setPrefix(color("&a&l"));
		Team polices = createTeam(sb, "!_polices");polices.setPrefix(color("&1&l"));
		Team testers = createTeam(sb, "!testers");testers.setPrefix(color("&5&l"));
		Team supports = createTeam(sb, "!supports");supports.setPrefix(color("&e&l"));
		Team vip = createTeam(sb, "vip");vip.setPrefix(color("&6"));
		Team defualt = createTeam(sb, "z_defualt");defualt.setPrefix(color("&9"));
		for (Player player : Bukkit.getOnlinePlayers()) {
			normal.addPlayer(player);
			if(p.hasPermission("tab.type.owner")){owner.addPlayer(player);}
			else if(p.hasPermission("tab.type.co-owner")){co_owner.addPlayer(player);}
			else if(p.hasPermission("tab.type.head")){heads.addPlayer(player);}
			else if(p.hasPermission("tab.type.youtuber")){youtubers.addPlayer(player);}
			else if(p.hasPermission("tab.type.builder")){builders.addPlayer(player);}
			else if(p.hasPermission("tab.type.police")){polices.addPlayer(player);}
			else if(p.hasPermission("tab.type.tester")){testers.addPlayer(player);}
			else if(p.hasPermission("tab.type.support")){supports.addPlayer(player);}
			else if(p.hasPermission("tab.type.vip")){vip.addPlayer(player);}
			else {defualt.addPlayer(player);}
		}
		Objective obj = createObjective(sb, p.getName());
		obj.setDisplayName(color("&e&lSTATS"));
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		/*
		 * 				10
		 * Player		9
		 * <players>	8
		 * 				7
		 * CanStart		6
		 * <Allow> 		5
		 *				4
		 * Map:			3
		 * <map>		2
		 * 				1
		 * */
		
		
		
		// █ █ █ █ █ █
		p.setScoreboard(sb);
	}
	
	private Team createTeam(Scoreboard sb, String name){
		Team t = sb.getTeam(name);
		if(t == null){
			t = sb.registerNewTeam(name);
		}
		return t;
	}
	
	private Objective createObjective(Scoreboard sb, String name){
		Objective obj = sb.getObjective(name);
		if(obj == null){
			obj = sb.registerNewObjective(name, "");
		}else{
			obj.unregister();
			obj = sb.registerNewObjective(name, "");
		}
		return obj;
	}
	
	public Score createScore(Objective o, String t, int p){
		Score s = o.getScore(color(t));
		s.setScore(p);
		return s;
	}
	
	private String color(String format){
		return ChatColor.translateAlternateColorCodes('&', format);
	}
	
}
 