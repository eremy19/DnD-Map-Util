package controllers;

import application.FPADriver;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
	public void selectColor() {
		color = "-fx-background-color: white;";
		System.out.println("Color changed to " + color);
	}

	public void loadMap() {
		FPADriver.filePath();
	}
	
	
//	class buttonHandler implements EventHandler<ActionEvent>{
		
		
		
//	
//		public void handle(ActionEvent event) {
//			FPADriver.filePath();
//			
//		}
		
//	}
	
}

