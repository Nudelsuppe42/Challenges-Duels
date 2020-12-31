package de.minefact.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class world_command implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length >= 1) {
            if(args.length == 2) {
                if(args[0].equalsIgnoreCase("lobby") && args[1].equalsIgnoreCase("all")) {
                    Location loc = Bukkit.getWorld("world").getSpawnLocation();
                    for(Player pl : Bukkit.getOnlinePlayers()) {
                        pl.teleport(loc);
                        pl.sendMessage(ChatColor.GRAY + "You got teleported");
                    }
                }
            }
        }
        return false;
    }
}
