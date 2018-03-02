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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import models.Monster;
import models.Player;
import util.Map;
import util.SaveFile;

public class FPADriver extends Application {

    String pathMap = "MapView.fxml";
    String pathEntity = "EntityView.fxml";
    Scene sceneMap, sceneEntity;

    static ArrayList<Map> maps = new ArrayList<>();
    static ArrayList<Player> players = new ArrayList<>();
    static ArrayList<Monster> monsters = new ArrayList<>();
    static ArrayList<Items> items = new ArrayList<>();

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
   	 
   	 

   	 // ----------------------------------------------------------------------------------------------------------

   	 controller.entitySceneSwap.setOnAction(e -> Stage.setScene(sceneEntity));
   	 controller2.entities.setOnAction(e -> Stage.setScene(sceneMap));

   	 // controller.ExportButton.setOnAction(e -> FPADriver.exportMap(controller));

   	 for (int i = 0; i < controller.mapGrid.getColumnConstraints().size(); i++) {
   		 for (int j = 0; j < controller.mapGrid.getRowConstraints().size(); j++) {
   			 Pane p = new Pane();
   			 GridPane.setConstraints(p, i, j);
   			 controller.mapGrid.getChildren().add(p);
   			 p.setOnMouseClicked(e -> {
   				 p.setStyle(controller.color + "; -fx-border-color: black; -fx-border-width: 0.5;");
   			 });
   			 p.setOnDragDetected(e -> {
   				 p.setStyle(controller.color + "; -fx-border-color: black; -fx-border-width: 0.5;");
   			 });
   		 }
   	 }
//   	 initialLoad();
    }
    
    
    	

    private void initialLoad(GridPane mapPane) {

   	 String filePath = "./saveFileObject.ini";
   	 File file = new File(filePath);
   	 // Player p = new Player("Daniel", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "d6");
   	 // players.add(p);
   	 // Map map = new Map("testmap", mapPane);
   	 // maps.add(map);
   	 // Monster m = new Monster("Monster", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "d6");
   	 // monsters.add(m);
   	 // Items i = new Items("Item", "Notes here");
   	 // items.add(i);
   	 SaveFile sf = new SaveFile(items, players, monsters, maps);
   	 // sf.getPlayerList().add(p);
   	 // sf.mapList.add(map);
   	 // sf.playerList.add(p);
   	 // sf.monsterList.add(m);
   	 // sf.itemList.add(i);
   	 // maps = sf.mapList;
   	 // players = sf.playerList;
   	 // monsters = sf.monsterList;
   	 // items = sf.itemList;
   	 // try {
   	 // saveFile(sf, filePath);
   	 // } catch (IOException e1) {
   	 // System.out.println("General IOException save");
   	 // e1.printStackTrace();
   	 // }

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

    public static void saveFile(SaveFile sf, String filePath) throws IOException {
   	 FileOutputStream fos = new FileOutputStream(filePath);
   	 BufferedOutputStream bos = new BufferedOutputStream(fos);
   	 ObjectOutputStream oos = new ObjectOutputStream(bos);
   	 oos.writeObject(sf);
   	 oos.close();
   	 bos.close();
   	 fos.close();
    }

    public static void importMap() {
   	 boolean validFilePath = false;
   	 TextInputDialog textDialog = new TextInputDialog();
   	 textDialog.setTitle("Import Map");
   	 textDialog.setHeaderText(null);
   	 textDialog.setContentText("Enter the filePath for the map: ");
   	 Optional<String> filePath = Optional.empty();
   	 String path;
   	 do {

   		 try {
   			 filePath = textDialog.showAndWait();
   		 } catch (NoSuchElementException e) {

   		 }
   		 try {
   			 File file = new File(filePath.get());
   			 if (file.exists()) {
   				 path = filePath.get();
   				 validFilePath = true;
   				 try {
   					 loadFile(path);
   				 } catch (ClassNotFoundException e) {
   					 // TODO Auto-generated catch block
   					 e.printStackTrace();
   				 } catch (IOException e) {
   					 // TODO Auto-generated catch block
   					 e.printStackTrace();
   				 }
   			 } else {
   				 Alert alert = new Alert(AlertType.ERROR, "Please enter a valid file path!", ButtonType.OK);
   				 alert.setHeaderText(null);
   				 alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
   				 alert.showAndWait();
   			 }
   		 } catch (NoSuchElementException e) {
   			 validFilePath = true;
   		 }
   	 } while (!validFilePath);

    }

    public static void exportMap(UIController controller) {
   	 // Alert alert = new Alert(AlertType.NONE);
   	 // ButtonType btn = new ButtonType("Maybe...");
   	 // alert.getDialogPane().getButtonTypes().add(btn);
   	 // alert.setHeaderText(
   	 // "You clicked the export button. Sorry but, this method is currently empty...
   	 // You could fix that :)");
   	 // alert.showAndWait();

   	 String[][] mapValues = new String[controller.mapGrid.getColumnConstraints().size()][controller.mapGrid
   			 .getRowConstraints().size()];

   	 for (int i = 0; i < controller.mapGrid.getColumnConstraints().size(); i++) {
   		 for (int j = 0; j < controller.mapGrid.getRowConstraints().size(); j++) {

   			 mapValues[i][j] = controller.mapGrid.getChildren()
   					 .get((i * controller.mapGrid.getColumnConstraints().size()) + j).getStyle();
   			 System.out.println(mapValues[i][j]);
   		 }
   	 }

    }

    public static void main(String[] args) {
   	 launch(args);
    }
}

