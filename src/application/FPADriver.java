package application;
	
import java.util.ArrayList;

import item.Items;
import javafx.application.Application;
import javafx.stage.Stage;
import models.Chest;
import models.Mob;
import models.Monster;
import models.Player;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class FPADriver extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception{
			GridPane grid = new GridPane();
			grid.setGridLinesVisible(true);
			
			Button b1 = new Button("A");
			Button b2 = new Button("B");
			
			Button b3 = new Button("C");
			Button b4 = new Button("D");
			
			Button b5 = new Button("E");
			Button b6 = new Button("F");
			Button b7 = new Button("G");
			Button b8 = new Button("H");
			Button b9 = new Button("I");
			GridPane.setConstraints(b1, 0,0);
			GridPane.setConstraints(b2, 1,0);
			GridPane.setConstraints(b3, 2,0);
			GridPane.setConstraints(b4, 0,1);
			GridPane.setConstraints(b5, 1,1);
			GridPane.setConstraints(b6, 2,1);
			GridPane.setConstraints(b7, 0,2);
			GridPane.setConstraints(b8, 1,2);
			GridPane.setConstraints(b9, 2,2);


			grid.getChildren().add(b1);
			grid.getChildren().add(b2);
			grid.getChildren().add(b3);
			grid.getChildren().add(b4);
			grid.getChildren().add(b5);
			grid.getChildren().add(b6);
			grid.getChildren().add(b7);
			grid.getChildren().add(b8);
			grid.getChildren().add(b9);


			
			VBox menu = new VBox();
			Label menu1 = new Label("option 1");
			Button menu2 = new Button("option 2");
			Button menu3 = new Button("option 3");

			BorderPane borderPane = new BorderPane();	
			borderPane.setRight(menu);
			borderPane.setCenter(grid);

			
			//GridPane finish = new GridPane();
			//finish.getChildren().addAll(menu,grid);
			//Scene scene = new Scene(finish,400,400);
		
			Scene scene = new Scene(borderPane);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Test Demo");
			primaryStage.setAlwaysOnTop(true);
			primaryStage.setResizable(true);
			primaryStage.show();	
	}
	
	public static void main(String[] args) {
//		launch(args);
		Mob m = new Mob("Mob", 7, 0, 1, 2, 3, 5, 7, 15, 15, 15, 30);
		Player p = new Player("Player", 7, 0, 1, 2, 3, 5, 7, 15, 15, 15, 30);
		Monster mob = new Monster("Monster", 7, 0, 1, 2, 3, 5, 7, 15, 15, 15, 30);
//		Mob m2 = new Mob(name, maxHP, strength, dexterity, constitution, inteligence, wisdom, charisma, armor, spellAttackBonus, spellCastingAbility, speed)
		System.out.println(m);
		System.out.println();
		System.out.println(p);
		System.out.println();
		System.out.println(mob);
//		Chest.getItem();
//		Chest.randomItem();
		
	}
}
