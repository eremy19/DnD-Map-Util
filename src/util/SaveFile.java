package util;

import java.io.Serializable;
import java.util.ArrayList;

import item.Items;
import models.Monster;
import models.Player;

public class SaveFile implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<Items> itemList;
	public ArrayList<Player> playerList;
	public ArrayList<Monster> monsterList;
	public ArrayList<Map> mapList;
	
	public SaveFile(ArrayList<Items> itemList, ArrayList<Player> playerList, ArrayList<Monster> monsterList, ArrayList<Map> mapList) {
		this.itemList = itemList;
		this.playerList = playerList;
		this.monsterList = monsterList;
		this.mapList = mapList;
	}

//	public ArrayList<Items> getItemList() {
//		return itemList;
//	}
//
//	public ArrayList<Player> getPlayerList() {
//		return playerList;
//	}
//
//	public ArrayList<Monster> getMonsterList() {
//		return monsterList;
//	}
//
//	public ArrayList<Map> getMapList() {
//		return mapList;
//	}
//
//	public void setItemList(ArrayList<Items> itemList) {
//		this.itemList = itemList;
//	}
//
//	public void setPlayerList(ArrayList<Player> playerList) {
//		this.playerList = playerList;
//	}
//
//	public void setMonsterList(ArrayList<Monster> monsterList) {
//		this.monsterList = monsterList;
//	}
//
//	public void setMapList(ArrayList<Map> mapList) {
//		this.mapList = mapList;
//	}
	
	
	

}
