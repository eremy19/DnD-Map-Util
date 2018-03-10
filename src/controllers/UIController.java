package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import application.FPADriver;
import dice.Dice;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import models.Entity;
import models.Mob;
import models.Player;
import util.Map;

public class UIController {
	private static HashMap<String, Map> AvaliableMaps = new HashMap();
	public String color = "-fx-background-color: lightgreen;";
	public String entityStyle = null;
	public Entity entityName = null;

	@FXML
	public Pane warrior;
	public Pane ranger;
	public Pane wizard;
	public Pane dragonborn;
	public Pane dwarf;
	public Pane tiefling;
	public Pane monk;
	public Pane highelf;

	@FXML
	public Button entityButton;
	public Button entitySceneSwap;
	public Button ImportMap;
	public Button ExportButton;
	public Button mapSelectButton;
	public Button Default;
	public Button White;
	public Button Black;
	public Button Grey;
	public Button Brown;
	public Button Blue;
	public Button Yellow;
	public Button Red;
	public Button Orange;
	public Button Purple;
	public Button Green;
	public Button changeHealthButton;
	public Button viewStatsButton;
	public Button removeEntityButton;

	public ChoiceBox<String> mapSelect;
	public ChoiceBox<String> entitySelect;
	public Pane p1;
	public GridPane mapGrid;
	public GridPane gridScene;
	public boolean isDragging = false;
	public boolean entitySelected = false;
	public boolean canSelect = false;

	public javafx.scene.control.TextArea descriptionArea;
	public TextField DiceBox;
	public TextField HPBox;

	public Button ResetMap;
	private FPADriver FPAD;

	public void setMain(FPADriver FPAD) {
		this.FPAD = FPAD;
	}

	public void handleButton() {
		if (entityButton.getText().equals("Placing...")) {
			entityButton.setText("Select");
			entitySelected = false;
		} else if (canSelect) {
			entityButton.setText("Placing...");
			entitySelected = true;
		}
	}

	public void selectColorWhite() {
		color = "-fx-background-color: white";
		descriptionArea.appendText("Color changed to:" + color.substring(21));
		descriptionArea.appendText("\n");
		descriptionArea.setEditable(false);
	}

	public void selectColorBlack() {
		color = "-fx-background-color: black";
		descriptionArea.appendText("Color changed to:" + color.substring(21));
		descriptionArea.appendText("\n");
		descriptionArea.setEditable(false);
	}

	public void selectColorBlue() {
		color = "-fx-background-color: blue";
		descriptionArea.appendText("Color changed to:" + color.substring(21));
		descriptionArea.appendText("\n");
		descriptionArea.setEditable(false);
	}

	public void selectColorBrown() {
		color = "-fx-background-color: brown";
		descriptionArea.appendText("Color changed to:" + color.substring(21));
		descriptionArea.appendText("\n");
		descriptionArea.setEditable(false);
	}

	public void selectColorGrey() {
		color = "-fx-background-color: grey";
		descriptionArea.appendText("Color changed to:" + color.substring(21));
		descriptionArea.appendText("\n");
		descriptionArea.setEditable(false);
	}

	public void selectColorRed() {
		color = "-fx-background-color: red";
		descriptionArea.appendText("Color changed to:" + color.substring(21));
		descriptionArea.appendText("\n");
		descriptionArea.setEditable(false);
	}

	public void selectColorOrange() {
		color = "-fx-background-color: orange";
		descriptionArea.appendText("Color changed to:" + color.substring(21));
		descriptionArea.appendText("\n");
		descriptionArea.setEditable(false);
	}

	public void selectColorPurple() {

		color = "-fx-background-color: purple";
		descriptionArea.appendText("Color changed to:" + color.substring(21));
		descriptionArea.appendText("\n");
		descriptionArea.setEditable(false);
	}

