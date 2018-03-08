package models;

import java.io.Serializable;

public class Player extends Mob implements Serializable {

	private static final long serialVersionUID = 1L;

	public Player(String name, int maxHP, int strength, int dexterity, int constitution, int inteligence, int wisdom,
			int charisma, int armor, int spellAttackBonus, int spellCastingAbility, int speed, int initiative,
			String hitDie) {
		super(name, maxHP, strength, dexterity, constitution, inteligence, wisdom, charisma, armor, spellAttackBonus,
				spellCastingAbility, speed, initiative, hitDie);

	}
	

}
