package models;

import java.util.ArrayList;

import javafx.scene.control.Button;

public class Entity {

	public Button button;
	public Mob mob;
	public String[] optionsStringArr = {"Change health", "Remove" , "Roll Dice", "More info"};
	public ArrayList<String> options = new ArrayList<>();
	
	public Entity (Button b, Mob m) {
		button = b;
		mob = m;
	}
	
	public void updateOptions (String[] opts) {
		options.clear();
		for (String string : opts) {
			options.add(string);
		}
	}
	
}
