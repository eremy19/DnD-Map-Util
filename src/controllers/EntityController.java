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
<<<<<<< HEAD
		if(temp.isEmpty()) {
			for(Mob m:AvaliableEntities.values()) {
				names.add(m.getName());
				temp.add(m);
				
			}
			
		}else {
			for (Mob m: temp) {
				names.add(m.getName());
				AvaliableEntities.put(m.getName(), m);
			
		}
=======
		for (String name : FPADriver.AvaliableEntities.keySet()) {
			names.add(name);
>>>>>>> f10324ccfe649fc4dbad1266dca98145faadff82
		}
		chooseEntity.setItems(FXCollections.observableArrayList(names));
	}

	public void entitySelected() {
		NameTypeBox.setText(FPADriver.AvaliableEntities.get(chooseEntity.getValue()).getName());
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

	}

	public void updateName() {
		Mob temp = FPADriver.AvaliableEntities.get(chooseEntity.getValue());
		temp.setName(NameTypeBox.getText());
		if (FPADriver.AvaliableEntities.containsKey(temp.getName())) {	
			FPADriver.AvaliableEntities.remove(chooseEntity.getValue());
			String newName = temp.getName() + "(1)";
			temp.setName(newName);
			FPADriver.AvaliableEntities.put(temp.getName() ,temp);
		} else {
			FPADriver.AvaliableEntities.remove(chooseEntity.getValue());
			FPADriver.AvaliableEntities.put(temp.getName(), temp);
		}
		updateChoiceBox();
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
		FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setCharisma((int) ChaSlider.getValue());
	}

	public void updateDex() {
		FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setDexterity((int) DexSlider.getValue());
	}

	public void updateInt() {
		FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setInteligence((int) IntSlider.getValue());
	}

	public void updateWis() {
		FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setWisdom((int) WisSlider.getValue());
	}

	public void updateStr() {
		FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setStength((int) StrSlider.getValue());
	}

	public void updateCon() {
		FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setConstitution((int) ConSlider.getValue());
	}

	public void updateHitDice() {
		String dice = (String) HitDiceSelect.getValue();
		FPADriver.AvaliableEntities.get(chooseEntity.getValue()).setHitDie(dice);
	}
	
	public void loadEntities() {
		FPADriver.getSavePath(null);
		AvaliableEntities = FPADriver.importSingleEntity();
		updateChoiceBox();
		
	}
	public void saveEntities() {
		FPADriver.getSavePath(null);
		FPADriver.exportSingleEntity(AvaliableEntities);
	}
}
