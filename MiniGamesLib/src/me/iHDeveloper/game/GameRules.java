package me.iHDeveloper.game;

import org.bukkit.WeatherType;


public class GameRules {
    
	private boolean break_block;
	private boolean place_block;
	private boolean item_drop;
	private boolean item_pickup;
	private boolean pvp;
	private WeatherType weather;
	private int time;
	private boolean build;
	private boolean hunger;
	private boolean damage;
	
	public GameRules() {
		// Set by lobby
		setBlockBreak(false);
		setBlockPlace(false);
		setPvP(false);
		setBuild(false);
		setItemDrop(false);
		setItemPickup(false);
		setTime(5000);
		setWeather(WeatherType.CLEAR);
		setHunger(false);
		setDamage(false);
	}
	
	public void setBlockBreak(boolean val){
		break_block = val;
	}
	
	public void setBlockPlace(boolean val){
		place_block = val;
	}
	
	public void setBuild(boolean val){
		build = val;
	}
	
	public void setPvP(boolean val){
		pvp = val;
	}
	
	public void setItemDrop(boolean val){
		item_drop = val;
	}
	
	public void setItemPickup(boolean val){
		item_pickup = val;
	}
	
	public void setWeather(WeatherType val){
		weather = val;
	}
	
	public void setTime(int val){
		time = val;
	}
	
	public void setHunger(boolean val){
		hunger = val;
	}
	
	public void setDamage(boolean val){
		damage = val;
	}
	
	public boolean breakBlocks(){
		return break_block;
	}
	
	public boolean placeBlocks(){
		return place_block;
	}
	
	public boolean dropItem(){
		return item_drop;
	}
	
	public boolean pickupItem(){
		return item_pickup;
	}
	
	public boolean pvp(){
		return pvp;
	}
	
	public int time(){
		return time;
	}
	
	public WeatherType weather(){
		return weather;
	}
	
	public boolean hunger(){
		return hunger;
	}
	
	public boolean damage(){
		return damage;
	}
	
	public boolean build(){
		return build;
	}
	
}
