package util;

import java.io.Serializable;

import javafx.scene.layout.GridPane;

public class Map implements Serializable{

	
	public final String name;
	public final GridPane map;
	
	public Map (String name, GridPane map) {
		this.name = name;
		this.map = map;
	}
}
