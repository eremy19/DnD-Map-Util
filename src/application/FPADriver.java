package application;

import javafx.application.Application;
import javafx.stage.Stage;
import models.Chest;
import models.Mob;
import models.Monster;
import models.Player;
import util.SaveFile;

public class FPADriver extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
	}

	public static void main(String[] args) {
		launch(args);
		// Mob m = new Mob("Mob", 7, 0, 1, 2, 3, 5, 7, 15, 15, 15, 30);
		// Player p = new Player("Player", 7, 0, 1, 2, 3, 5, 7, 15, 15, 15, 30);
		// Monster mob = new Monster("Monster", 7, 0, 1, 2, 3, 5, 7, 15, 15, 15, 30);
		// Mob m2 = new Mob(name, maxHP, strength, dexterity, constitution, inteligence,
		// wisdom, charisma, armor, spellAttackBonus, spellCastingAbility, speed)
		// System.out.println(m);
		// System.out.println();
		// System.out.println(p);
		// System.out.println();
		// System.out.println(mob);
		// Chest.getItem();
		// Chest.randomItem();
		// SaveFile.players.add(p);

	}
}
