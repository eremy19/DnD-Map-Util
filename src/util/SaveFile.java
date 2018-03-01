package util;

import java.util.ArrayList;

import item.Items;
import models.Monster;
import models.Player;

public class SaveFile {
	
	public final ArrayList<Items> itemList;
	public final ArrayList<Player> playerList;
	public final ArrayList<Monster> monsterList;
	public final ArrayList<Map> mapList;
	
	public SaveFile(ArrayList<Items> itemList, ArrayList<Player> playerList, ArrayList<Monster> monsterList, ArrayList<Map> mapList) {
		this.itemList = itemList;
		this.playerList = playerList;
		this.monsterList = monsterList;
		this.mapList = mapList;
	}
	
	
	

}
