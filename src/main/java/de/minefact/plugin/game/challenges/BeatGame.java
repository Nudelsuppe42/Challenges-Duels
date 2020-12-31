package de.minefact.plugin.game.challenges;

import de.minefact.plugin.Debug;
import de.minefact.plugin.game.GameManager;
import org.bukkit.GameMode;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class BeatGame implements Listener {

    @EventHandler
    public void onDeath(EntityDamageByEntityEvent e) {
        if(e.getEntityType() == EntityType.ENDER_DRAGON) {
            if(e.getDamager() instanceof Player) {
                    Player p = (Player) e.getDamager();
                    GameManager.stop(p);
            }

        }
    }
}


