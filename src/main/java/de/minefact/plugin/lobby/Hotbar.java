package de.minefact.plugin.lobby;

import de.minefact.plugin.Vars;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Hotbar implements Listener {

    public static void addHotbar(Player p) {
        if(!Vars.active) {
            p.getInventory().clear();

            Inventory inv = p.getInventory();
            ItemStack item;
            ItemMeta meta;

            item = new ItemStack(Material.BIRCH_DOOR);
            meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.RED + "Leave Game");
            item.setItemMeta(meta);
            inv.setItem(8, item);

            item.setType(Material.HOPPER);
            meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GOLD + "Skip Challenge");
            item.setItemMeta(meta);
            inv.setItem(0, item);

        }


    }

    @EventHandler
    public static void onDrag(InventoryDragEvent e) {
        if(!Vars.active) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public static void onDrop(PlayerDropItemEvent e) {
        if(!Vars.active) {
            e.setCancelled(true);
        }
    }






}
