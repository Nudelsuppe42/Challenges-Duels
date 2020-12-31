package de.minefact.plugin.components;

import org.bukkit.Location;

import de.minefact.utils.Config;

public class Spawn {

	public static Location spawnLocation;
	
	public static void setSpawnLocation() {
		spawnLocation = Config.getLocation("config", "Server.Spawn");
	}
}
