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
	public TextField NameTypeBox;
	public TextField ArmorTypeBox;
	public TextField SCATypeBox;
	public TextField SABTypeBox;
	public TextField SpeedTypeBox;
	public TextField InitiativeTypeBox;
	public Label CurrentName;

	public Button CharacterCreate;
	public Button MonsterCreate;
	public int MonsterNum;
	public int PlayerNum = 0;

	public void generateBlankPlayer(){
		String name = "Character " + ++PlayerNum;
		Player mobBlank = new Player(name, 10,10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, "d4");
		System.out.println(mobBlank.toString());
		FPADriver.addPlayer(mobBlank);
		updateChoiceBox();
	}
	
	public void generateBlankMonster(){
		String name = "Monster " + ++MonsterNum;
		Monster mobBlank = new Monster(name, 10,10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, "d4");
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
	//get value chooses the last value chosen from the box
	// Note to self: add button that will then choose value
	public void entitySelected() {
		NameTypeBox.setText(AvaliableEntities.get(chooseEntity.getValue()).getName());
		ArmorTypeBox.setText(String.valueOf(AvaliableEntities.get(chooseEntity.getValue()).getArmor()));
		SCATypeBox.setText(String.valueOf(AvaliableEntities.get(chooseEntity.getValue()).getSpellCastingAbility()));
		SABTypeBox.setText(String.valueOf(AvaliableEntities.get(chooseEntity.getValue()).getSpellAttackBonus()));
		SpeedTypeBox.setText(String.valueOf(AvaliableEntities.get(chooseEntity.getValue()).getSpeed()));
		InitiativeTypeBox.setText(String.valueOf(AvaliableEntities.get(chooseEntity.getValue()).getInitiative()));
	}
	
	
	public void updateName() {
		Mob temp = AvaliableEntities.get(chooseEntity.getValue());
		temp.setName(NameTypeBox.getText());
		updateChoiceBox();
	}
	
}
