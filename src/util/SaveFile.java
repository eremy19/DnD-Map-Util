package util;

import java.util.ArrayList;

import item.Items;
import models.Chest;
import models.Monster;

public class SaveFile {
	
	public final ArrayList<Items> itemList;
	public final ArrayList<Chest> chestList;
	public final ArrayList<Monster> monsterList;
	
	public SaveFile(ArrayList<Items> itemList, ArrayList<Chest> chestList, ArrayList<Monster> monsterList) {
		this.itemList = itemList;
		this.chestList = chestList;
		this.monsterList = monsterList;
	}
	
	
	

}
