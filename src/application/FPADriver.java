package application;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import controllers.EntityController;
import controllers.UIController;
import item.Items;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import models.Mob;
import models.Monster;
import models.Player;
import util.Map;
import util.SaveFile;

public class FPADriver extends Application {

	String pathMap = "MapView.fxml";
	String pathEntity = "EntityView.fxml";
	Scene sceneMap, sceneEntity;
	static String saveMapPath = "";

	public static ArrayList<Map> maps = new ArrayList<>();
	public static ArrayList<Player> players = new ArrayList<>();
	public static ArrayList<Monster> monsters = new ArrayList<>();
	public static ArrayList<Items> items = new ArrayList<>();

	static public ArrayList<Pane> mapContents = new ArrayList<>();

	@Override
	public void start(Stage Stage) throws IOException {

		FXMLLoader loader = new FXMLLoader((getClass().getResource(pathMap)));
		FXMLLoader loader2 = new FXMLLoader((getClass().getResource(pathEntity)));

		Parent root = loader.load();
		Parent root2 = loader2.load();

		UIController controller = loader.getController();
		EntityController controller2 = loader2.getController();

		controller.setMain(this);

		GridPane map = controller.mapGrid;

		sceneMap = new Scene(root, 1200, 800);
		sceneEntity = new Scene(root2, 1200, 800);
		Stage.setScene(sceneMap);
		Stage.setAlwaysOnTop(false);
		Stage.setResizable(false);
		Stage.show();

		// ----------------------------------------------------------------------------------------------------------

		controller.entitySceneSwap.setOnAction(e -> Stage.setScene(sceneEntity));
		controller2.entities.setOnAction(e -> Stage.setScene(sceneMap));
<<<<<<< HEAD
		//Emily - setting listeners for sliders
	    controller2.DexSlider.valueProperty().addListener(new ChangeListener<Number>() {
	            public void changed(ObservableValue<? extends Number> ov,Number old_val, Number new_val) {
	            	controller2.updateDex();}});
	    controller2.WisSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,Number old_val, Number new_val) {
            	controller2.updateWis();}});
	    controller2.IntSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,Number old_val, Number new_val) {
            	controller2.updateInt();}});
	    controller2.ConSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,Number old_val, Number new_val) {
            	controller2.updateCon();}});
	    controller2.ChaSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,Number old_val, Number new_val) {
            	controller2.updateCha();}});
	    controller2.StrSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,Number old_val, Number new_val) {
            	controller2.updateStr();}});
		//Emily - Set HitDice Options
	    controller2.HitDiceSelect.setItems(FXCollections.observableArrayList("d4", "d6", "d8", "d10", "d20", "d100"));
	    
	    // controller.ExportButton.setOnAction(e -> FPADriver.exportMap(controller));
=======


		// March 5th - Emily: creates listener for choosing an entity
		controller2.chooseEntity.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue ov, Number value, Number new_value) {
				controller2.entitySelected();
			}
		});
		
		controller.mapSelect.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue observable, Number oldValue, Number newValue) {
				controller.entitySelected();
				
			}
		});


		// controller.ExportButton.setOnAction(e -> FPADriver.exportMap(controller));
