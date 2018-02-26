package fxml;


import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class guiView extends Application{

	public static void runWindow() {
		launch();
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		Parent root = FXMLLoader.load(getClass().getResource("OOPproject.fxml"));
		
		Scene scene = new Scene(root,1200,800);
		stage.setScene(scene);
		stage.setAlwaysOnTop(true);
		stage.setResizable(false);
		stage.show();
	}
	

	// need button mouse click listener to switch to Map
	
	public final ObjectProperty<EventHandler<? super MouseEvent>> onMouseClickedProperty(){
		return null;
	
	}
	
	// need button mouse click listener to switch to Entity Editor
	public final ObjectProperty<EventHandler<? super MouseEvent>> onMouseClickedProperty1(){
		
		return null;
	}
	
	
}
