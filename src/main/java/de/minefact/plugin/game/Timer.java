package de.minefact.plugin.game;

import de.minefact.plugin.Vars;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

public class Timer {

    private static int elapsedTime;
    private static int seconds;
    private static int minutes;
    private static boolean active;

    public static void second() {
        if(Vars.active && active) {
            elapsedTime += 1;

            int hours = (elapsedTime / 72000);
            int minutes = (elapsedTime / 60) % 60;
            int seconds = elapsedTime % 60;

            StringBuilder msg = new StringBuilder(ChatColor.GRAY + "Elapsed Time: " + ChatColor.GOLD);
            msg.append(String.format("%02d", hours)).append(":");
            msg.append(String.format("%02d", minutes)).append(":");
            msg.append(String.format("%02d", seconds));

            for (Player p : Bukkit.getOnlinePlayers()) {
                p.sendActionBar(msg.toString());
            }
        }
    }

    public static  void stop() {
        active = false;
        elapsedTime = 0;
        for(Player p : Vars.onlinePlayers) {
            p.sendActionBar();
        }
    }

    public static void start() {
        active = true;
    }

    public static int getTime() {
        return elapsedTime;
    }
}
