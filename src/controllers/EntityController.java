package controllers;

import application.FPADriver;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import models.Mob;
import models.Player;

public class EntityController {
	
	@FXML
	public Button entities;

	
	public Button CharacterCreate;
	
	public void generateBlank(){
		Player mobBlank = new Player("BlankSlate", 10,10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, "d4");
		System.out.println(mobBlank.toString());
		FPADriver.addPlayer(mobBlank);
	}
	
	
}
