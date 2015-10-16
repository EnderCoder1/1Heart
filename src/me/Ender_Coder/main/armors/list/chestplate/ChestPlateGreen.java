package me.Ender_Coder.main.armors.list.chestplate;

import me.Ender_Coder.main.armors.Armor;
import me.Ender_Coder.main.armors.ArmorLevel;
import me.Ender_Coder.main.armors.ArmorType;
import me.Ender_Coder.main.armors.list.ArmorManager;
import me.Ender_Coder.main.files.Information;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ChestPlateGreen extends Armor{

	public ChestPlateGreen() {
		super(ArmorType.CHEST_PLATE, ArmorLevel.GREEN, Information.getInfo().ChestPlateGreenPourc, item());
		init();
	}
	
	public static ItemStack item(){
		ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE);
		LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
		
		meta.setDisplayName("Armure Verte");
		meta.setColor(Color.GREEN);
		
		item.addEnchantment(Enchantment.DURABILITY, 10);
		
		item.setItemMeta(meta);
		
		return item;
	}
	
	private void init(){
		ArmorManager.getManager().add(this);
	}

}
