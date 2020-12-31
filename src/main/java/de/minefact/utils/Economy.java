package de.minefact.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Economy {
	
	public static boolean Accountexists(UUID uuid){
		boolean boo = false;
		
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT Money FROM Statistiken WHERE UUID = ?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			boo = rs.next();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boo;
	}
	
	public static void screateAccount(UUID uuid){
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO Statistiken (UUID,Spielername,Money,Rank) VALUES (?,?,?,?)");
			ps.setString(1, uuid.toString());
			ps.setString(2, Bukkit.getOfflinePlayer(uuid).getName());
			ps.setInt(3, 0);
			ps.setInt(4, Bukkit.getOfflinePlayers().length);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteAccount(UUID uuid){
		if(Accountexists(uuid)){
			try {
				PreparedStatement ps = MySQL.getConnection().prepareStatement("DELETE * FROM Statistiken WHERE UUID = ?");
				ps.setString(1, uuid.toString());
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("[MySQL] Der Spieler mit der UUID: " + uuid + " befindet sich nicht in der Datenbank.");
		}
	}
	
	public static Integer getMoney(UUID uuid){
		int integer = -1;
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM Statistiken WHERE UUID = ?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				integer =  rs.getInt("Money");
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return integer;		
	}
	
	public static void giveMoney(UUID uuid, int amount){
		int money = getMoney(uuid);
		money = money + amount;
		
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE Statistiken SET Money = ? WHERE UUID = ?");
			ps.setInt(1, money);
			ps.setString(2, uuid.toString());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public static void takeMoney(UUID uuid, int amount){
		int money = getMoney(uuid);
		money = money - amount;
		
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE Statistiken SET Money = ? WHERE UUID = ?");
			ps.setInt(1, money);
			ps.setString(2, uuid.toString());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void setMoney(UUID uuid, int amount){
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE Statistiken SET Money = ? WHERE UUID = ?");
			ps.setInt(1, amount);
			ps.setString(2, uuid.toString());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void setRank(UUID uuid, int rank){
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE Statistiken SET Rank = ? WHERE UUID = ?");
			ps.setInt(1, rank);
			ps.setString(2, uuid.toString());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Integer getRank(UUID uuid){
		int Integer = -1;
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM Statistiken WHERE UUID = ?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Integer = rs.getInt("Rank");
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Integer;		
	}
	
	public static void sendMoneyActionBar(Player p, String name, UUID uuid){
		ActionBar.sendMessage(p, "§7§lKonstostand von " + name + ": §a§l" + getMoney(uuid) + " Facts");
	}
	
	
	
}
