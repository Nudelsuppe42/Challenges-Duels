package de.minefact.utils;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class ActionBar {
	public static void sendMessage(Player p, String msg) {
	    /*String s = ChatColor.translateAlternateColorCodes('&', msg);
	    IChatBaseComponent icbc = ChatSerializer.a("{\"text\": \"" + s + 
	      "\"}");
	    PacketPlayOutChat bar = new PacketPlayOutChat(icbc);
	    ((CraftPlayer)p).getHandle().playerConnection.sendPacket(bar);
	    */
	    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(msg));
	}
}
