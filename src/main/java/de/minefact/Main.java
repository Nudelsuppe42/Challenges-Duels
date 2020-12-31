package de.minefact;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import de.minefact.plugin.Plugin;


public class Main extends JavaPlugin implements PluginMessageListener{
	
	public static Main instance;
	public static Plugin builder;
	
	@Override
	public void onEnable(){
		instance = this;
		builder = new Plugin();
		builder.start();
		
		System.out.println("[Builder] Plugin started.");
	}
	
	@Override
	public void onDisable(){	
		System.out.println("[Builder] Plugin stopped.");
	}

	@Override
	public void onPluginMessageReceived(String arg0, Player arg1, byte[] arg2) {
		
	}

	public static Plugin getBuilder() {
		return builder;
	}

	public static void setBuilder(Plugin builder) {
		Main.builder = builder;
	}
}
