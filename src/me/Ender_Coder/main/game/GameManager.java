package me.Ender_Coder.main.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;

import me.Ender_Coder.main.files.FileManager;

public class GameManager {
	
	private FileConfiguration gamesId = FileManager.getFiles().getGamesIdFiles();
	private FileConfiguration locations = FileManager.getFiles().getLocationsFiles();
	
	private static GameManager manager;
	private List<Game> games = new ArrayList<Game>();
	private List<Integer> IdContainer = new ArrayList<Integer>();
	private HashMap<Integer, Game> gamesWithId = new HashMap<Integer, Game>();
	
	public Game getGame(int id) throws Exception{
		return gamesWithId.get(id);
	}
	
	public Game createGame(int id){
		Game game = new Game(id);
		addGame(game);
		return game;
	}	
	
	public void addGame(Game game){
		games.add(game);
		gamesWithId.put(game.getGameId(), game);
		
		gamesId.set("Ids." + game.getGameId(), game.getGameId());
		
		locations.set("Games.game" + game.getGameId() + ".Id", game.getGameId());
	}
	
	public void removeGame(Game game){
		games.remove(game);
		gamesWithId.remove(game, game.getGameId());
	}
	
	public void loadGames(){
    	for(String ids : FileManager.getFiles().getGamesIdFiles().getConfigurationSection("Ids.").getKeys(false)){
    		int id = Integer.parseInt(ids);
    		IdContainer.add(id);
    	}
    	
    	for(int ids : IdContainer){
    		games.add(new Game(ids));
    	}
		
	}
	
	public void unLoadGames(){
		for(Game game : games){
			removeGame(game);
		}
	}
	
	public boolean gameExists(int id){
		if(gamesWithId.get(id) == null){
			return false;
		}
		return true;
	}
	
	public static GameManager getManager(){
		if(manager == null){
			manager = new GameManager();
		}
		return manager;
	}
	
}
