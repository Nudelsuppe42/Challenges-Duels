package de.minefact.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

public class Debug {

    public static void sendDebugMessage(String msg, Player player) {


        player.sendMessage("&c[Debug]&r " + msg);
        System.out.println(ChatColor.RED + "[Debug] &r" + msg);

    }

    public static void sendDebugMessage(String msg, List<Player> players) {

        for(Player ply : players) {
            ply.sendMessage("&c[Debug]&r " + msg);
        }
        System.out.println(ChatColor.RED + "[Debug] &r" + msg);

    }

    public static void sendDebugMessage(String msg) {


        for(Player ply : Bukkit.getOnlinePlayers()) {
            ply.sendMessage("&c[Debug]&r " + msg);
        }
        System.out.println(ChatColor.RED + "[Debug] &r" + msg);

    }

}