	public void selectColorGreen() {
		color = "-fx-background-color: green";
		descriptionArea.appendText("Color changed to:" + color.substring(21));
		descriptionArea.appendText("\n");
		descriptionArea.setEditable(false);
	}

	public void selectColorYellow() {
		color = "-fx-background-color: yellow";
		descriptionArea.appendText("Color changed to:" + color.substring(21));
		descriptionArea.appendText("\n");
		descriptionArea.setEditable(false);

	}

	public void selectColorDefault() {
		color = "-fx-background-color: lightgreen;";
		descriptionArea.appendText("Color changed to:" + color.substring(21));
		descriptionArea.appendText("\n");
		descriptionArea.setEditable(false);
	}
	public void rollDice() {
		String[] dice = DiceBox.getText().split("d");
		if (dice.length == 2) {
			if (dice[0].equals("")) {
				rollOne();
			} else {
				rollMult(dice);
			}
		} else {
			descriptionArea.appendText("Entered an Invalid Die");
		}
		descriptionArea.appendText("\n");
	}
	public void changeHealth() {
		String temp = null;
		temp = HPBox.getText();
		boolean parseable = false;
		try {
			Integer.parseInt(temp);
			parseable = true;
		} catch (NumberFormatException e) {
			parseable = false;
		}
		if (parseable) {
			Integer newHealth = 0;
			newHealth = Integer.parseInt(temp);
			FPADriver.AvaliableEntities.get(entityName.mob.getName()).setCurrentHP(newHealth);
			descriptionArea.appendText(entityName.mob.getName() + "'s current hp: " + newHealth + "\n \n");
		} else {
			descriptionArea.appendText("You entered an invalid input \n\n");
		}
	}
	public void viewStats() {
		descriptionArea.appendText(entityName.mob.toString() + "\n");
	}
	public void removefromMap() {
		Pane p = (Pane) entityName.button.getParent();
		p.getChildren().remove(entityName.button);
		entityName = null;
	}
	
	public void rollOne() {
		Integer temp = 0;
		Dice d = new Dice();
		d.fillMap();
		if (DiceBox.getText().equals("d4")) {
			temp = d.rollDice("d4");
			descriptionArea.appendText("You rolled: " + temp);
		} else if (DiceBox.getText().equals("d6")) {
			temp = d.rollDice("d6");
			descriptionArea.appendText("You rolled: " + temp);
		} else if (DiceBox.getText().equals("d8")) {
			temp = d.rollDice("d8");
			descriptionArea.appendText("You rolled: " + temp);
		} else if (DiceBox.getText().equals("d10")) {
			temp = d.rollDice("d10");
			descriptionArea.appendText("You rolled: " + temp);
		} else if (DiceBox.getText().equals("d12")) {
			temp = d.rollDice("d12");
			descriptionArea.appendText("You rolled: " + temp);
		} else if (DiceBox.getText().equals("d20")) {
			temp = d.rollDice("d20");
			descriptionArea.appendText("You rolled: " + temp);
		} else if (DiceBox.getText().equals("d100")) {
			temp = d.rollDice("d100");
			descriptionArea.appendText("You rolled: " + temp);
		} else {
			descriptionArea.appendText("You entered an invalid die\n");
		}
	}

