package de.minefact.plugin.components;

import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;

import de.minefact.Main;
import de.minefact.utils.Config;

public class ConfigManager {

	public static void readData() {
        FileConfiguration cfg = Config.getFileConfiguration("config");

        Main.builder.setPrefix(cfg.getString("Server.Prefix").replace("&", "§"));
	}
	
	public static void setStandard() {
		FileConfiguration cfg = Config.getFileConfiguration("config");
	    cfg.options().copyDefaults(true); 
	    
	    cfg.addDefault("MySQL.Host", "<host>");
	    cfg.addDefault("MySQL.Port", 3306);
	    cfg.addDefault("MySQL.DataBase", "<database>");
	    cfg.addDefault("MySQL.Username", "<username>");
	    cfg.addDefault("MySQL.Passwort", "<passwort>");
	    
	    cfg.addDefault("Server.Prefix", "&6Server >> &7");
	    
	    cfg.addDefault("Server.Spawn.World", "world");
	    cfg.addDefault("Server.Spawn.X", 0);
	    cfg.addDefault("Server.Spawn.Y", 1);
	    cfg.addDefault("Server.Spawn.Z", 0);
	    cfg.addDefault("Server.Spawn.Yaw", 0);
	    cfg.addDefault("Server.Spawn.Pitch", 0);
	    
	    try {
	        cfg.save(Config.getFile("config"));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
