package de.minefact.plugin;

import java.util.HashMap;
import java.util.Random;

import de.minefact.plugin.commands.prestart_command;
import de.minefact.plugin.commands.world_command;
import de.minefact.plugin.game.GameManager;
import de.minefact.plugin.game.Timer;
import de.minefact.plugin.game.challenges.BeatGame;
import de.minefact.plugin.game.challenges.DiamondArmor;
import de.minefact.plugin.game.challenges.RaidChallenge;
import de.minefact.plugin.game.challenges.ReturnToSender;
import de.minefact.plugin.listeners.DamageListener;
import de.minefact.plugin.listeners.JoinListener;
import de.minefact.plugin.listeners.VoteInvLisener;
import de.minefact.plugin.lobby.Hotbar;
import org.bukkit.Bukkit;

import de.minefact.Main;
import de.minefact.plugin.commands.help_command;
import de.minefact.plugin.components.AFKSystem;
import de.minefact.plugin.components.ConfigManager;
import de.minefact.plugin.components.Spawn;
import de.minefact.plugin.listeners.StandardPlugin;
import org.bukkit.World;
import org.bukkit.WorldCreator;

public class Plugin {
		
	private long time;
	private String prefix;
	private WorldCreator worldCreator;

	public HashMap<String, String[]> serverPlayer = new HashMap<String, String[]>();
	
	
	public Plugin() {}
	
	public void start() {
		registerCommands();
		registerListeners();
		startTimer();
		worldCreator = new WorldCreator("game");
		
		ConfigManager.setStandard();
		ConfigManager.readData();

		worldCreator.environment(World.Environment.NORMAL);
		worldCreator.name("game");
		Bukkit.getServer().createWorld(worldCreator);
		
		Spawn.setSpawnLocation();
		
		Vars.init();

		Main.instance.getServer().getMessenger().registerOutgoingPluginChannel(Main.instance, "BungeeCord");
		Main.instance.getServer().getMessenger().registerIncomingPluginChannel(Main.instance, "BungeeCord", Main.instance);

		Random random = new Random();
		int randomInt = random.nextInt(Vars.challengesToPlay);
		GameManager.currentChallenge(randomInt);
	    
	}
	
	
	
	/** This method is called every second.
	 *  It contains all systems that have to run once a second.
	 */
	private void tickSeconds() {
		AFKSystem.tick();
	}
	
	
	/** The main Timer of the plugin that runs every tick.
	 *  It calls the tick() function.
	 */
	private void startTimer() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable() {
			
			@Override
			public void run() {
				time++;
				
				// Alle 5 Sekunden
				if(time%100 == 0){ 	
					
					
				// Jede Sekunde	
				}else if(time%20 == 0){
					Timer.second();
					tickSeconds();
					
				}
				
				// Jeden Tick

				
			}
		},0,0);
	}

	
	/** Registers all Commands of the plugin. */
	private void registerCommands() {
		Main.instance.getCommand("help").setExecutor(new help_command());
		Main.instance.getCommand("prestart").setExecutor(new prestart_command());
		Main.instance.getCommand("world").setExecutor(new world_command());
	}

	
	/** Registers all Listeners of the plugin. */
	private void registerListeners() {
		Bukkit.getPluginManager().registerEvents(new StandardPlugin(), Main.instance);
		Bukkit.getPluginManager().registerEvents(new DamageListener(), Main.instance);
		Bukkit.getPluginManager().registerEvents(new JoinListener(), Main.instance);
		Bukkit.getPluginManager().registerEvents(new VoteInvLisener(), Main.instance);

		Bukkit.getPluginManager().registerEvents(new Hotbar(), Main.instance);

		Bukkit.getPluginManager().registerEvents(new BeatGame(), Main.instance);
		Bukkit.getPluginManager().registerEvents(new DiamondArmor(), Main.instance);
		Bukkit.getPluginManager().registerEvents(new RaidChallenge(), Main.instance);
		Bukkit.getPluginManager().registerEvents(new ReturnToSender(), Main.instance);
	}

	
	
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}
