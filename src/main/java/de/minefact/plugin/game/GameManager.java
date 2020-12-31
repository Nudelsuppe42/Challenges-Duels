package de.minefact.plugin.game;

import de.minefact.plugin.Vars;
import de.minefact.plugin.game.challenges.BeatGame;
import de.minefact.plugin.game.challenges.DiamondArmor;
import de.minefact.plugin.game.challenges.ReturnToSender;
import de.minefact.plugin.lobby.Hotbar;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class GameManager {

    static boolean isstarting;

    public static void start(int challenge) {
        Vars.active = true;
        isstarting = true;
        currentChallenge(challenge);
        Timer.start();

        for(Player p : Vars.PlayersTeam1) {
            p.getInventory().clear();
            p.teleport(Vars.spawnTeam1);
            p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20*10, 255));
            p.setGameMode(GameMode.SURVIVAL);
            p.sendMessage(ChatColor.DARK_GRAY + "--------------------------------------");
            p.sendMessage(ChatColor.GRAY + "Team " + ChatColor.GOLD + "Team 1");
            p.sendMessage(ChatColor.GRAY + "Location: " + ChatColor.GOLD + Vars.spawnTeam1.getX() + " " + Vars.spawnTeam1.getY() + " " + Vars.spawnTeam1.getZ());
            p.sendMessage(ChatColor.GRAY + "Challenge: " + ChatColor.GOLD + Vars.challenge);
            p.sendMessage(ChatColor.DARK_GRAY + "--------------------------------------");
            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 30,1);
            p.sendTitle(ChatColor.GOLD + "Game has begone","", 2,60,2);
        }
        for(Player p : Vars.PlayersTeam2) {
            p.getInventory().clear();
            p.teleport(Vars.spawnTeam2);
            p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20*10, 255));
            p.setGameMode(GameMode.SURVIVAL);
            p.sendMessage(ChatColor.DARK_GRAY + "--------------------------------------");
            p.sendMessage(ChatColor.GRAY + "Team " + ChatColor.GOLD + "Team 2");
            p.sendMessage(ChatColor.GRAY + "Location: " + ChatColor.GOLD + Vars.spawnTeam2.getX() + " " + Vars.spawnTeam2.getY() + " " + Vars.spawnTeam2.getZ());
            p.sendMessage(ChatColor.GRAY + "Challenge: " + ChatColor.GOLD + Vars.challenge);
            p.sendMessage(ChatColor.DARK_GRAY + "--------------------------------------");
            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 30,1);
            p.sendTitle(ChatColor.GOLD + "Game has begone","", 2,60,2);
        }
    }

    public static void stop(Player finalPlayer) {
        Vars.active = false;
        Timer.stop();
        for(Player p : Bukkit.getOnlinePlayers()) {

            p.setGameMode(GameMode.ADVENTURE);
            p.teleport(Vars.lobbySpawn);
            Hotbar.addHotbar(p);


        }

        if(Vars.PlayersTeam1.contains(finalPlayer)) {
            Vars.winnerTeam = 1;
            for(Player p : Vars.PlayersTeam1) {
                p.spawnParticle(Particle.VILLAGER_HAPPY,p.getLocation(), 20);
                p.sendActionBar(ChatColor.GRAY + "You have " + ChatColor.GOLD + "won " + ChatColor.GRAY + "the game!");
                p.setFlying(true);
            }
        }else {
            Vars.winnerTeam = 2;
            for(Player p : Vars.PlayersTeam2) {
                p.spawnParticle(Particle.VILLAGER_HAPPY,p.getLocation(), 20);
                p.sendActionBar(ChatColor.GRAY + "You have " + ChatColor.GOLD + "won " + ChatColor.GRAY + "the game!");
                p.setFlying(true);
            }
        }
        Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "Team " + ChatColor.GOLD + Vars.winnerTeam + ChatColor.GRAY + " has won the Game");
        Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "The Players of each Team are displayed in the Actionbar");
        for(Player p : Bukkit.getOnlinePlayers()) {
            for(int i = 0; i < Vars.PlayersTeam1.size(); i++) {
                p.sendActionBar(ChatColor.GRAY + "Team 1: " + ChatColor.GOLD + Vars.PlayersTeam1.get(i));
            }
        }

        for(Player p : Bukkit.getOnlinePlayers()) {
            for(int i = 0; i < Vars.PlayersTeam2.size(); i++) {
                p.sendActionBar(ChatColor.GRAY + "Team 2: " + ChatColor.GOLD + Vars.PlayersTeam2.get(i));
            }
        }
    }

    public static void stop() {
        Vars.active = false;
        Timer.stop();
        for(Player p : Bukkit.getOnlinePlayers()) {

            Hotbar.addHotbar(p);
            p.setGameMode(GameMode.ADVENTURE);
            p.teleport(Vars.lobbySpawn);
            p.spawnParticle(Particle.VILLAGER_HAPPY,p.getLocation(), 20);
            p.sendActionBar(ChatColor.GRAY + "You have " + ChatColor.GOLD + "won " + ChatColor.GRAY + "the game!");
        }


        Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "Team " + ChatColor.GOLD + Vars.winnerTeam + ChatColor.GRAY + " has won the Game");
        Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "The Players of each Team are displayed in the Actionbar");
        for(Player p : Bukkit.getOnlinePlayers()) {
            for(int i = 0; i < Vars.PlayersTeam1.size(); i++) {
                p.sendActionBar(ChatColor.GRAY + "Team 1: " + ChatColor.GOLD + Vars.PlayersTeam1.get(i));
            }
        }

        for(Player p : Bukkit.getOnlinePlayers()) {
            for(int i = 0; i < Vars.PlayersTeam2.size(); i++) {
                p.sendActionBar(ChatColor.GRAY + "Team 2: " + ChatColor.GOLD + Vars.PlayersTeam2.get(i));
            }
        }
    }

    public static int getFirstTeam() {
        int team = 0;
        switch (Vars.challengeId) {
            case 1:
                // team = BeatGame.getLeader();
                break;
            case 2:
                //team = ReturnToSender.getLeader();
                break;
            case 3:
                //team = RaidChallenge.getLeader();
                break;
            case 4:
                //team = DiamondArmor.getLeader();
                break;
            //case 5:
               // team = BeatGame.getLeader();
               // break;
        }
        return team;
    }

    public static int getSeccondTeam() {
        int team;
        if(getFirstTeam() == 1) {
            team = 2;
        }else if(getFirstTeam() == 0){
            team = 0;
        }else {
            team = 1;
        }
        return team;
    }

    public static boolean isStarting() {
        return isstarting;
    }

    public static String currentChallenge(Integer challengeID) {
        switch (challengeID) {
            case 1:
                Vars.challenge = "Beat the game faster than the other Team";
                Vars.challengeId = 1;
                //BeatGame.start();
                break;
            case 2:
                Vars.challenge = "Get a full Diamond Armor";
                Vars.challengeId = 2;
                DiamondArmor.thisOne = true;
                break;
            case 3:
                Vars.challenge = "Be the first who destroys a ghast with a fireball";
                Vars.challengeId = 3;
                ReturnToSender.thisOne = true;
                break;
            case 4:
                Vars.challenge = "Successfully defend a village from a raid faster than the others";
                Vars.challengeId = 4;
                break;
            case 5:
                Vars.challenge = "Be the first Team which destroyed 1000 Blocks";
                Vars.challengeId = 5;
                break;
        }
        return Vars.challenge;
    }

}
