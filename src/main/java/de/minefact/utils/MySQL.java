package de.minefact.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


public class MySQL {
	public static Connection con;
	public static String host;
	public static String port;
	public static String username;
	public static String passwort;
	public static String database;
	
	
	public static void connect(){
		if(host.equals("<host>")) {
			System.out.println("§cPlease configure the MySQL Server.");
			return;
		}
		
		if(!isConnected()){						
			try {
				con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database , username, passwort);
				System.out.println("§a[MySQL] Verbindung aufgebaut.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void disconnect(){
		if(isConnected()){
			try {
				con.close();
				System.out.println("§a[MySQL] Verbindung geschlossen.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean isConnected(){
		return (con == null ? false : true);
		
	}
	
	public static Connection getConnection(){
		return con;		
	}
	
	
	public static boolean Accountexists(UUID uuid, String database){
		boolean boo = false;
		
		if(MySQL.getConnection() == null)
			return false;
		
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT Spielername FROM " + database + " WHERE UUID = ?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			boo = rs.next();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boo;
	}
	
	public static boolean Accountexists(String name, String database){
		boolean boo = false;
		
		if(MySQL.getConnection() == null)
			return false;
		
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT Spielername FROM " + database + " WHERE Spielername = ?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			boo = rs.next();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boo;
	}
	
	public static void deleteAccount(UUID uuid, String database){
		if(Accountexists(uuid, database)){
			try {
				PreparedStatement ps = MySQL.getConnection().prepareStatement("DELETE * FROM " + database +" WHERE UUID = ?");
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
	
	public static boolean getBoolean(UUID uuid, String arg, String database){
		boolean boo = false;
		
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT " + arg +" FROM " + database + " WHERE UUID = ?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				boo =  rs.getBoolean(arg);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boo;
	}

	public static Integer getInteger(UUID uuid, String arg, String database){
		int integer = -1;
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM " + database + " WHERE UUID = ?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				integer =  rs.getInt(arg);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return integer;		
	}
	
	public static Integer getInteger(String name, String arg, String database){
		int integer = -1;
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM " + database + " WHERE UUID = ?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				integer =  rs.getInt(arg);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return integer;		
	}
	
	public static Integer getInteger(String keyName, String keyValue, String arg, String database){
		int integer = -1;
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM " + database + " WHERE " + keyName + " = ?");
			ps.setString(1, keyValue);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				integer =  rs.getInt(arg);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return integer;		
	}
	
	public static Integer getMaxInteger(String arg, String database){
		int integer = 0;
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT MAX(" + arg + ") FROM " + database);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				   integer = rs.getInt(1);
				}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return integer;		
	}
	
	public static void setInteger(UUID uuid, String arg, String database, int value){
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE " + database + " SET " + arg + " = ? WHERE UUID = ?");
			ps.setInt(1, value);
			ps.setString(2, uuid.toString());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String getString(UUID uuid, String arg, String database){
		String s = "";
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM " + database + " WHERE UUID = ?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				s =  rs.getString(arg);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return s;		
	}
	
	public static String getString(String name, String arg, String database){
		String s = "";
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM " + database + " WHERE Spielername = ?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				s =  rs.getString(arg);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return s;		
	}
	
	public static String getString(String keyArg, String keyValue, String arg, String database){
		String s = "";
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM " + database + " WHERE " + keyArg + " = ?");
			ps.setString(1, keyValue);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				s =  rs.getString(arg);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return s;		
	}
	
	public static void setString(UUID uuid, String arg, String database, String value){
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE " + database + " SET " + arg + " = ? WHERE UUID = ?");
			ps.setString(1, value);
			ps.setString(2, uuid.toString());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void setString(String name, String arg, String database, String value){
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE " + database + " SET " + arg + " = ? WHERE Spielername = ?");
			ps.setString(1, value);
			ps.setString(2, name);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void setString(String keyName, String keyValue, String arg, String database, String value){
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE " + database + " SET " + arg + " = ? WHERE " + keyName + " = ?");
			ps.setString(1, value);
			ps.setString(2, keyValue);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String getPermission(UUID uuid){
		String s = "";
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM permissions_inheritance WHERE child = ?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				s =  rs.getString("parent");
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return s;
	}
	
	public static UUID getUUID(String playername) {
		UUID playerUUID = null;
		
		String sql = "SELECT UUID FROM `Spieler` WHERE Spielername = '" + playername +"' OR andereSpielernamen LIKE '%" + playername + ",%' OR andereSpielernamen LIKE '%," + playername + "' OR andereSpielernamen = '" + playername + "';";
		
		try {
			PreparedStatement ps = MySQL.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				playerUUID =  UUID.fromString(rs.getString("UUID"));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return playerUUID;
	}
}
