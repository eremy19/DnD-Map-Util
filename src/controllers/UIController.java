package controllers;

import application.FPADriver;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class UIController {
	private String color = "-fx-background-color: lightgreen;";
	
	@FXML
	public Button entityButton;
	public Button entitySceneSwap;
	public Button ImportMap;
	public Button ExportButton;
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
	public Pane p1;
	public GridPane mapGrid;
	public javafx.scene.control.TextArea descriptionArea;

	
	
	private FPADriver FPAD;

	
	
	public void setMain(FPADriver FPAD) {
		this.FPAD = FPAD;
	}

	
	
	public void handleButton() {
		if (entityButton.getText().equals("Entity Selected")) {
			entityButton.setText("Entity");
		} else {
			entityButton.setText("Entity Selected");
		}
	}
	
	public void selectColorWhite() {
		
		
		color = "-fx-background-color: white";
		//System.out.println("Color changed to " + color);
		descriptionArea.appendText("Color changed to:" + color.substring(21));
//		DecreptionArea.appendText("Color changed to: " + color);
		descriptionArea.appendText("\n");
		descriptionArea.setEditable(false);
	}
	
	public void selectColorBlack() {
		
		
		color = "-fx-background-color: black";
		//System.out.println("Color changed to " + color);
		descriptionArea.appendText("Color changed to:" + color.substring(21));
//		DecreptionArea.appendText("Color changed to: " + color);
		descriptionArea.appendText("\n");
		descriptionArea.setEditable(false);
	}
	
	public void selectColorBlue() {
		
		
		color = "-fx-background-color: blue";
		//System.out.println("Color changed to " + color);
		descriptionArea.appendText("Color changed to:" + color.substring(21));
//		DecreptionArea.appendText("Color changed to: " + color);
		descriptionArea.appendText("\n");
		descriptionArea.setEditable(false);
	}

	public void selectColorBrown() {
		
		
		color = "-fx-background-color: brown";
		//System.out.println("Color changed to " + color);
		descriptionArea.appendText("Color changed to:" + color.substring(21));
//		DecreptionArea.appendText("Color changed to: " + color);
		descriptionArea.appendText("\n");
		descriptionArea.setEditable(false);
	}

	public void selectColorGrey() {
	
	
	color = "-fx-background-color: grey";
	//System.out.println("Color changed to " + color);
	descriptionArea.appendText("Color changed to:" + color.substring(21));
//	DecreptionArea.appendText("Color changed to: " + color);
	descriptionArea.appendText("\n");
	descriptionArea.setEditable(false);
}

	public void selectColorRed() {
	
	
	color = "-fx-background-color: red";
	//System.out.println("Color changed to " + color);
	descriptionArea.appendText("Color changed to:" + color.substring(21));
//	DecreptionArea.appendText("Color changed to: " + color);
	descriptionArea.appendText("\n");
	descriptionArea.setEditable(false);
}

	public void selectColorOrange() {
	
	
	color = "-fx-background-color: orange";
	//System.out.println("Color changed to " + color);
	descriptionArea.appendText("Color changed to:" + color.substring(21));
//	DecreptionArea.appendText("Color changed to: " + color);
	descriptionArea.appendText("\n");
	descriptionArea.setEditable(false);
}

	public void selectColorPurple() {
	
	
	color = "-fx-background-color: purple";
	//System.out.println("Color changed to " + color);
	descriptionArea.appendText("Color changed to:" + color.substring(21));
//	DecreptionArea.appendText("Color changed to: " + color);
	descriptionArea.appendText("\n");
	descriptionArea.setEditable(false);
}

	public void selectColorGreen() {
	
	
	color = "-fx-background-color: green";
	//System.out.println("Color changed to " + color);
	descriptionArea.appendText("Color changed to:" + color.substring(21));
//	DecreptionArea.appendText("Color changed to: " + color);
	descriptionArea.appendText("\n");
	descriptionArea.setEditable(false);
}

	public void selectColorYellow() {
	
	
	color = "-fx-background-color: yellow";
	//System.out.println("Color changed to " + color);
	descriptionArea.appendText("Color changed to:" + color.substring(21));
//	DecreptionArea.appendText("Color changed to: " + color);
	descriptionArea.appendText("\n");
	descriptionArea.setEditable(false);
	
}

	public void selectColorDefault() {
		color = "-fx-background-color: lightgreen;";
		//System.out.println("Color changed to " + color);
		descriptionArea.appendText("Color changed to:" + color.substring(21));
//		DecreptionArea.appendText("Color changed to: " + color);
		descriptionArea.appendText("\n");
		descriptionArea.setEditable(false);
	}
	
	public void pane1Change() {
	p1.setStyle(color);
	}
	
//	public void loadMap() {
//		FPADriver.filePath();
//	}


	public void loadMap() {
		FPADriver.importMap();
	}
	public void saveMap() {
		FPADriver.exportMap();
	}
	
	
//	class buttonHandler implements EventHandler<ActionEvent>{
		
		
		
//	
//		public void handle(ActionEvent event) {
//			FPADriver.filePath();
//			
//		}
		
//	}
	
}

