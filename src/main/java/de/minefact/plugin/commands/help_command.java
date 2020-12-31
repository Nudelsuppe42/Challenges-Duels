package de.minefact.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.minefact.plugin.components.Language;

public class help_command implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		
		sender.sendMessage(" ");
		sender.sendMessage("§7------- §7§lHelp-Befehle §7-------");
		sender.sendMessage(" ");
		sender.sendMessage(" ");
		sender.sendMessage("§7----------------------------");
		sender.sendMessage(" ");
		
		return true;
	}
}
