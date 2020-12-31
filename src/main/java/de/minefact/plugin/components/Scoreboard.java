package de.minefact.plugin.components;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import de.minefact.utils.Permissions;


public class Scoreboard {
	
	@SuppressWarnings("deprecation")
	public static void updateTabList(){
		org.bukkit.scoreboard.Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
		
		for(Player p : Bukkit.getOnlinePlayers()){
			String teamName = getPrefixTeamName(p) + p.getName();
			teamName = teamName.substring(0, Math.min(teamName.length(), 16));
			
			Team team = scoreboard.getTeam(teamName) == null 
						? scoreboard.registerNewTeam(teamName) 
						: scoreboard.getTeam(teamName);
			
			if(p.hasPermission(Permissions.PermOwner)) 
				team.setPrefix("§4Owner §7| §4");
			else if(p.hasPermission(Permissions.PermAdmin)) 
				team.setPrefix("§cAdmin §7| §c");
			else if(p.hasPermission(Permissions.PermModerator)) 
				team.setPrefix("§3Mod §7| §3");
			else if(p.hasPermission(Permissions.PermYoutuber)) 
				team.setPrefix("§5");
			else if(p.hasPermission(Permissions.PermDeveloper)) 
				team.setPrefix("§bDev. §7| §b");
			else if(p.hasPermission(Permissions.PermSupporter)) 
				team.setPrefix("§9Support §7| §9");
			else if(p.hasPermission(Permissions.PermBuilder)) 
				team.setPrefix("§1Builder §7| §1");
			else if(p.hasPermission(Permissions.PermDonator)) 
				team.setPrefix("§6VIP §7| §6");
			else if(p.hasPermission(Permissions.PermPremium))
				team.setPrefix("§6");
			else
				team.setPrefix("§a");
			
			team.setColor(Permissions.getPrefixChatColor(p));
			team = testForAFK(p, team);
			
			if(!team.hasPlayer(p))
			team.addPlayer(p);
		}
		
		for(Player p : Bukkit.getOnlinePlayers()){			
			p.setScoreboard(scoreboard);
		}
	}
	
	private static Team testForAFK(Player p, Team team){
		if(AFKSystem.isAfk.containsKey(p)){
			team.setSuffix(" §7[§eAFK§7]");
		}else{
			team.setSuffix("");
		}
		
		return team;
	}
	
	private static String getPrefixTeamName(Player p) {
		if(p.hasPermission(Permissions.PermOwner)) 
			return "a_";
		else if(p.hasPermission(Permissions.PermAdmin)) 
			return "b_";
		else if(p.hasPermission(Permissions.PermModerator)) 
			return "c_";
		else if(p.hasPermission(Permissions.PermYoutuber)) 
			return "d_";
		else if(p.hasPermission(Permissions.PermDeveloper)) 
			return "e_";
		else if(p.hasPermission(Permissions.PermSupporter)) 
			return "f_";
		else if(p.hasPermission(Permissions.PermBuilder)) 
			return "g_";
		else if(p.hasPermission(Permissions.PermDonator)) 
			return "h_";
		else if(p.hasPermission(Permissions.PermPremium))
			return "i_";
		else
			return "j_";
	}
}
