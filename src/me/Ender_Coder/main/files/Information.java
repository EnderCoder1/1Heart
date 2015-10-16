package me.Ender_Coder.main.files;

public class Information {
	
	private static Information info;
	
	public static Information getInfo(){
		if(info == null){
			info = new Information();
		}
		return info;
	}
	
	public int ChestPlateGreenPourc = FileManager.getFiles().getInformationFiles().getInt("Info.ChestPlate.green.pourc");
	
}
