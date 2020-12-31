package de.minefact.plugin.listeners;

import de.minefact.plugin.Vars;
import de.minefact.plugin.game.GameManager;
import de.minefact.plugin.game.Timer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DamageListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if(e.getEntity() instanceof Player) {
            if(e.getEntity().getWorld() == Bukkit.getWorld("world")) {
                e.setCancelled(true);
                Bukkit.broadcastMessage("[DEBUG] Damage in Lobby World");
            }else if(e.getEntity().getWorld() == Bukkit.getWorld("game")) {
                if(!Vars.active) {
                    e.setCancelled(true);
                    Bukkit.broadcastMessage("[DEBUG] Damage in Game World | Challenge not active");
                }
                if((Timer.getTime() % 60) <= 20) {
                    e.setCancelled(true);
                    Bukkit.broadcastMessage("[DEBUG] Damage in Game World | Timer not over 20sec");
                }
                Bukkit.broadcastMessage("[DEBUG] Damage in Game World | Damage executed");
            }
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        e.setDeathMessage("");
        if (Vars.active) {
            Inventory tempInv = e.getEntity().getInventory();
            Player p = e.getEntity();
            ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
            ItemMeta bootMeta = boot.getItemMeta();
            bootMeta.setDisplayName("Death Shoes");
            boot.setItemMeta(bootMeta);
            tempInv.remove(Material.DIAMOND);
            tempInv.remove(Material.DIAMOND_AXE);
            tempInv.remove(Material.DIAMOND_SWORD);
            tempInv.remove(Material.DIAMOND_PICKAXE);
            p.getInventory().setChestplate(null);
            p.getInventory().setBoots(null);
            p.getInventory().setHelmet(null);
            p.getInventory().setLeggings(null);
            p.getInventory().setBoots(boot);

        }else  {
            e.setCancelled(true);
        }
    }


}
