package me.Ender_Coder.main.armors.list;

import java.util.ArrayList;
import java.util.List;

import me.Ender_Coder.main.armors.Armor;

public class ArmorManager {
	
	private static ArmorManager manager;
	
	public static ArmorManager getManager(){
		if(manager == null){
			manager = new ArmorManager();
		}
		return manager;
	}
	
	private List<Armor> armors = new ArrayList<Armor>();
	
	public ArrayList<Armor> getArmorList(){
		return (ArrayList<Armor>) this.armors;
	}
	
	public void add(Armor armor){
		armors.add(armor);
	}
	
	public void remove(Armor armor){
		armors.remove(armor);
	}
	
}
