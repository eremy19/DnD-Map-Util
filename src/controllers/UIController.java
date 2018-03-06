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
import util.Map;

public class UIController {
	private static HashMap<String, Map> AvaliableMaps = new HashMap();
	public String color = "-fx-background-color: lightgreen;";

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
	public Pane p1;

	public GridPane mapGrid;
	// ---------------------------------------------------------------------------------------------------------------
	// Jett 3/3/18
	public GridPane gridScene;

	public boolean isDragging = false;
	public boolean entitySelected = false;

	// ---------------------------------------------------------------------------------------------------------------

	public javafx.scene.control.TextArea descriptionArea;
//---------------------Levi 3/6 (Start)--------------------------------	
	public ChoiceBox<String> optionBox;
	public TextField TextBox;
	public Button textConfirm;
	//---------------Levi (Break 3/6)-----------------------------
	private FPADriver FPAD;

	public void setMain(FPADriver FPAD) {
		this.FPAD = FPAD;
	}

	public void handleButton() {
		if (entityButton.getText().equals("Entity Selected")) {
			entityButton.setText("Entity");
			entitySelected = false;
		} else {
			entityButton.setText("Entity Selected");
			entitySelected = true;
		}
	}

	public void selectColorWhite() {

		color = "-fx-background-color: white";
		// System.out.println("Color changed to " + color);
		descriptionArea.appendText("Color changed to:" + color.substring(21));
		// DecreptionArea.appendText("Color changed to: " + color);
		descriptionArea.appendText("\n");
		descriptionArea.setEditable(false);
	}

	public void selectColorBlack() {

		color = "-fx-background-color: black";
		// System.out.println("Color changed to " + color);
		descriptionArea.appendText("Color changed to:" + color.substring(21));
		// DecreptionArea.appendText("Color changed to: " + color);
		descriptionArea.appendText("\n");
		descriptionArea.setEditable(false);
	}

	public void selectColorBlue() {

		color = "-fx-background-color: blue";
		// System.out.println("Color changed to " + color);
		descriptionArea.appendText("Color changed to:" + color.substring(21));
		// DecreptionArea.appendText("Color changed to: " + color);
		descriptionArea.appendText("\n");
		descriptionArea.setEditable(false);
	}

	public void selectColorBrown() {

		color = "-fx-background-color: brown";
		// System.out.println("Color changed to " + color);
		descriptionArea.appendText("Color changed to:" + color.substring(21));
		// DecreptionArea.appendText("Color changed to: " + color);
		descriptionArea.appendText("\n");
		descriptionArea.setEditable(false);
	}

	public void selectColorGrey() {

		color = "-fx-background-color: grey";
		// System.out.println("Color changed to " + color);
		descriptionArea.appendText("Color changed to:" + color.substring(21));
		// DecreptionArea.appendText("Color changed to: " + color);
		descriptionArea.appendText("\n");
		descriptionArea.setEditable(false);
	}

	public void selectColorRed() {

		color = "-fx-background-color: red";
		// System.out.println("Color changed to " + color);
		descriptionArea.appendText("Color changed to:" + color.substring(21));
		// DecreptionArea.appendText("Color changed to: " + color);
		descriptionArea.appendText("\n");
		descriptionArea.setEditable(false);
	}

	public void selectColorOrange() {

		color = "-fx-background-color: orange";
		// System.out.println("Color changed to " + color);
		descriptionArea.appendText("Color changed to:" + color.substring(21));
		// DecreptionArea.appendText("Color changed to: " + color);
		descriptionArea.appendText("\n");
		descriptionArea.setEditable(false);
	}

	public void selectColorPurple() {

		color = "-fx-background-color: purple";
		// System.out.println("Color changed to " + color);
		descriptionArea.appendText("Color changed to:" + color.substring(21));
		// DecreptionArea.appendText("Color changed to: " + color);
		descriptionArea.appendText("\n");
		descriptionArea.setEditable(false);
	}

	public void selectColorGreen() {

		color = "-fx-background-color: green";
		// System.out.println("Color changed to " + color);
		descriptionArea.appendText("Color changed to:" + color.substring(21));
		// DecreptionArea.appendText("Color changed to: " + color);
		descriptionArea.appendText("\n");
		descriptionArea.setEditable(false);
	}

