package me.iHDeveloper.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;


public class ConsoleChat {
 
    public static void info(String message){
        send("&bINFO:", message);
    }
    
    public static void warn(String message){
        send("&eWARN:", message);
    }
    
    public static void err(String message){
        send("&4ERR:", message);
    }
    
    private static void send(String prefix, String message){
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage(color(prefix+" &r"+message));
    }
    
    private static String color(String format){
        return ChatColor.translateAlternateColorCodes('&', format);
    }
    
}
