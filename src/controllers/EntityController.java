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

	@FXML
	public Button entities;
	public ChoiceBox chooseEntity;
	public TextField NameTypeBox;
	public TextField HealthTypeBox;
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

	public void generateBlankPlayer() {
		String name = "Character " + ++PlayerNum;
		Player mobBlank = new Player(name, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, "d4");
		System.out.println(mobBlank.toString());
		FPADriver.addPlayer(mobBlank);
		updateChoiceBox();
	}

	public void generateBlankMonster() {
		String name = "Monster " + ++MonsterNum;
		Monster mobBlank = new Monster(name, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, "d4");
		System.out.println(mobBlank.toString());
		FPADriver.addMonster(mobBlank);
		updateChoiceBox();
	}

	public void updateChoiceBox() {
		ArrayList<String> names = new ArrayList<>();
		for (String name : FPADriver.AvaliableEntities.keySet()) {
			names.add(name);
		}
		chooseEntity.setItems(FXCollections.observableArrayList(names));
	}

	public void entitySelected() {
		try {
			NameTypeBox.setText(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getName());
			HealthTypeBox.setText(String.valueOf(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getMaxHP()));
			ArmorTypeBox.setText(String.valueOf(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getArmor()));
			SCATypeBox.setText(
					String.valueOf(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getSpellCastingAbility()));
			SABTypeBox.setText(
					String.valueOf(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getSpellAttackBonus()));
			SpeedTypeBox.setText(String.valueOf(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getSpeed()));
			InitiativeTypeBox
					.setText(String.valueOf(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getInitiative()));
			IntSlider.setValue(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getInteligence());
			DexSlider.setValue(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getDexterity());
			ChaSlider.setValue(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getCharisma());
			StrSlider.setValue(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getStrength());
			ConSlider.setValue(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getConstitution());
			WisSlider.setValue(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getWisdom());
			HitDiceSelect.setValue(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getHitDie());
			NameTypeBox.setEditable(true);
			HealthTypeBox.setEditable(true);
			ArmorTypeBox.setEditable(true);
			SCATypeBox.setEditable(true);
			SABTypeBox.setEditable(true);
			SpeedTypeBox.setEditable(true);
			InitiativeTypeBox.setEditable(true);
		} catch (NullPointerException e) {

		}

	}
	public void removeEntity() {
		FPADriver.AvaliableEntities.remove(chooseEntity.getValue());
		updateChoiceBox();
	}
	
	public void updateName() {
		Mob temp = FPADriver.AvaliableEntities.get(chooseEntity.getValue());
		try {
			temp.setName(NameTypeBox.getText());
		} catch (NullPointerException e) {
		}
		try {
			if (FPADriver.AvaliableEntities.containsKey(temp.getName())) {
				FPADriver.AvaliableEntities.remove(chooseEntity.getValue());
				String newName = temp.getName() + "(1)";
				temp.setName(newName);
				FPADriver.AvaliableEntities.put(temp.getName(), temp);
			} else {
				FPADriver.AvaliableEntities.remove(chooseEntity.getValue());
				FPADriver.AvaliableEntities.put(temp.getName(), temp);
			}
		} catch (NullPointerException e) {

		}
		NameTypeBox.setEditable(false);
		HealthTypeBox.setEditable(false);
		ArmorTypeBox.setEditable(false);
		SCATypeBox.setEditable(false);
		SABTypeBox.setEditable(false);
		SpeedTypeBox.setEditable(false);
		InitiativeTypeBox.setEditable(false);
		updateChoiceBox();
	}
	public void updateHealth() {
		String entry = HealthTypeBox.getText();
		if (tryParseInt(entry)) {
			FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setMaxHP(Integer.parseInt(entry));
		} else {
			System.out.println("Incorrect Entry In Text Box");
		}
	}
	public void updateArmor() {
		String entry = ArmorTypeBox.getText();
		if (tryParseInt(entry)) {
			FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setArmor(Integer.parseInt(entry));
		} else {
			System.out.println("Incorrect Entry In Text Box");
		}
	}

	public void updateSCA() {
		String entry = SCATypeBox.getText();
		if (tryParseInt(entry)) {
			FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setSpellCastingAbility(Integer.parseInt(entry));
		} else {
			System.out.println("Incorrect Entry In Text Box");
		}
	}

	public void updateSAB() {
		String entry = SABTypeBox.getText();
		if (tryParseInt(entry)) {
			FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setSpellAttackBonus(Integer.parseInt(entry));
		} else {
			System.out.println("Incorrect Entry In Text Box");
		}
	}

	public void updateSpeed() {
		String entry = SpeedTypeBox.getText();
		if (tryParseInt(entry)) {
			FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setSpeed(Integer.parseInt(entry));
		} else {
			System.out.println("Incorrect Entry In Text Box");
		}
	}

	public void updateInitiative() {
		String entry = InitiativeTypeBox.getText();
		if (tryParseInt(entry)) {
			FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setInitiative(Integer.parseInt(entry));
		} else {
			System.out.println("Incorrect Entry In Text Box");
		}
	}

	// mini try parse int so everything doesnt break when someone tries to enter a
	// string
	boolean tryParseInt(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public void updateCha() {
		try {
			FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setCharisma((int) ChaSlider.getValue());
		} catch (NullPointerException e) {

		}
	}

	public void updateDex() {
		try {
			FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setDexterity((int) DexSlider.getValue());
		} catch (NullPointerException e) {

		}
	}

	public void updateInt() {
		try {
			FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setInteligence((int) IntSlider.getValue());
		} catch (NullPointerException e) {

		}
	}

	public void updateWis() {
		try {
			FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setWisdom((int) WisSlider.getValue());
		} catch (NullPointerException e) {

		}
	}

	public void updateStr() {
		try {
			FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setStength((int) StrSlider.getValue());
		} catch (NullPointerException e) {

		}
	}

	public void updateCon() {
		try {
			FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setConstitution((int) ConSlider.getValue());
		} catch (NullPointerException e) {

		}
	}

	public void updateHitDice() {
		String dice = (String) HitDiceSelect.getValue();
		try {
			FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setHitDie(dice);
		} catch (NullPointerException e) {

		}
	}

	public void loadEntities() {
		FPADriver.getSavePath(null);
		FPADriver.AvaliableEntities = FPADriver.importEntity();
		updateChoiceBox();

	}

	public void saveEntities() {
		FPADriver.getSavePath(null);
		FPADriver.exportEntity(FPADriver.AvaliableEntities);
	}
}