	public void selectColorYellow() {

		color = "-fx-background-color: yellow";
		// System.out.println("Color changed to " + color);
		descriptionArea.appendText("Color changed to:" + color.substring(21));
		// DecreptionArea.appendText("Color changed to: " + color);
		descriptionArea.appendText("\n");
		descriptionArea.setEditable(false);

	}

	public void selectColorDefault() {
		color = "-fx-background-color: lightgreen;";
		// System.out.println("Color changed to " + color);
		descriptionArea.appendText("Color changed to:" + color.substring(21));
		// DecreptionArea.appendText("Color changed to: " + color);
		descriptionArea.appendText("\n");
		descriptionArea.setEditable(false);
	}
//-----------------------(Levi Continue 3/6)----------------------------
	public void confirmText() {
		if(optionBox.getValue().equals("Roll Dice")) {
			Integer temp = 0;
			Dice d = new Dice();
			d.fillMap();
			if(TextBox.getText().equals("d4")) {
			temp = d.rollDice("d4");
				descriptionArea.appendText("You rolled: "+temp); 
			} else if(TextBox.getText().equals("d6")) {
				temp = d.rollDice("d6");
				descriptionArea.appendText("You rolled: "+temp); 				
			} else if(TextBox.getText().equals("d8")) {
				temp = d.rollDice("d8");
				descriptionArea.appendText("You rolled: "+temp); 				
			} else if(TextBox.getText().equals("d10")) {
				temp = d.rollDice("d10");
				descriptionArea.appendText("You rolled: "+temp); 
			} else if(TextBox.getText().equals("d12")) {
				temp = d.rollDice("d12");
				descriptionArea.appendText("You rolled: "+temp); 				
			} else if(TextBox.getText().equals("d20")) {
				temp = d.rollDice("d20");
				descriptionArea.appendText("You rolled: "+temp); 				
			} else if(TextBox.getText().equals("d100")) {
				temp = d.rollDice("d100");
				descriptionArea.appendText("You rolled: "+temp); 
			} else {
				descriptionArea.appendText("You entered an invalid die");
			}
			descriptionArea.appendText("\n");
		}
	}
	//-------------Levi (end)--------------------------------------
//	public void pane1Change() {
//		p1.setStyle(color);
//	}

	// public void loadMap() {
	// FPADriver.filePath();
	// }

	public void loadMap() {
		FPADriver.importMap();
		updateMapChoiceBox();
	}

	public void saveMap() {
		FPADriver.exportMap(FPADriver.mapContents);
	}

	// public void updateChoiceBox(){
	// ArrayList<Mob> temp = (ArrayList<Mob>)FPADriver.returnEntities();
	// ArrayList<String> names = new ArrayList<>();
	// for (Mob m: temp) {
	// names.add(m.getName());
	// AvaliableEntities.put(m.getName(), m);
	// }
	// chooseEntity.setItems(FXCollections.observableArrayList(names));
	// }
	public void updateMapChoiceBox() {
		ArrayList<Map> temp = (ArrayList<Map>) FPADriver.returnMaps();
		ArrayList<String> mapNames = new ArrayList<>();
		int i = 0;
		for (Map m : temp) {
			mapNames.add(m.name);
			AvaliableMaps.put(m.name, m);
		}
		// for(Map m : FPADriver.maps) {
		// AvaliableMaps.put(FPADriver.maps.get(i).name, FPADriver.maps.get(i));
		// mapNames.add(AvaliableMaps.get(i));
		// i++;
		// }
		mapSelect.setItems(FXCollections.observableArrayList(mapNames));
	}

	public void entitySelected() {
		// TODO Auto-generated method stub

	}

	public void mapSelector() {
		String name = mapSelect.getValue();

		for (Map m : FPADriver.maps) {
			if (m.name.equals(name)) {

				FPADriver.setMap(m);
			}
		}
	}

	// class buttonHandler implements EventHandler<ActionEvent>{

	//
	// public void handle(ActionEvent event) {
	// FPADriver.filePath();
	//
	// }

	// }

}
