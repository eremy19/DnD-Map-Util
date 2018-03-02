package controllers;

import application.FPADriver;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import models.Mob;
import models.Monster;
import models.Player;

public class EntityController {
	
	@FXML
	public Button entities;

	
	public Button CharacterCreate;
	public Button MonsterCreate;

	public void generateBlankPlayer(){
		Player mobBlank = new Player("BlankSlate", 10,10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, "d4");
		System.out.println(mobBlank.toString());
		FPADriver.addPlayer(mobBlank);
	}
	public void generateBlankMonster(){
		Monster mobBlank = new Monster("BlankMonster", 10,10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, "d4");
		System.out.println(mobBlank.toString());
		FPADriver.addMonster(mobBlank);
	}
	
}
