package me.Ender_Coder.main.game;

import me.Ender_Coder.main.files.FileManager;
import me.Ender_Coder.main.utils.Vector.Vector;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

public class Game {
	
	private FileConfiguration locationsFile = FileManager.getFiles().getLocationsFiles();
	private Vector locations;
	private int gameId;
	
	public Game(int id){
		this.gameId = id;

		GameManager.getManager().addGame(this);
		locations = new Vector(id);
	}
	
	public int getGameId(){
		return this.gameId;
	}
	
	public void setWorld(Location l){
		locationsFile.set("Games.game" + gameId + ".World", l.getWorld().getName());
	}
	
	public void setArenaLocation(int round, Location l){
		locations.setLocation(round, l);
	}
	
	public Location getArenaLocation(int round){
		return locations.getLocation(round);
	}
	
	public void setLobbyLocation(Location l){
		
		FileManager.getFiles().getLocationsFiles().set("Locations.game" + gameId + ".LocationX", l.getBlockX());
		FileManager.getFiles().getLocationsFiles().set("Locations.game" + gameId + ".LocationY", l.getBlockY());
		FileManager.getFiles().getLocationsFiles().set("Locations.game" + gameId + ".LocationZ", l.getBlockZ());
		FileManager.getFiles().getLocationsFiles().set("Locations.game" + gameId + ".World", l.getWorld().getName());
	}
	
	public Location getLobbyLocation(){
		
		int x = FileManager.getFiles().getLocationsFiles().getInt("Locations.game" + gameId + ".LocationX");
		int y = FileManager.getFiles().getLocationsFiles().getInt("Locations.game" + gameId + ".LocationY");
		int z = FileManager.getFiles().getLocationsFiles().getInt("Locations.game" + gameId + ".LocationZ");

		String world = (String) FileManager.getFiles().getLocationsFiles().get("Locations.game" + gameId + ".World");

		return new Location(Bukkit.getWorld(world), x, y, z);
	}
	
	
}