	public void rollMult(String[] dice) {
		Integer temp = 0;
		Dice d = new Dice();
		d.fillMap();
		boolean parseable = false;
		try {
			Integer.parseInt(dice[0]);
			parseable = true;
		} catch (NumberFormatException e) {
			parseable = false;
		}
		if (parseable) {
			int num = Integer.parseInt(dice[0]);
			descriptionArea.appendText("You rolled: ");
			ArrayList<Integer> dicetotal = new ArrayList<>();
			for (int i = 0; i < num; i++) {
				if (dice[1].equals("4")) {
					temp = d.rollDice("d4");
					dicetotal.add(temp);
				} else if (dice[1].equals("6")) {
					temp = d.rollDice("d6");
					dicetotal.add(temp);
				} else if (dice[1].equals("8")) {
					temp = d.rollDice("d8");
					dicetotal.add(temp);
				} else if (dice[1].equals("10")) {
					temp = d.rollDice("d10");
					dicetotal.add(temp);
				} else if (dice[1].equals("12")) {
					temp = d.rollDice("d12");
					dicetotal.add(temp);
				} else if (dice[1].equals("20")) {
					temp = d.rollDice("d20");
					dicetotal.add(temp);
				} else if (dice[1].equals("100")) {
					temp = d.rollDice("d100");
					dicetotal.add(temp);
				} else {
				}
			}
			if (dicetotal.isEmpty()) {
				descriptionArea.appendText("Invalid Die\n");
			} else {
				descriptionArea.appendText("" + dicetotal.get(0));
				int total = dicetotal.get(0);
				for (int j = 1; j < dicetotal.size(); j++) {
					descriptionArea.appendText(" + " + dicetotal.get(j));
					total += dicetotal.get(j);
				}
				descriptionArea.appendText(" = " + total);
			}
		} else {
			descriptionArea.appendText("You entered an invalid die\n");
		}
	}

	public void reset() {
		for (int i = 0; (i < mapGrid.getChildren().size() - 1) && i <= 191; i++) {

			FPADriver.mapContents.get(i).getChildren()
					.removeAll(FXCollections.observableArrayList(FPADriver.mapContents.get(i).getChildren()));

			mapGrid.getChildren().get(i)
					.setStyle("-fx-background-color: lightgreen; -fx-border-color: black; -fx-border-width: 0.5;");
			System.out.println(mapGrid.getChildren().size() + " "  +i);
		}
	}

	public void loadMap() {
		FPADriver.importMap();
		updateMapChoiceBox();
	}

	public void saveMap() {
		FPADriver.exportMap(FPADriver.mapContents);
		updateMapChoiceBox();
	}

	public void updateMapChoiceBox() {
		ArrayList<Map> temp = (ArrayList<Map>) FPADriver.returnMaps();
		ArrayList<String> mapNames = new ArrayList<>();
		int i = 0;
		for (Map m : temp) {
			mapNames.add(m.name);
			AvaliableMaps.put(m.name, m);

		}
		Collections.sort(mapNames);
		mapSelect.setItems(FXCollections.observableArrayList(mapNames));
	}

	public void updateEntityChoiceBox() {
		ArrayList<String> names = new ArrayList<>();
		for (String name : FPADriver.AvaliableEntities.keySet()) {
			names.add(name);
		}
		Collections.sort(names);
		entitySelect.setItems(FXCollections.observableArrayList(names));
	}

	public void mapSelector() {
		String name = mapSelect.getValue();

		for (Map m : FPADriver.maps) {
			if (m.name.equals(name)) {

				FPADriver.setMap(m);
			}
		}
	}

	public void updateSelector() {
		if (entitySelect.getValue() != null && entitySelect.getValue().length() > 1) {
			canSelect = true;
			entityButton.setStyle("");
		} else {
			canSelect = false;
		}
	}

	public void deselect() {
		entityName = null;
		HPBox.setDisable(true);
		removeEntityButton.setDisable(true);
		viewStatsButton.setDisable(true);
		changeHealthButton.setDisable(true);
	}

	public void txtReset() {
		descriptionArea.setText("");
	}
 
	public void setPicWarrior() {
		if (entityStyle != null) {
			descriptionArea.appendText("Icon discarded\n");
			entityStyle = null;
		} else {
		descriptionArea.appendText("Icon Warrior loaded...\n");
			entityStyle = "-fx-background-color: black;-fx-background-image: url(/pics/warrior.png);-fx-background-repeat: stretch;-fx-background-position: center center;-fx-background-size: 100.0% 100.0%;";
		}
	}

