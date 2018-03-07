package controllers;

import java.util.ArrayList;
import java.util.HashMap;

import application.FPADriver;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
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
	public Slider IntSlider;
	public Slider DexSlider;
	public Slider ChaSlider;
	public Slider StrSlider;
	public Slider ConSlider;
	public Slider WisSlider;
	public ChoiceBox HitDiceSelect;
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
	// Throws exceptions if you change the name then dont reselect the character before editing, but otherwise works
	public void entitySelected() {
		NameTypeBox.setText(AvaliableEntities.get(chooseEntity.getValue()).getName());
		ArmorTypeBox.setText(String.valueOf(AvaliableEntities.get(chooseEntity.getValue()).getArmor()));
		SCATypeBox.setText(String.valueOf(AvaliableEntities.get(chooseEntity.getValue()).getSpellCastingAbility()));
		SABTypeBox.setText(String.valueOf(AvaliableEntities.get(chooseEntity.getValue()).getSpellAttackBonus()));
		SpeedTypeBox.setText(String.valueOf(AvaliableEntities.get(chooseEntity.getValue()).getSpeed()));
		InitiativeTypeBox.setText(String.valueOf(AvaliableEntities.get(chooseEntity.getValue()).getInitiative()));
		IntSlider.setValue(AvaliableEntities.get(chooseEntity.getValue()).getInteligence());
		DexSlider.setValue(AvaliableEntities.get(chooseEntity.getValue()).getDexterity());
		ChaSlider.setValue(AvaliableEntities.get(chooseEntity.getValue()).getCharisma());
		StrSlider.setValue(AvaliableEntities.get(chooseEntity.getValue()).getStrength());
		ConSlider.setValue(AvaliableEntities.get(chooseEntity.getValue()).getConstitution());
		WisSlider.setValue(AvaliableEntities.get(chooseEntity.getValue()).getWisdom());
		HitDiceSelect.setValue(AvaliableEntities.get(chooseEntity.getValue()).getHitDie());
	
	}
	public void updateName() {
		Mob temp = AvaliableEntities.get(chooseEntity.getValue());
		temp.setName(NameTypeBox.getText());
		updateChoiceBox();
	}

	public void updateArmor() {
		Mob temp = AvaliableEntities.get(chooseEntity.getValue());
		String entry = ArmorTypeBox.getText();
		if (tryParseInt(entry)) {
			temp.setArmor(Integer.parseInt(entry));
		} else {
			System.out.println("Incorrect Entry In Text Box");
		}
	}
	public void updateSCA() {
		Mob temp = AvaliableEntities.get(chooseEntity.getValue());
		String entry = SCATypeBox.getText();
		if (tryParseInt(entry)) {
			temp.setSpellCastingAbility(Integer.parseInt(entry));
		} else {
			System.out.println("Incorrect Entry In Text Box");
		}
	}
	public void updateSAB() {
		Mob temp = AvaliableEntities.get(chooseEntity.getValue());
		String entry = SABTypeBox.getText();
		if (tryParseInt(entry)) {
			temp.setSpellAttackBonus(Integer.parseInt(entry));
		} else {
			System.out.println("Incorrect Entry In Text Box");
		}
	}	
	public void updateSpeed() {
		Mob temp = AvaliableEntities.get(chooseEntity.getValue());
		String entry = SpeedTypeBox.getText();
		if (tryParseInt(entry)) {
			temp.setSpeed(Integer.parseInt(entry));
		} else {
			System.out.println("Incorrect Entry In Text Box");
		}
	}	
	public void updateInitiative() {
		Mob temp = AvaliableEntities.get(chooseEntity.getValue());
		String entry = InitiativeTypeBox.getText();
		if (tryParseInt(entry)) {
			temp.setInitiative(Integer.parseInt(entry));
		} else {
			System.out.println("Incorrect Entry In Text Box");
		}
	}	
	
	//mini try parse int so everything doesnt break when someone tries to enter a string
	boolean tryParseInt(String value) {  
	     try {  
	         Integer.parseInt(value);  
	         return true;  
	      } catch (NumberFormatException e) {  
	         return false;  
	      }  
	}
	
	//Updating from sliders
	public void updateCha() {
		Mob temp = AvaliableEntities.get(chooseEntity.getValue());
		temp.setCharisma((int)ChaSlider.getValue());
	}
	public void updateDex() {
		Mob temp = AvaliableEntities.get(chooseEntity.getValue());
		temp.setDexterity((int)DexSlider.getValue());
	}
	public void updateInt() {
		Mob temp = AvaliableEntities.get(chooseEntity.getValue());
		temp.setInteligence((int)IntSlider.getValue());
	}
	public void updateWis() {
		Mob temp = AvaliableEntities.get(chooseEntity.getValue());
		temp.setWisdom((int)WisSlider.getValue());
	}
	public void updateStr() {
		Mob temp = AvaliableEntities.get(chooseEntity.getValue());
		temp.setStength((int)StrSlider.getValue());
	}
	public void updateCon() {
		Mob temp = AvaliableEntities.get(chooseEntity.getValue());
		temp.setConstitution((int)ConSlider.getValue());
	}
	
	//update Dice
	public void updateHitDice() {
		Mob temp = AvaliableEntities.get(chooseEntity.getValue());
		String dice = (String) HitDiceSelect.getValue();
		temp.setHitDie(dice);
	}
}
