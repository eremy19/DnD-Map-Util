package controllers;

import java.util.ArrayList;

import application.FPADriver;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import models.Mob;
import models.Monster;
import models.Player;

public class EntityController {
	@FXML
	public Button entities;
	public ChoiceBox chooseEntity;
	
	public Button CharacterCreate;
	public Button MonsterCreate;

	public void generateBlankPlayer(){
		Player mobBlank = new Player("BlankSlate", 10,10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, "d4");
		System.out.println(mobBlank.toString());
		FPADriver.addPlayer(mobBlank);
		updateChoiceBox();
	}
	public void generateBlankMonster(){
		Monster mobBlank = new Monster("BlankMonster", 10,10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, "d4");
		System.out.println(mobBlank.toString());
		FPADriver.addMonster(mobBlank);
		updateChoiceBox();
	}
	public void updateChoiceBox(){
		ArrayList<Mob> temp = (ArrayList<Mob>)FPADriver.returnEntities();
		ArrayList<String> names = new ArrayList<>();
		for (Mob m: temp) {
			names.add(m.getName());
		}
		chooseEntity.setItems(FXCollections.observableArrayList(names));
	}
}
