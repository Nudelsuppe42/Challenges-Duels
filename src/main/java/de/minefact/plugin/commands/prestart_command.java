package de.minefact.plugin.commands;

import de.minefact.plugin.Vars;
import de.minefact.plugin.game.GameManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class prestart_command implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player && sender.hasPermission("challenges.duels.prestart") && args.length == 1) {
            Player p = (Player) sender;
            if (Vars.active) {
                if(args[0].equalsIgnoreCase("stop")) {
                    GameManager.stop();
                    p.sendMessage(ChatColor.RED + "The Challenge is stoping");
                }else if(args[0].equalsIgnoreCase("end")){
                    GameManager.stop(p);
                }else {
                    p.sendMessage(ChatColor.RED + "The Challenge is already active");
                }
                    return true;
            }else {
                if(args[0].equalsIgnoreCase("start")){
                    Random rdm = new Random();
                    GameManager.start(rdm.nextInt(Vars.challengesToPlay));
                    p.sendMessage(ChatColor.RED + "The Challenge is starting");
                }
                return true;
            }

        }
        sender.sendMessage(ChatColor.RED + "Wrong usage or lacking Permissions!");
        sender.sendMessage(ChatColor.RED + "/prestart <ChallengeID>");
        return false;
    }
}
