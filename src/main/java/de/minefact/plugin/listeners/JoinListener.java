package de.minefact.plugin.listeners;


import de.minefact.plugin.Vars;
import de.minefact.plugin.lobby.Hotbar;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if(!Vars.active) {
            if(e.getPlayer() instanceof Player) {
                Player p = e.getPlayer();
                p.sendMessage("[Debug] Joined");
                Hotbar.addHotbar(p);
                if(!(Vars.modeSize == 4)) {
                    int modesize = Vars.modeSize;
                    int plteam1 = Vars.Team1;
                    int plteam2 = Vars.Team2;
                    if(plteam1 % 2 == 0) {
                       if(plteam2 % 2 == 0) {
                           int modesizeold = modesize;
                           modesize = modesizeold + 2;
                           sendMsg(ChatColor.GRAY + "The Team size was expanded");


                           Vars.PlayersTeam1.add(p);
                           Vars.Team1++;

                       }else {
                           Vars.PlayersTeam2.add(p);
                           Vars.Team2++;
                       }
                    }else {
                        if(plteam1 % 2 == 0) {
                            int modesizeold = modesize;
                            modesize = modesizeold + 2;
                            sendMsg(ChatColor.GRAY + "The Team size was expanded");

                            Vars.PlayersTeam2.add(p);
                            Vars.Team2++;

                        }else {
                            Vars.PlayersTeam1.add(p);
                            Vars.Team1++;
                        }
                    }
                    Vars.modeSize = modesize;
                }

            }
        }

    }


    private static void sendMsg(String message) {
        for(Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage(message);
        }
    }


}
