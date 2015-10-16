package me.Ender_Coder.main;

import me.Ender_Coder.main.game.GameManager;

import org.bukkit.plugin.java.JavaPlugin;

public class OneHeart extends JavaPlugin{

	public void onEnable(){
		
	}
	
	public void onDisable(){
		GameManager.getManager().unLoadGames();
	}
	
	
}
