package models;

import java.io.Serializable;

public class Monster extends Mob implements Serializable {

	public Monster(String name, int maxHP, int currentHP, int tempHP, int attribute1, int attribute2, int attribute3,
			int attribute4, int attribute5, int attribute6, int experience, int speed, String skills, String abilities,
			String assignedDie) {
		super(name, maxHP, currentHP, tempHP, attribute1, attribute2, attribute3, attribute4, attribute5, attribute6,
				experience, speed, skills, abilities, assignedDie);
	}

	private static final long serialVersionUID = 2L;

	
}
