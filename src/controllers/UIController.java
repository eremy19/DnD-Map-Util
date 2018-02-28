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
	private Button entityButton;
	private Button EntitySceneSwap;
	private Button ImportButton;
	private Button ExportButton;
	private Button Default;
	private Button White;
	private Button Black;
	private Button Grey;
	private Button Brown;
	private Button Blue;
	private Button Yellow;
	private Button Red;
	private Button Orange;
	private Button Purple;
	private Button Green;
	private Pane p1;

	
	
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

	
	
	
	class buttonHandler implements EventHandler<ActionEvent>{
		
		
		
		@Override
		public void handle(ActionEvent event) {
			
			
		}
		
	}
	
}

