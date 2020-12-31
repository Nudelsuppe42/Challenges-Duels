package de.minefact.plugin.lobby;

import de.minefact.plugin.Vars;
import de.minefact.plugin.game.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class VoteInv {

    static int votes1;
    static int votes2;
    static int votes3;
    static int votes4;
    static int votes5;
    static boolean voting;

    public static Inventory getInv() {
        Inventory inv =  Bukkit.createInventory(null, InventoryType.HOPPER, ChatColor.GOLD + "Votean other Challenge");
        ItemStack item = new ItemStack(Material.PAPER);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GRAY + "Beat the Game");
        item.setItemMeta(meta);
        inv.setItem(0,item);

        meta.setDisplayName(ChatColor.GRAY + "get a full Diamond-Armor");
        item.setItemMeta(meta);
        inv.setItem(1,item);

        meta.setDisplayName(ChatColor.GRAY + "Defeat a Raid");
        item.setItemMeta(meta);
        inv.setItem(3,item);

        meta.setDisplayName(ChatColor.GRAY + "Return a Fireball to a Ghast");
        item.setItemMeta(meta);
        inv.setItem(4,item);

        meta.setDisplayName(ChatColor.GRAY + "Destroy 1000 Blocks");
        item.setItemMeta(meta);
        inv.setItem(5,item);
        return inv;
    }

    public static void openInv() {
        Inventory inv =  Bukkit.createInventory(null, InventoryType.HOPPER, ChatColor.GOLD + "Votean other Challenge");
        ItemStack item = new ItemStack(Material.PAPER);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GRAY + "Beat the Game");
        item.setItemMeta(meta);
        inv.setItem(0,item);

        meta.setDisplayName(ChatColor.GRAY + "get a full Diamond-Armor");
        item.setItemMeta(meta);
        inv.setItem(1,item);

        meta.setDisplayName(ChatColor.GRAY + "Defeat a Raid");
        item.setItemMeta(meta);
        inv.setItem(3,item);

        meta.setDisplayName(ChatColor.GRAY + "Return a Fireball to a Ghast");
        item.setItemMeta(meta);
        inv.setItem(4,item);

        meta.setDisplayName(ChatColor.GRAY + "Destroy 1000 Blocks");
        item.setItemMeta(meta);
        inv.setItem(5,item);

        for(Player pl : Vars.onlinePlayers) {
            pl.openInventory(inv);
            pl.sendActionBar(ChatColor.GRAY + "Voting ...");
        }

    }

    public static void closeInv() {
        for(Player pl : Vars.onlinePlayers) {
            if(pl.getOpenInventory() == getInv()) {
                pl.closeInventory();
            }

        }
    }

    public static void vote(Player player, int id) {
        player.sendMessage(ChatColor.GRAY + "You have voted. Please wait for the other Users!");
        if (id == 1||id ==  2 ||id ==  3||id == 4||id == 5) {
            if(voting) {
                switch (id) {
                    case 1:
                        votes1++;
                        break;
                    case 2:
                        votes2++;
                        break;
                    case 3:
                        votes3++;
                        break;
                    case 4:
                        votes4++;
                        break;
                    case 5:
                        votes5++;
                        break;
                }
                if (votes1 >= Vars.onlinePlayers.size() || votes2 >= Vars.onlinePlayers.size() || votes3 >= Vars.onlinePlayers.size() ||
                        votes4 >= Vars.onlinePlayers.size() || votes5 >= Vars.onlinePlayers.size()) {

                    List<Integer> results = null;
                    results.add(votes1);
                    results.add(votes2);
                    results.add(votes3);
                    results.add(votes1);
                    results.add(votes1);
                    Collections.sort(results);

                    GameManager.start(results.get(0));


                }
            }
        }
    }


}
