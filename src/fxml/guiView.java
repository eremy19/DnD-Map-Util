package fxml;


import java.beans.EventHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class guiView extends Application implements Initializable{
	private Stage currentStage;
	private String filePath = "OOPproject.fxml";

	public static void runWindow() {
		launch();
	}
	@Override
	public void start(Stage stage) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("OOPproject.fxml"));
		Scene scene = new Scene(root,1200,800);
		stage.setScene(scene);
		stage.setAlwaysOnTop(true);
		stage.setResizable(false);
//		this is what is registering any and all mouse events. This was for me to test and debug and use for later.
//		change the ".ANY" to another filter to see that filter
		 scene.addEventFilter(MouseEvent.ANY, (event) ->{ // "(event) ->" is a Lambda Expression; to treat functionality as method argument, or code as data.
			 System.out.println("Target name: "+event.getTarget());
			 System.out.println("Event registered: "+ event.getEventType().getName());
		 });
		
		stage.show();
	}
	/*
	 * Notes on buttons
	 * added   fx:controller="fxml.guiView"   to fxml grid pane declaration
	 * In fxml File Change button id="" to fx:id=""
	 * @FXML Button EntitySceneSwap <---takes button id and allows you to have events on it
	 * initialize method works for setting the method needed for every button on MapView
	 */
	@FXML
	Button EntitySceneSwap;
	@FXML
	ChoiceBox MapSelect;
//	@FXML
//	Stage Scene;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//add action to button  
		EntitySceneSwap.setOnAction(this::changeToMap);
		//add options to combo box
		MapSelect.getItems().addAll("Option A", "Option B", "Option C");
	}
	
	private void changeToMap(ActionEvent event) {
		EntitySceneSwap.setText("Clicked Entities");
	}
	

	
	
	/*
	 * Attempts made to swap scenes:
	 * having a method+button where it uses stage.setScene(): error in try/catches
	 * @FXML MapSceneSwap button from Entity Scene doesnt work without the FXML Loader being for that fxml.
	 * re-calling start with "current stage" and using currentFilepath for the FXML Loader: error somehow 
	 * Having a second java file for the other FXML and scene: Error, cannot call launch() twice
	 */
    
    public static void main(String[] args) {
        launch(args);
    }

}
