package de.minefact.plugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Vars {

    public static int challengesToPlay;

    public static boolean active; // is the challenge active? (not waiting)
    public static int modeSize; // Mode Tye
    public static World gameWorld; // Name of the Main Game world
    public static String gameWorldName;
    public static Location lobbySpawn;

    public static List<Player> onlinePlayers = new ArrayList<Player>();

    public static Location spawnTeam1; // spawn of team1
    public static int Team1; // count of team1
    public static List<Player> PlayersTeam1 = new ArrayList<Player>(); // List of all players

    public static Location spawnTeam2; // spawn of team2
    public static int Team2; // count of team2
    public static List<Player> PlayersTeam2 = new ArrayList<Player>(); // List of all players

    public static String challenge; // What challenge is played?
    public static int challengeId;
    public static int winnerTeam; // What challenge is played?

    public static void init() {

        challengesToPlay = 5;

        gameWorld = Bukkit.getServer().getWorld("game");
        lobbySpawn = Bukkit.getWorld("world").getSpawnLocation();
        gameWorldName = "game";


        double x1 = 300;
        double z1 = 300;
        spawnTeam1 = new Location(gameWorld, x1, 255, z1);

        double x2 = -300;
        double z2 = -300;
        spawnTeam2 = new Location(gameWorld, x2, 255, z2);

        for(Player p : Bukkit.getOnlinePlayers()) {
            onlinePlayers.add(p);
        }
    }

}
