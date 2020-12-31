package de.minefact.plugin.lobby;

import de.minefact.plugin.Vars;
import org.bukkit.entity.Player;

public class LobbyManager {

    static int skippers;

    public static void addPlayer() {


    }

    public static void removePlayer() {

    }

    public static void addSkipper(Player p) {
        skippers++;
        if(skippers*2 >= Vars.onlinePlayers.size()) {

        }
    }


}
