package de.minefact.plugin.listeners;

import de.minefact.plugin.Vars;
import de.minefact.plugin.lobby.VoteInv;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class VoteInvLisener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if(!Vars.active) {
            if(e.getInventory() == VoteInv.getInv()) {
                if(e.getInventory().getType() == InventoryType.HOPPER) {
                    Player p = (Player) e.getWhoClicked();
                    int slot = e.getSlot() + 1;
                    VoteInv.vote(p, slot);
                    p.closeInventory();
                }
        }

        }
    }




}
