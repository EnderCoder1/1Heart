package me.Ender_Coder.main.files;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileManager {
	
	File Info = new File("plugins/bowRunner/Information.yml");
	File GamesId = new File("plugins/bowRunner/GamesId.yml");
	File Locations = new File("plugins/bowRunner/Locations.yml");
	File Vector = new File("plugins/bowRunner/Vector.yml");
	
	FileConfiguration infoConfig = YamlConfiguration.loadConfiguration(Info);
	FileConfiguration gamesIdConfig = YamlConfiguration.loadConfiguration(GamesId);
	FileConfiguration locationsConfig = YamlConfiguration.loadConfiguration(Locations);
	FileConfiguration vectorConfig = YamlConfiguration.loadConfiguration(Vector);
	
	public FileConfiguration getInformationFiles(){
		return infoConfig;
	}
	
	public FileConfiguration getGamesIdFiles(){
		return gamesIdConfig;
	}
	
	public FileConfiguration getLocationsFiles(){
		return locationsConfig;
	}
	
	public FileConfiguration getVectorFiles(){
		return vectorConfig;
	}	
	
	public void saveAllFiles(){
		try {
			infoConfig.save(Info);
			gamesIdConfig.save(GamesId);
			locationsConfig.save(Locations);
			vectorConfig.save(Vector);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private static FileManager filemanager;
	
	public static FileManager getFiles(){
		if(filemanager == null){
			filemanager = new FileManager();
		}
		return filemanager;
	}

	
}
