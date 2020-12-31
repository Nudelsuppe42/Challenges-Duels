package de.minefact.plugin.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.minefact.utils.MySQL;
import org.bukkit.entity.Player;

public enum Language {
		
	ENGLISH("English"),
	GERMAN("German");
	
	private static HashMap<String, String> translations = new HashMap<String, String>();
	private static HashMap<Player, String> language = new HashMap<Player, String>();
	private String name;
	
	Language(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public static Language byName(String name) {
		switch(name) {
			case "English": return ENGLISH;
			case "German": return GERMAN;
			
			default: return null;
		}
	}
	
	public static Language getLanguage(Player p) {
		if(!language.containsKey(p)) {
			String lang = MySQL.getString(p.getUniqueId(), "Language", "Settings");
			if(lang == null || lang.equals(""))
				return ENGLISH;
			language.put(p, lang);
		}
		return byName(language.get(p));
	}
	
	public static Language getLanguage(String playerName) {
		String language = MySQL.getString(playerName, "Language", "Settings");
		if(language == null)
			return ENGLISH;
		
		return byName(language);
	}
	
	public static String getTranslation(Language language, String keywordID) {
		if(!translations.containsKey(keywordID + ":" + language.getName())) {
			String s = MySQL.getString("ID", keywordID, language.getName(), "Language_Translations");
			translations.put(keywordID + ":" + language.getName(), s);
		}
		
		return translations.get(keywordID + ":" + language.getName());
	}
	
	public static String getTranslation(Player p, String keywordID) {
		Language lang = getLanguage(p);
		return getTranslation(lang, keywordID);
	}
	
	public static List<String> getTranslations(String keywordID){
		List<String> translations = new ArrayList<String>();
		
		for(Language lang : values())
			translations.add(getTranslation(lang, keywordID));
		
		return translations;
	}
	
	public static List<String> getTranslations(String[] keywordIDs){
		List<String> translations = new ArrayList<String>();
		
		for(Language lang : values())
		for(String keywordID : keywordIDs)
			translations.add(getTranslation(lang, keywordID));
		
		return translations;
	}
	
	public static HashMap<Language,String> getTranslationsMap(String keywordID){
		HashMap<Language,String> translations = new HashMap<Language,String>();
		
		for(Language lang : values())
			translations.put(lang, getTranslation(lang, keywordID));
		
		return translations;
	}
	
	public static boolean changeLanguage(Player p, Language newLanguage) {
		MySQL.setString(p.getUniqueId(), "Language", "Settings", newLanguage.getName());
		language.remove(p);
		language.put(p, newLanguage.getName());
		return true;
	}
	
	public static String messageUnknownCommand(Player p) {
		return getTranslation(p, "de.minefact.unknownCommand");
	}
}
