package application;

import java.io.IOException;

import controllers.EntityController;
import controllers.UIController;
import interfaces.ConsoleUI;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FPADriver extends Application {

String pathMap = "MapView.fxml";
String pathEntity = "EntityView.fxml";
Scene sceneMap, sceneEntity;



	@Override
	public void start(Stage Stage) throws IOException {
//		FXMLLoader loader = new FXMLLoader((getClass().getResource(mapPath)));
//		FXMLLoader loader = new FXMLLoader((getClass().getResource(entityPath)));
		FXMLLoader loader = new FXMLLoader((getClass().getResource(pathMap)));
		FXMLLoader loader2 = new FXMLLoader((getClass().getResource(pathEntity)));
		
		

		Parent root = loader.load();
		Parent root2 = loader2.load();
		
		UIController controller = loader.getController();
		EntityController controller2 = loader2.getController();
		
		controller.setMain(this);
		
		sceneMap = new Scene(root, 1200, 800);
		sceneEntity = new Scene(root2, 1200,800);
		Stage.setScene(sceneMap);
		Stage.setAlwaysOnTop(false);
		Stage.setResizable(false);
		Stage.show();
		
		controller.entitySceneSwap.setOnAction(e -> Stage.setScene(sceneEntity));
		controller2.entities.setOnAction(e -> Stage.setScene(sceneMap));
//		controller2.entities.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

//			@Override
//			public void handle(ActionEvent event) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
//		controller.entityButton.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent event) {
//				controller.entityButton.setText("YAY!!");
//			}
//		});
	}

	public static void main(String[] args) {
		launch(args);

	}
}
