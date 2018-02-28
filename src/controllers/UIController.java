package controllers;

import application.FPADriver;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class UIController {
 
	@FXML
	public Button entityButton;

	private FPADriver FPAD;

	
	
	public void setMain(FPADriver FPAD) {
		this.FPAD = FPAD;
	}

	
	
	public void handleButton() {
		entityButton.setText("Changed");
	}
	
	class buttonHandler implements EventHandler<ActionEvent>{
		
		
		
		@Override
		public void handle(ActionEvent event) {
			
			
		}
		
	}
	
}

