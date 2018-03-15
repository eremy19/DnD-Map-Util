package models;

import java.util.ArrayList;

import javafx.scene.control.Button;

public class Entity { 

	public Button button;
	public Mob mob;
	public ArrayList<String> options = new ArrayList<>();
	
	public Entity (Button b, Mob m) {
		button = b;
		mob = m;
	}	
}