>>>>>>> 7fa8ad9cb0c3a23674fe75bdcb31ba7cad2e0d60

		for (int i = 0; i < controller.mapGrid.getRowConstraints().size(); i++) {
			for (int j = 0; j < controller.mapGrid.getColumnConstraints().size(); j++) {
				Pane p = new Pane();
				GridPane.setConstraints(p, j, i);
				controller.mapGrid.getChildren().add(p);

				mapContents.add(p);

				// -------------------------------------------------------------------------------------------------------------
				// Jett 3/3/18
				// Jett 3/5/18

				p.setStyle("-fx-background-color: lightgreen; -fx-border-color: black; -fx-border-width: 0.5;");


				// -----------------------Levi 3/5
				// (Start)------------------------------------------
				p.setOnMousePressed(e -> {
					// event to initiate the drag or act as a click to make one square workable
					if (controller.entitySelected) {
						Button b = new Button();
						b.setText("0");
						b.setFont(new Font(8));
						b.setMinSize(2, 2);
						b.setMaxSize(150, 150);
						b.setAlignment(Pos.CENTER);
						if (p.getChildren().size() < 1) {
							p.getChildren().add(b);
						}
					} else {
						p.setStyle(controller.color + "; -fx-border-color: black; -fx-border-width: 0.5;");
					}
				});

				p.setOnDragDetected(e -> {
					// dragboard used to start drag and drop method.
					if (!controller.entitySelected) {
					Dragboard db = p.startDragAndDrop(TransferMode.COPY);
					ClipboardContent content = new ClipboardContent();
					content.putString(p.getStyle());
					db.setContent(content);
					}
				});
				p.setOnDragOver(new javafx.event.EventHandler<DragEvent>() {
					// event to figure out when it is crossed over
					@Override
					public void handle(DragEvent event) {
						if (event.getGestureSource() != p && event.getDragboard().hasString()) {
							event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
						}
						event.consume();
					}

				});
				p.setOnDragEntered(new javafx.event.EventHandler<DragEvent>() {
					// safety method to continue the drag and drop feature
					@Override
					public void handle(DragEvent event) {
						Dragboard db = event.getDragboard();
						if (event.getGestureSource() != p && event.getDragboard().hasString()) {
							p.setStyle(db.getString());
						}

					}
				});
				p.setOnDragExited(new javafx.event.EventHandler<DragEvent>() {
					// just anotheer method to ensure this works. May not be needed
					public void handle(DragEvent event) {
						/* mouse moved away, remove the graphical cues */
						// p.setFill(Color.BLACK);

						event.consume();
					}
				});
				p.setOnDragDropped(new javafx.event.EventHandler<DragEvent>() {
					public void handle(DragEvent event) {
						// data dropped and end of the drag and drop feature.

						Dragboard db = event.getDragboard();
						boolean success = false;
						if (db.hasString()) {
							p.setStyle(db.getString());
							success = true;
						}

						event.consume();
					}
				});
				// ----------------------------------Levi (End)------------------------------

				// -------------------------------------------------------------------------------------------------------------
			}

		}
	}

	private void initialLoad(GridPane mapPane) {

		String filePath = "./saveFileObject.ini";
		File file = new File(filePath);
		SaveFile sf = new SaveFile(items, players, monsters, maps);

		if (file.exists()) {
			try {
				sf = loadFile(filePath);
			} catch (ClassNotFoundException e) {
				System.out.println("ClassNotFoundException load");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("General IOException load");
				e.printStackTrace();
			}

		} else {
			Alert alert = new Alert(AlertType.INFORMATION,
					"We cannot save javafx components such as gridpane. we need a way to track where the user changes color(labes in gridpane, lable color changed to represent what is what) and store changes possibly in a 2D array. save array as map.",
					ButtonType.OK);
			alert.setHeaderText("No save file exist!");
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.show();

		}

		players = sf.playerList;
		monsters = sf.monsterList;
		items = sf.itemList;

	}

	public static ArrayList returnEntities() {
		ArrayList entities = new ArrayList();
		for (Player p : players) {
			entities.add(p);
		}
		for (Monster m : monsters) {
			entities.add(m);
		}
		return entities;
	}

	public static void addPlayer(Player p) {
		players.add(p);

		System.out.println("players entered: " + players.size());
	}

	public static void addMonster(Monster m) {
		monsters.add(m);

		System.out.println("Monsters entered: " + players.size());
	}

	public static SaveFile loadFile(String filePath) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(filePath);
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		SaveFile sf = (SaveFile) ois.readObject();
		ois.close();
		bis.close();
		fis.close();
		return sf;
	}

	public static void singleLoadFile() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(saveMapPath);
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		Map mapContentsLoad = (Map) ois.readObject();
		ois.close();
		bis.close();
		fis.close();
		ArrayList<Pane> loadPane = new ArrayList<>();
		for (int i = 0; i < mapContentsLoad.mapContents.length; i++) {
			Pane p = new Pane();
			p.setStyle(mapContentsLoad.mapContents[i]);
			loadPane.add(p);
//			System.out.println(mapContentsLoad.mapContents[i]);
//			System.out.println("pane style: " + p.getStyle());
//			System.out.println("______");

			// System.out.println(mapContentsLoad[i]);
			 maps.add(mapContentsLoad);
		}
//		for (int i = 0; i <= maps.size(); i++) {
//			if (!maps.get(i).name.equals(mapContentsLoad.name)) {
//				maps.add(mapContentsLoad);
//			} else {
//
//			}

//		}
//		-----------------------------------daniel 3/5
//		UIController.
		setMap(loadPane);

	}

	public static void saveFile(SaveFile sf, String filePath) throws IOException {
		FileOutputStream fos = new FileOutputStream(filePath);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(sf);
		oos.close();
		bos.close();
		fos.close();
	}

	public static void singleSaveFile(Map m) throws IOException {
		// File file = new File(saveMapPath);
		// if(file.exists()) {
		// file.delete();
		// }
		FileOutputStream fos = new FileOutputStream(saveMapPath);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(m);
		oos.close();
		bos.close();
		fos.close();
	}

	public static void importMap() {
		getSavePath();
		try {
			singleLoadFile();
		} catch (ClassNotFoundException e) {
			System.out.println("class not found");
		} catch (IOException e) {

		}
	}

	public static void exportMap(ArrayList<Pane> mapContents) {
		getSavePath();
		String[] strArr = new String[mapContents.size()];
		int i = 0;

		for (Pane p : mapContents) {
			strArr[i] = p.getStyle();
			i++;
		}
		TextInputDialog textDialog = new TextInputDialog();
		textDialog.setTitle("Map Name");
		textDialog.setHeaderText(null);
		textDialog.setContentText("Enter the name for the new map ");
		Optional<String> mapName = Optional.empty();
		mapName = textDialog.showAndWait();
		String name = mapName.get();
		Map m = new Map(name, strArr);

		try {
			singleSaveFile(m);
		} catch (IOException e) {
			System.out.println("singlesavefile exception");
			e.printStackTrace();
		}
	}

	public static void getSavePath() {
		TextInputDialog textDialog = new TextInputDialog();
		textDialog.setTitle("Save Path");
		textDialog.setHeaderText(null);
		textDialog.setContentText("Enter the filePath for the save file: ");
		Optional<String> filePath = Optional.empty();
		filePath = textDialog.showAndWait();
		try {
			saveMapPath = filePath.get();
		} catch (NoSuchElementException e) {

		}
	}

	public static void setMap(ArrayList<Pane> pane) {
		for (int i = 0; i < pane.size(); i++) {
			mapContents.get(i).setStyle(pane.get(i).getStyle());
		}
		// mapContents = pane;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
