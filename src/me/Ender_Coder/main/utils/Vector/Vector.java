package me.Ender_Coder.main.utils.Vector;

import java.util.HashMap;

import me.Ender_Coder.main.files.FileManager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

public class Vector {
	
	FileConfiguration vectorConfig = FileManager.getFiles().getVectorFiles();
	
	HashMap<Integer, Location> locations;
	
	private int Id;
	
	public Vector(int gameId){
		locations = new HashMap<Integer, Location>();
		
		Id = gameId;
		
		loadLocations();
	}
	
	private void loadLocations(){
		
		for(int i = 1; i < 5; i++){
			Location loc;
			
			int x = vectorConfig.getInt("Vectors." + Id + ".round" + i + "LocationX");
			int y = vectorConfig.getInt("Vectors." + Id + ".round" + i + "LocationY");
			int z = vectorConfig.getInt("Vectors." + Id + ".round" + i + "LocationZ");
			
			String world = (String) vectorConfig.get("Vectors." + Id + ".round" + i + "World");
			
			loc = new Location(Bukkit.getWorld(world), x, y, z);
			
			locations.put(i, loc);
		}
		
	}
	
	public void setLocation(int round, Location l) throws IndexOutOfBoundsException{
		locations.put(round, l);
		
		vectorConfig.set("Vectors." + Id + ".round" + round + ".LocationX", l.getBlockX());
		vectorConfig.set("Vectors." + Id + ".round" + round + ".LocationY", l.getBlockY());
		vectorConfig.set("Vectors." + Id + ".round" + round + ".LocationZ", l.getBlockZ());
		vectorConfig.set("Vectors." + Id + ".round" + round + ".World", l.getWorld().getName());
	}
	
	public void removeLocation(int round, Location l) throws IndexOutOfBoundsException{
		locations.remove(round, l);
		
		vectorConfig.set("Vectors." + Id + ".round" + round + ".LocationX", null);
		vectorConfig.set("Vectors." + Id + ".round" + round + ".LocationY", null);
		vectorConfig.set("Vectors." + Id + ".round" + round + ".LocationZ", null);
		vectorConfig.set("Vectors." + Id + ".round" + round + ".World", null);
	}
	
	public Location getLocation(int round) throws IndexOutOfBoundsException{
		return locations.get(round);
	}
	
}
