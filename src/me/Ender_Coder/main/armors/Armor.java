package me.Ender_Coder.main.armors;

import org.bukkit.inventory.ItemStack;

public abstract class Armor {
	
	ArmorType type;
	ArmorLevel level;
	
	int pourc;
	
	ItemStack item;
	
	public Armor(ArmorType type, ArmorLevel level, int pourc, ItemStack item){
		this.type = type;
		this.level = level;
		this.pourc = pourc;
		this.item = item;
	}
	
	public ArmorType getArmorType(){
		return this.type;
	}
	
	public ArmorLevel getArmorLevel(){
		return this.level;
	}
	
	public int getPourcentage(){
		return this.pourc;
	}
	
}
