package me.iHDeveloper.map;

import java.util.Collection;
import java.util.HashMap;


public class MapAPI {
    
    protected static java.util.Map<String, Map> maps = new HashMap<>();
    
    public static Collection<Map> getMaps(){
        return maps.values();
    }
    
    public static Map create(String name){
        Map map = new Map(name);
        maps.put(name, map); // add map to the list
        return map;
    }
    
    public static void delete(String name){
        maps.remove(name);
    }
    
    public static Map get(String name){
        return maps.get(name);
    }
    
    protected static void update(String name, Map map){
        maps.put(name, map);
    }
    
}
