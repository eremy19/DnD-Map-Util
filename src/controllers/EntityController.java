package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import models.Mob;

public class EntityController {
	
	@FXML
	public Button entities;
	public Button CharacterCreate;
	
	public void generateBlank(){
		Mob mobBlank = new Mob("BlankSlate", 10,10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, "d4");
		System.out.println(mobBlank.toString());
	}
	
}
