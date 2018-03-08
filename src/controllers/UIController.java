package controllers;

import java.util.ArrayList;
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
	public Entity entityName = null;

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

	public ChoiceBox<String> mapSelect;
	public ChoiceBox<String> entitySelect;
	public Pane p1;
	public GridPane mapGrid;
	public GridPane gridScene;
	public boolean isDragging = false;
	public boolean entitySelected = false;
	public boolean canSelect = false;

	public javafx.scene.control.TextArea descriptionArea;
	public ChoiceBox<String> optionBox;
	public TextField TextBox;
	public Button textConfirm;
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

	public void confirmText() {
		try {
			if (optionBox.getValue().equals("Roll Dice")) {
				Integer temp = 0;
				Dice d = new Dice();
				d.fillMap();
				if (TextBox.getText().equals("d4")) {
					temp = d.rollDice("d4");
					descriptionArea.appendText("You rolled: " + temp);
				} else if (TextBox.getText().equals("d6")) {
					temp = d.rollDice("d6");
					descriptionArea.appendText("You rolled: " + temp);
				} else if (TextBox.getText().equals("d8")) {
					temp = d.rollDice("d8");
					descriptionArea.appendText("You rolled: " + temp);
				} else if (TextBox.getText().equals("d10")) {
					temp = d.rollDice("d10");
					descriptionArea.appendText("You rolled: " + temp);
				} else if (TextBox.getText().equals("d12")) {
					temp = d.rollDice("d12");
					descriptionArea.appendText("You rolled: " + temp);
				} else if (TextBox.getText().equals("d20")) {
					temp = d.rollDice("d20");
					descriptionArea.appendText("You rolled: " + temp);
				} else if (TextBox.getText().equals("d100")) {
					temp = d.rollDice("d100");
					descriptionArea.appendText("You rolled: " + temp);
				} else {
					descriptionArea.appendText("You entered an invalid die");
				}
				descriptionArea.appendText("\n");
			} else if (optionBox.getValue().equals("Change health")) {
				String temp = null;
				temp = TextBox.getText();
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
					descriptionArea.appendText(entityName.mob.getName() + "'s current hp: " + newHealth + "\n");
				} else {
					descriptionArea.appendText("You entered an invalid input \n");
				}
			} else if (optionBox.getValue().equals("Remove")) {
				Pane p = (Pane) entityName.button.getParent();
				p.getChildren().remove(entityName.button);
				entityName = null;
			} else if (optionBox.getValue().equals("More info")) {
				descriptionArea.appendText(entityName.mob.toString());
			}
		} catch (NumberFormatException e) {
			System.out.println("NumFormatEx");
		} catch (NullPointerException e) {

		}
	}

	public void reset() {
		for (int i = 0; i < mapGrid.getChildren().size()-1; i++) {

			FPADriver.mapContents.get(i).getChildren().removeAll(FXCollections.observableArrayList(FPADriver.mapContents.get(i).getChildren()));
			
			mapGrid.getChildren().get(i)
					.setStyle("-fx-background-color: lightgreen; -fx-border-color: black; -fx-border-width: 0.5;");
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
		mapSelect.setItems(FXCollections.observableArrayList(mapNames));
	}

	public void updateEntityChoiceBox() {
		ArrayList<String> names = new ArrayList<>();
		for (String name : FPADriver.AvaliableEntities.keySet()) {
			names.add(name);
		}
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
	}

	public void txtReset() {
		descriptionArea.setText("");
	}
}