	public void setPicRanger() {
		if (entityStyle != null) {
			descriptionArea.appendText("Icon discarded\n");
			entityStyle = null;
		} else {
		descriptionArea.appendText("Icon Archer loaded...\n");

			entityStyle = "-fx-background-color: black;-fx-background-image: url(/pics/ranger.png);-fx-background-repeat: stretch;-fx-background-position: center center;-fx-background-size: 100.0% 100.0%;";
		}
	}

	public void setPicWizard() {
		if (entityStyle != null) {
			descriptionArea.appendText("Icon discarded\n");
			entityStyle = null;
		} else {
		descriptionArea.appendText("Icon Wizard loaded...\n");

			entityStyle = "-fx-background-color: black;-fx-background-image: url(/pics/wizard.png);-fx-background-repeat: stretch;-fx-background-position: center center;-fx-background-size: 100.0% 100.0%;";
		}
	}

	public void setPicDragonBorn() {
		if (entityStyle != null) {
			descriptionArea.appendText("Icon discarded\n");
			entityStyle = null;
		} else {
		descriptionArea.appendText("Icon Dragonborn loaded...\n");

			entityStyle = "-fx-background-color: black;-fx-background-image: url(/pics/dragonborn.png);-fx-background-repeat: stretch;-fx-background-position: center center;-fx-background-size: 100.0% 100.0%;";
		}
	}

	public void setPicDwarf() {
		if (entityStyle != null) {
			descriptionArea.appendText("Icon discarded\n");
			entityStyle = null;
		} else {
		descriptionArea.appendText("Icon Dwarf loaded...\n");

			entityStyle = "-fx-background-color: black;-fx-background-image: url(/pics/dwarf.png);-fx-background-repeat: stretch;-fx-background-position: center center;-fx-background-size: 100.0% 100.0%;";
		}
	}

	public void setPicTiefling() {
		if (entityStyle != null) {
			descriptionArea.appendText("Icon discarded\n");
			entityStyle = null;
		} else {
		descriptionArea.appendText("Icon Tiefling loaded...\n");

			entityStyle = "-fx-background-color: black;-fx-background-image: url(/pics/tiefling.png);-fx-background-repeat: stretch;-fx-background-position: center center;-fx-background-size: 100.0% 100.0%;";
		}
	}

	public void setPicHighelf() {
		if (entityStyle != null) {
			descriptionArea.appendText("Icon discarded\n");
			entityStyle = null;
		} else {
		descriptionArea.appendText("Icon High elf loaded...\n");
			entityStyle = "-fx-background-color: black;-fx-background-image: url(/pics/highelf.png);-fx-background-repeat: stretch;-fx-background-position: center center;-fx-background-size: 100.0% 100.0%;";
		}
	}

	public void setPicMonk() {
		if (entityStyle != null) {
			descriptionArea.appendText("Icon discarded\n");
			entityStyle = null;
		} else {
		descriptionArea.appendText("Icon monk loaded...\n");

			entityStyle = "-fx-background-color: black;-fx-background-image: url(/pics/monk.png);-fx-background-repeat: stretch;-fx-background-position: center center;-fx-background-size: 100.0% 100.0%;";
		}
	}
	
	public void moveCharacter() {
//		
//		String[] keysPressed = new String[FPADriver.currentlyActiveKeys.size()];
//		keysPressed = FPADriver.currentlyActiveKeys.toArray(keysPressed);
//		String key = keysPressed[0];
//		
//		sout
//		
//		if (entityName != null && key.equals("W")) {
//			int i = FPADriver.mapContents.indexOf(entityName.button.getParent());
//			if (FPADriver.mapContents.get(i-gridScene.getColumnConstraints().size()).getChildren().size() <1) {
//			FPADriver.mapContents.get(i-gridScene.getColumnConstraints().size()).getChildren().add(entityName.button);
//			FPADriver.mapContents.get(i).getChildren().removeAll(entityName.button);
//			}
//		}
	}
}
