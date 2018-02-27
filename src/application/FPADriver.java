package application;

import java.io.IOException;

import controllers.UIController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FPADriver extends Application {
	String path = "../fxml/MapView.fxml";


	@Override
	public void start(Stage Stage) throws IOException {
		FXMLLoader loader = new FXMLLoader((getClass().getResource(path)));
		Parent root = loader.load();
		
		UIController controller = loader.getController();
		
		controller.setMain(this);
		
		Scene scene = new Scene(root, 1200, 800);
		Stage.setScene(scene);
		Stage.setAlwaysOnTop(true);
		Stage.setResizable(false);
		Stage.show();

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
