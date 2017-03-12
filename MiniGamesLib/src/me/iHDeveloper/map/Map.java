package me.iHDeveloper.map;

public class Map {
    
    private final MapProfile profile;
    private final String name;
    
    public Map(String name) {
        this.name = name;
        this.profile = new MapProfile(this);
    }
    
    
    public MapProfile getProfile(){
        return profile;
    }
    
    public String getName(){
        return name;
    }
    
}
