package de.minefact.plugin.components;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import de.minefact.Main;
import de.minefact.utils.ActionBar;
import de.minefact.utils.Economy;
import de.minefact.utils.Permissions;

public class AFKSystem implements Listener{
	
	public static HashMap<Player, Float> yaw = new HashMap<Player, Float>();
	public static HashMap<Player, Integer> AFKtime = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> time = new HashMap<Player, Integer>();
	public static HashMap<Player, Boolean> bewegt = new HashMap<Player, Boolean>();
	
	public static HashMap<Player, Boolean> isAfk = new HashMap<Player, Boolean>();
	public static int i = 18;
	
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		if(e.getPlayer().getVehicle() != null)
			return;
		
		Player p = e.getPlayer();
		float x = e.getPlayer().getLocation().getYaw();
		
		if(!yaw.containsKey(p)){
			yaw.put(p, x);
			return;
		}
		
		if(yaw.get(p) != x){
			yaw.remove(p);
			yaw.put(p, x);
			if(!bewegt.containsKey(p)){
				bewegt.put(p, true);
			}
		}
		
	}

	public static void tick() {
		i++;
		if(i >= 20){
			i = 0;
			Scoreboard.updateTabList();
		}
		
		
		for(Player p : Bukkit.getOnlinePlayers()){
			if(bewegt.containsKey(p)){
				if(AFKtime.containsKey(p))
				AFKtime.remove(p);
				
				if(isAfk.containsKey(p)){
					isAfk.remove(p);
					Scoreboard.updateTabList();
				}
				
				if(time.containsKey(p)){
					
					int x = time.get(p);
					x++;

					time.remove(p);
					if(x == 60){
						UUID uuid = p.getUniqueId();
						
						if(p.hasPermission(Permissions.PermPremium)){
							double random = Math.random() * 3;
							
							if(random < 1){
								Economy.giveMoney(uuid, 2);
								ActionBar.sendMessage(p, "§7+§a2 §7Facts");
							}else{
								Economy.giveMoney(uuid, 1);
								ActionBar.sendMessage(p, "§7+§a1 §7Fact");
							}
						}else{
							Economy.giveMoney(uuid, 1);
							ActionBar.sendMessage(p, "§7+§a1 §7Fact");
						}
						
						Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
							@Override
							public void run() {
								Economy.sendMoneyActionBar(p, p.getName(), uuid);
							}
						},40);
					}else{
						time.put(p, x);		
					}
				}else{
					time.put(p, 1);
				}
			}else{
				if(AFKtime.containsKey(p)){
					
					int x = AFKtime.get(p);
					x++;
					AFKtime.remove(p);
					
					if(x >= 180){
						if(!isAfk.containsKey(p)){
							isAfk.put(p, true);
							Scoreboard.updateTabList();
						}
					}
					
					if(x == 600){
						/*if(!p.hasPermission(main.PermPremium)){
							p.kickPlayer("Du hast dich zulange nicht bewegt.");
						}*/
					}else{
						AFKtime.put(p, x);		
					}
				}else{
					AFKtime.put(p, 1);
				}
			}
		}	
		bewegt.clear();
	}
}
