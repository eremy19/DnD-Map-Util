package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import application.FPADriver;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Mob;
import models.Monster;
import models.Player;

public class EntityController {
	private static HashMap<String, Mob> AvaliableEntities = new HashMap();
	
	@FXML
	public Button entities;
	public ChoiceBox chooseEntity;
	
	public static TextField NameTypeBox;
	public TextField ArmorTypeBox;
	public TextField SCATypeBox;
	public TextField SABTypeBox;
	public TextField SpeedTypeBox;
	public TextField InitiativeTypeBox;
	public static Label CurrentName;

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
			AvaliableEntities.put(m.getName(), m);
		}
		chooseEntity.setItems(FXCollections.observableArrayList(names));
	}
	
	//March 5th - Emily: changes text boxes to be the character selected
	//Currently sets it to a new label. Is correct, but doesnt print it out.
	public static void entitySelected(Number new_value) {
		ArrayList<Mob> temp = (ArrayList<Mob>)FPADriver.returnEntities();
		ArrayList<String> names = new ArrayList<>();
		for (Mob m: temp) {
			names.add(m.getName());
		}
		String selected = names.get((int)new_value);
		Label test = new Label(selected);
		CurrentName = test;
		System.out.println(CurrentName.getText());
	}
}
