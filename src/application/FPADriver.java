package application;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Optional;

import controllers.EntityController;
import controllers.UIController;
import item.Items;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import models.Monster;
import models.Player;
import util.Map;
import util.SaveFile;

public class FPADriver extends Application {

	String pathMap = "MapView.fxml";
	String pathEntity = "EntityView.fxml";
	Scene sceneMap, sceneEntity;

	ArrayList<Map> maps = new ArrayList<>();
	ArrayList<Player> players = new ArrayList<>();
	ArrayList<Monster> monsters = new ArrayList<>();
	ArrayList<Items> items = new ArrayList<>();

	@Override
	public void start(Stage Stage) throws IOException {
		

		// FXMLLoader loader = new FXMLLoader((getClass().getResource(mapPath)));
		// FXMLLoader loader = new FXMLLoader((getClass().getResource(entityPath)));
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
		
		
		controller.entitySceneSwap.setOnAction(e -> Stage.setScene(sceneEntity));
		controller2.entities.setOnAction(e -> Stage.setScene(sceneMap));
		// controller.ImportMap.add
//		controller.ImportMap.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			
//			@Override
//			public void handle(ActionEvent event) {
////				System.out.println("hit");
//				filePath();
//			}
//		});
		initialLoad(map);
	}

	private void initialLoad(GridPane mapPane) {
		String filePath = "./saveFileObject.sfo";
		Player p = new Player("Daniel", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "d6");
		players.add(p);
		Map map = new Map("testmap", mapPane);
		maps.add(map);
		Monster m = new Monster("Monster", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "d6");
		monsters.add(m);
		Items i = new Items("Item", "Notes here");
		items.add(i);
//		sf.getPlayerList().add(p);
//		sf.playerList.add(p);
//		maps = sf.mapList;
//		players = sf.playerList;
//		monsters = sf.monsterList;
//		items = sf.itemList;
		SaveFile sf = new SaveFile(items, players, monsters, maps);
		
		
		try {
			sf = loadFile(filePath);
		}catch (FileNotFoundException e) {
			System.out.println("There is no startup file. Creating one now.");
			try {
				saveFile(sf, filePath);
			}catch (NotSerializableException e2) {
				System.out.println("NotSerializableEx");
				e2.printStackTrace();
			} catch (IOException e1) {
				System.out.println("caught save exception");
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("There was an error loading the startup file. ClassNotFound.");
		}catch (EOFException e) {
			System.out.println("There was an error loading the startup file EOFException.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("General IOException");
			e.printStackTrace();
		}


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

	public static void saveFile(SaveFile sf, String filePath) throws IOException {
		FileOutputStream fos = new FileOutputStream(filePath);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(sf);
		oos.close();
		bos.close();
		fos.close();
	}

	
	public static void filePath(){
		Optional<String> filePath;
		
		TextInputDialog textDialog = new TextInputDialog();
        textDialog.setTitle("Create new item");
        textDialog.setHeaderText(null);

        textDialog.setContentText("Enter the filePath for the map: ");
        filePath = textDialog.showAndWait();
//        loadFile(filePath);
        System.out.println(filePath);
        String path = filePath.get();
        try {
			loadFile(path);
		} catch (ClassNotFoundException e) {
			System.out.println("Threw ClassNotFound");
//			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Threw general IOException");
//			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
