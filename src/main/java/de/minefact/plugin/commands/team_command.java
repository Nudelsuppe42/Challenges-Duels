package de.minefact.plugin.commands;

import de.minefact.plugin.Vars;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class team_command implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length == 2) {
            if(args[0].equalsIgnoreCase("1")) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if(args[1].equalsIgnoreCase(p.getName())) {
                        if(!Vars.PlayersTeam1.contains(p)) {
                            Vars.PlayersTeam1.add(p);
                            Vars.Team1++;

                        }
                    }
                }
            }
            if(args[0].equalsIgnoreCase("2")) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if(args[1].equalsIgnoreCase(p.getName())) {
                        if(!Vars.PlayersTeam2.contains(p)) {
                            Vars.PlayersTeam2.add(p);
                            Vars.Team2++;

                        }
                    }
                }
            }
        }
        return false;
    }
}
