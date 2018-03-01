package models;

import java.io.Serializable;

import javafx.scene.layout.GridPane;

public class Map implements Serializable{

	
	public final String name;
	public final String[][] map;
	
	public Map (String name, String[][] map) {
		this.name = name;
		this.map = map;
	}
}
