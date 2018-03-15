package controllers;

import java.util.ArrayList;
import java.util.Collections;
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
	public Button NameOk;
	public Button HealthOk;
	public Button AbilitesOk;
	public Button SkillsOk;
	public Button NotesOk;
	public Button SpeedOk;
	public Button DiceOk;
	public Button removeButton;
	public Button confAttButton;
	public ChoiceBox chooseEntity;
	public TextField NameTypeBox;
	public TextField HealthTypeBox;
	public TextField SpeedTypeBox;
	public TextField SkillsTypeBox;
	public TextField AbilitiesTypeBox;
	public TextField NotesTypeBox;
	public Label CurrentName;
	public Slider Att1Slider;
	public Slider Att2Slider;
	public Slider Att3Slider;
	public Slider Att4Slider;
	public Slider Att5Slider;
	public Slider Att6Slider;
	public ChoiceBox HitDiceSelect;
	public Button CharacterCreate;
	public Button MonsterCreate;
	public int MonsterNum;
	public int PlayerNum = 0;
	public Label attribute1Label;
	public Label attribute2Label;
	public Label attribute3Label;
	public Label attribute4Label;
	public Label attribute5Label;
	public Label attribute6Label;

	
	public void generateBlankPlayer() {
		String name = "Character " + ++PlayerNum;
		Player mobBlank = new Player(name, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, "Unassigned Skill", "Unassigned Ability", "d4");
		System.out.println(mobBlank.toString());
		FPADriver.addPlayer(mobBlank);
		updateChoiceBox();
	}

	public void generateBlankMonster() {
		String name = "Monster " + ++MonsterNum;
		Monster mobBlank = new Monster(name, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, "Unassigned Skill", "Unassigned Ability", "d4");
		System.out.println(mobBlank.toString());
		FPADriver.addMonster(mobBlank);
		updateChoiceBox();
	}

	public void updateChoiceBox() {
		ArrayList<String> names = new ArrayList<>();
		for (String name : FPADriver.AvaliableEntities.keySet()) {
			names.add(name);
		}
		Collections.sort(names);
		chooseEntity.setItems(FXCollections.observableArrayList(names));
	}

	public void entitySelected() {
		try {
			NameTypeBox.setText(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getName());
			HealthTypeBox.setText(String.valueOf(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getMaxHP()));
			SkillsTypeBox.setText(String.valueOf(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getSkills()));
			AbilitiesTypeBox.setText(
					String.valueOf(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getAbilities()));
			NotesTypeBox.setText(
					String.valueOf(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getNotes()));
			SpeedTypeBox.setText(String.valueOf(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getSpeed()));
			Att1Slider.setValue(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getAttribute1());
			Att2Slider.setValue(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getAttribute2());
			Att3Slider.setValue(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getAttribute3());
			Att4Slider.setValue(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getAttribute4());
			Att5Slider.setValue(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getAttribute5());
			Att6Slider.setValue(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getAttribute6());
			HitDiceSelect.setValue(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getAssignedDie());
			updateAttributeLabels(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getAttribute1name(), FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getAttribute2name(), FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getAttribute3name(), FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getAttribute4name(), FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getAttribute5name(), FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getAttribute6name());
			disableEdit(false);
		} catch (NullPointerException e) {

		}

	}

	public void disableEdit(Boolean tf) {
		NameTypeBox.setDisable(tf);
		DiceOk.setDisable(tf);
		removeButton.setDisable(tf);
		HealthTypeBox.setDisable(tf);
		SkillsTypeBox.setDisable(tf);
		AbilitiesTypeBox.setDisable(tf);
		NotesTypeBox.setDisable(tf);
		SpeedTypeBox.setDisable(tf);
		Att1Slider.setDisable(tf);
		Att2Slider.setDisable(tf);
		Att3Slider.setDisable(tf);
		Att4Slider.setDisable(tf);
		Att5Slider.setDisable(tf);
		Att6Slider.setDisable(tf);
		HitDiceSelect.setDisable(tf);
		NameOk.setDisable(tf);
		HealthOk.setDisable(tf);
		NotesOk.setDisable(tf);
		SkillsOk.setDisable(tf);
		AbilitesOk.setDisable(tf);
		SpeedOk.setDisable(tf);
		confAttButton.setDisable(tf);
	}
	public void removeEntity() {
		FPADriver.AvaliableEntities.remove(chooseEntity.getValue());
		disableEdit(true);
		updateChoiceBox();
	}
	public void updateAttributeLabels(String att1, String att2,String att3,String att4,String att5,String att6) {
		attribute1Label.setText(att1);
		attribute2Label.setText(att2);
		attribute3Label.setText(att3);
		attribute4Label.setText(att4);
		attribute5Label.setText(att5);
		attribute6Label.setText(att6);
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
		disableEdit(true);
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
	

	public void updateSpeed() {
		String entry = SpeedTypeBox.getText();
		if (tryParseInt(entry)) {
			FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setSpeed(Integer.parseInt(entry));
		} else {
			System.out.println("Incorrect Entry In Text Box");
		}
	}

	public void updateSkills() {
		String entry = SkillsTypeBox.getText();
		if (tryParseInt(entry)) {
			FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setSkills(entry);
		} else {
			System.out.println("Incorrect Entry In Text Box");
		}
	}
	public void updateAbilities() {
		String entry = AbilitiesTypeBox.getText();
		if (tryParseInt(entry)) {
			FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setAbilities(entry);
		} else {
			System.out.println("Incorrect Entry In Text Box");
		}
	}
	public void updateNotes(){
		String entry = NotesTypeBox.getText();
		if (tryParseInt(entry)) {
			FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setNotes(entry);
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

	public void updateAtt1() {
		try {
			FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setAttribute1((int) Att1Slider.getValue());
		} catch (NullPointerException e) {

		}
	}

	public void updateAtt2() {
		try {
			FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setAttribute2((int) Att2Slider.getValue());
		} catch (NullPointerException e) {

		}
	}

	public void updateAtt3() {
		try {
			FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setAttribute3((int) Att3Slider.getValue());
		} catch (NullPointerException e) {

		}
	}

	public void updateAtt4() {
		try {
			FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setAttribute4((int) Att4Slider.getValue());
		} catch (NullPointerException e) {

		}
	}

	public void updateAtt5() {
		try {
			FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setAttribute5((int) Att5Slider.getValue());
		} catch (NullPointerException e) {

		}
	}

	public void updateAtt6() {
		try {
			FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setAttribute6((int) Att6Slider.getValue());
		} catch (NullPointerException e) {

		}
	}

	public void updateHitDice() {
		String dice = (String) HitDiceSelect.getValue();
		try {
			FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setAssignedDie(dice);
		} catch (NullPointerException e) {

		}
	}

	public void loadEntities() {
		FPADriver.getSavePath(null);
		FPADriver.importSingleEntity(null);
		updateChoiceBox();

	}

	public void saveEntities() {
		FPADriver.getSavePath(null);
		FPADriver.exportSingleEntity(FPADriver.AvaliableEntities.get(chooseEntity.getValue()), null);
	}
}
