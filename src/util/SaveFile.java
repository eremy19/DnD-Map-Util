package util;

import java.util.ArrayList;

import item.Items;
import models.Monster;
import models.Player;

public class SaveFile {

	public final ArrayList<Player> players;
	public final ArrayList<Monster> monsters;
	public final ArrayList<Items> items;

	public SaveFile(ArrayList<Player> players, ArrayList<Monster> monsters, ArrayList<Items> items) {
		this.players = players;
		this.monsters = monsters;
		this.items = items;
	}
}
