package dice;

import java.util.HashMap;
import java.util.Random;

public class Dice {
	HashMap<String, Integer> diceHM = new HashMap<>();
	
	public void fillMap() {
		diceHM.put("d4", 4);
		diceHM.put("d6", 6);
		diceHM.put("d8", 8);
		diceHM.put("d10", 10);
		diceHM.put("d12", 12);
		diceHM.put("d20", 20);
		diceHM.put("d100", 100);
	}
	
	public int rollDice(String diceName) {
		Random random = new Random();
		int roll = random.nextInt(diceHM.get(diceName))+1;
		return roll;
	}
	
}
