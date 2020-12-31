package de.minefact.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;

public class Item {
	
	public static HashMap<String, ItemStack> nonPlayerSkulls = new HashMap<String, ItemStack>();
	
	public static ItemStack create(Material material){
		return new ItemStack(material);
	}
	
	public static ItemStack create(Material material, int amount){
		ItemStack item = new ItemStack(material, amount);
		return item;
	}
	
	public static ItemStack create(Material material, String name){
		ItemStack item = new ItemStack(material, 1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(name);
		item.setItemMeta(itemmeta);
		return item;
	}
	
	public static ItemStack create(Material material, String name, int amount){
		ItemStack item = new ItemStack(material, amount);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(name);
		item.setItemMeta(itemmeta);
		return item;
	}

	@SuppressWarnings("deprecation")
	public static ItemStack create(Material material, String name , ArrayList<String> lore){
		ItemStack item = new ItemStack(material, 1,(short) 0); 
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(name);
		itemmeta.setLore(lore);
		item.setItemMeta(itemmeta);
		return item;
	}
	
	@SuppressWarnings("deprecation")
	public static ItemStack create(Material material, String name, short durability , ArrayList<String> lore){
		ItemStack item = new ItemStack(material, 1, durability); 
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(name);
		itemmeta.setLore(lore);
		item.setItemMeta(itemmeta);
		return item;
	}

	public static ItemStack create(Material material, String name, int amount, ArrayList<String> lore){
		ItemStack item = new ItemStack(material, amount);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(name);
		itemmeta.setLore(lore);
		item.setItemMeta(itemmeta);
		return item;
	}
	
	public static ItemStack createLeatherArmor(Material material, String name, Color color, ArrayList<String> lore){
		ItemStack item = new ItemStack(material);
		LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
		itemmeta.setDisplayName(name);
		itemmeta.setLore(lore);
		itemmeta.setColor(color);
		item.setItemMeta(itemmeta);
		return item;
	}
	
	public static ItemStack create(Material material, String name, ArrayList<String> lore, Enchantment enchnt1, Integer level1){
		ItemStack item = new ItemStack(material);
		item.addUnsafeEnchantment(enchnt1, level1);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(name);
		itemmeta.setLore(lore);
		item.setItemMeta(itemmeta);
		return item;
	}
	
	public static ItemStack create(Material material, String name, ArrayList<String> lore, Enchantment enchnt1, Integer level1, Enchantment enchnt2, Integer level2){
		ItemStack item = new ItemStack(material);
		item.addUnsafeEnchantment(enchnt1, level1);
		item.addUnsafeEnchantment(enchnt2, level2);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(name);
		itemmeta.setLore(lore);
		item.setItemMeta(itemmeta);
		return item;
	}
	
	public static ItemStack create(Material material, String name, ArrayList<String> lore, Enchantment enchnt1, Integer level1, Enchantment enchnt2, Integer level2, Enchantment enchnt3, Integer level3){
		ItemStack item = new ItemStack(material);
		item.addUnsafeEnchantment(enchnt1, level1);
		item.addUnsafeEnchantment(enchnt2, level2);
		item.addUnsafeEnchantment(enchnt3, level3);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(name);
		itemmeta.setLore(lore);
		item.setItemMeta(itemmeta);
		return item;
	}
	
	public static ItemStack createLeatherArmor(Material material, Color color){
		ItemStack item = new ItemStack(material);
		LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
		itemmeta.setColor(color);
		item.setItemMeta(itemmeta);
		return item;
	}
	
	public static ItemStack createLeatherArmor(Material material, String name, Color color, ArrayList<String> lore, Enchantment enchnt1, Integer level1){
		ItemStack item = new ItemStack(material);
		item.addUnsafeEnchantment(enchnt1, level1);
		LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
		itemmeta.setDisplayName(name);
		itemmeta.setLore(lore);
		itemmeta.setColor(color);
		item.setItemMeta(itemmeta);
		return item;
	}
	
	public static ItemStack createLeatherArmor(Material material, String name, Color color, ArrayList<String> lore, Enchantment enchnt1, Integer level1, Enchantment enchnt2, Integer level2){
		ItemStack item = new ItemStack(material);
		item.addUnsafeEnchantment(enchnt1, level1);
		item.addUnsafeEnchantment(enchnt2, level2);
		LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
		itemmeta.setDisplayName(name);
		itemmeta.setLore(lore);
		itemmeta.setColor(color);
		item.setItemMeta(itemmeta);
		return item;
	}
	
	public static ItemStack createLeatherArmor(Material material, String name, Color color, ArrayList<String> lore, Enchantment enchnt1, Integer level1, Enchantment enchnt2, Integer level2, Enchantment enchnt3, Integer level3){
		ItemStack item = new ItemStack(material);
		item.addUnsafeEnchantment(enchnt1, level1);
		item.addUnsafeEnchantment(enchnt2, level2);
		item.addUnsafeEnchantment(enchnt3, level3);
		LeatherArmorMeta itemmeta = (LeatherArmorMeta) item.getItemMeta();
		itemmeta.setDisplayName(name);
		itemmeta.setLore(lore);
		itemmeta.setColor(color);
		item.setItemMeta(itemmeta);
		return item;
	}
	
	@SuppressWarnings("deprecation")
	public static ItemStack createPlayerHead(String name, String owner){
		ItemStack item = new ItemStack(Material.PLAYER_HEAD);
		SkullMeta itemmeta = (SkullMeta) item.getItemMeta();
		itemmeta.setDisplayName(name);
		itemmeta.setOwner(owner);
		item.setItemMeta(itemmeta);
		return item;
	}
	
	@SuppressWarnings("deprecation")
	public static ItemStack createPlayerHead(String name, String owner, ArrayList<String> lore){
		ItemStack item = new ItemStack(Material.PLAYER_HEAD);
		SkullMeta itemmeta = (SkullMeta) item.getItemMeta();
		itemmeta.setDisplayName(name);
		itemmeta.setOwner(owner);
		itemmeta.setLore(lore);
		item.setItemMeta(itemmeta);
		return item;
	}
	
	@SuppressWarnings("deprecation")
	public static ItemStack createPlayerHead(String name, String owner, int amount, ArrayList<String> lore){
		ItemStack item = new ItemStack(Material.PLAYER_HEAD);
		SkullMeta itemmeta = (SkullMeta) item.getItemMeta();
		itemmeta.setDisplayName(name);
		itemmeta.setOwner(owner);
		itemmeta.setLore(lore);
		item.setItemMeta(itemmeta);
		return item;
	}
	
	
	
	
	
	public static ItemStack edit(ItemStack item, Material material){
		item.setType(material);
		return item;
	}
	
	public static ItemStack edit(ItemStack item, int amount){
		item.setAmount(amount);
		return item;
	}
	
	public static ItemStack edit(ItemStack item, String name){
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(name);
		item.setItemMeta(itemmeta);
		return item;
	}
	
	public static ItemStack edit(ItemStack item, int amount, String name){
		item.setAmount(amount);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(name);
		item.setItemMeta(itemmeta);
		return item;
	}
	
	public static ItemStack edit(ItemStack item, ArrayList<String> lore){
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setLore(lore);
		item.setItemMeta(itemmeta);
		return item;
	}
	
	public static ItemStack edit(ItemStack item, int amount, String name, ArrayList<String> lore){
		item.setAmount(amount);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(name);
		itemmeta.setLore(lore);
		item.setItemMeta(itemmeta);
		return item;
	}
	
	@SuppressWarnings("deprecation")
	public static ItemStack edit(ItemStack item, int amount, int data){
		item.setAmount(amount);
		item.getData().setData((byte) data);
		return item;
	}
	
	
	
	
	
	
	
	
	
	
	
	/*
	 *  Base64 Encoder: https://www.base64decode.org/
	 * 
	 */
	
	public static ItemStack createNonPlayerSkull(Player executor, String url, String name, ArrayList<String> lore){
		if(nonPlayerSkulls.containsKey(url))
			return nonPlayerSkulls.get(url);

		ItemStack item = new ItemStack(Material.PLAYER_HEAD);
		SkullMeta im = (SkullMeta) item.getItemMeta();

		PlayerProfile profile = executor.getPlayerProfile();
        byte[] encodedData = Base64.getEncoder().encode(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        profile.setProperty(new ProfileProperty("textures", new String(encodedData)));
        Field profileField = null;
        try {
            profileField = im.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(im, profile);
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e1) {
            e1.printStackTrace();
        }
        
        im.setDisplayName(name);
        im.setLore(lore);
        item.setItemMeta(im);
        
        nonPlayerSkulls.remove(url);
        nonPlayerSkulls.put(url, item);
        
        return item;
	}
}
