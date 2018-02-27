package util;

import java.util.ArrayList;

import item.Items;
import models.Chest;
import models.Monster;

public class SaveFile {
	
	public final ArrayList<Items> itemList;
	public final ArrayList<Chest> chestList;
	public final ArrayList<Monster> monsterList;
	public final ArrayList<Map> mapList;
	
	public SaveFile(ArrayList<Items> itemList, ArrayList<Chest> chestList, ArrayList<Monster> monsterList, ArrayList<Map> mapList) {
		this.itemList = itemList;
		this.chestList = chestList;
		this.monsterList = monsterList;
		this.mapList = mapList;
	}
	
	
	

}
