package models;

public class Mob {

	private String name;
	private int maxHP;
	private int currentHP;
	private int tempHP;
	private int strength;
	private int strMod;
	private int dexterity;
	private int dexMod;
	private int constitution;
	private int conMod;
	private int inteligence;
	private int intMod;
	private int wisdom;
	private int wisMod;
	private int charisma;
	private int chaMod;
	private int armor;
	private int spellAttackBonus;
	private int spellCastingAbility;
	private int speed;
	private String notes;

/*statMod = (int)(stat-10)/2
 * */
	
	public Mob(String name, int maxHP, int strength, int dexterity, int constitution, int inteligence, int wisdom,
			int charisma, int armor, int spellAttackBonus, int spellCastingAbility, int speed, String notes) {
		setName(name);
		setStength(strength);
		setDexterity(dexterity);
		setConstitution(constitution);
		setInteligence(inteligence);
		setWisdom(wisdom);
		setCharisma(charisma);
		setArmor(armor);
		setSpellAttackBonus(spellAttackBonus);
		setSpellCastingAbility(spellCastingAbility);
		setSpeed(speed);
		setNotes(notes);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStrength() {
		return strength;
	}

	public void setStength(int strength) {
		this.strength = strength;
		strMod = setMod(strength);
	}

	public int getStrMod() {
		return strMod;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
		dexMod = setMod(dexterity);
	}

	public int getDexMod() {
		return dexMod;
	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
		conMod = setMod(constitution);
	}

	public int getConMod() {
		return conMod;
	}

	public int getInteligence() {
		return inteligence;
	}

	public void setInteligence(int inteligence) {
		this.inteligence = inteligence;
		intMod = setMod(inteligence);
	}

	public int getIntMod() {
		return intMod;
	}

	public int getWisdom() {
		return wisdom;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
		wisMod = setMod(wisdom);
	}

	public int getWisMod() {
		return wisMod;
	}

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
		chaMod = setMod(charisma);
	}

	public int getChaMod() {
		return chaMod;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getSpellAttackBonus() {
		return spellAttackBonus;
	}

	public void setSpellAttackBonus(int spellAttackBonus) {
		this.spellAttackBonus = spellAttackBonus;
	}

	public int getSpellCastingAbility() {
		return spellCastingAbility;
	}

	public void setSpellCastingAbility(int spellCastingAbility) {
		this.spellCastingAbility = spellCastingAbility;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public int setMod(int stat) {
		int statMod = (int)(stat-10)/2;
		return statMod;
	}


	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int maxHP) {
		this.currentHP = maxHP;
	}

	public int getTempHP() {
		return tempHP;
	}

	public void setTempHP(int tempHP) {
		this.tempHP = tempHP;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mob [name=");
		builder.append(name);
		builder.append(", maxHP=");
		builder.append(maxHP);
		builder.append(", currentHP=");
		builder.append(currentHP);
		builder.append(", tempHP=");
		builder.append(tempHP);
		builder.append(", strength=");
		builder.append(strength);
		builder.append(", strMod=");
		builder.append(strMod);
		builder.append(", dexterity=");
		builder.append(dexterity);
		builder.append(", dexMod=");
		builder.append(dexMod);
		builder.append(", constitution=");
		builder.append(constitution);
		builder.append(", conMod=");
		builder.append(conMod);
		builder.append(", inteligence=");
		builder.append(inteligence);
		builder.append(", intMod=");
		builder.append(intMod);
		builder.append(", wisdom=");
		builder.append(wisdom);
		builder.append(", wisMod=");
		builder.append(wisMod);
		builder.append(", charisma=");
		builder.append(charisma);
		builder.append(", chaMod=");
		builder.append(chaMod);
		builder.append(", armor=");
		builder.append(armor);
		builder.append(", spellAttackBonus=");
		builder.append(spellAttackBonus);
		builder.append(", spellCastingAbility=");
		builder.append(spellCastingAbility);
		builder.append(", speed=");
		builder.append(speed);
		builder.append(", notes=");
		builder.append(notes);
		builder.append("]");
		return builder.toString();
	}

//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("Mob [getName()=");
//		builder.append(getName());
//		builder.append(", getStrength()=");
//		builder.append(getStrength());
//		builder.append(", getStrMod()=");
//		builder.append(getStrMod());
//		builder.append(", getDexterity()=");
//		builder.append(getDexterity());
//		builder.append(", getDexMod()=");
//		builder.append(getDexMod());
//		builder.append(", getConstitution()=");
//		builder.append(getConstitution());
//		builder.append(", getConMod()=");
//		builder.append(getConMod());
//		builder.append(", getInteligence()=");
//		builder.append(getInteligence());
//		builder.append(", getIntMod()=");
//		builder.append(getIntMod());
//		builder.append(", getWisdom()=");
//		builder.append(getWisdom());
//		builder.append(", getWisMod()=");
//		builder.append(getWisMod());
//		builder.append(", getCharisma()=");
//		builder.append(getCharisma());
//		builder.append(", getChaMod()=");
//		builder.append(getChaMod());
//		builder.append(", getArmor()=");
//		builder.append(getArmor());
//		builder.append(", getSpellAttackBonus()=");
//		builder.append(getSpellAttackBonus());
//		builder.append(", getSpellCastingAbility()=");
//		builder.append(getSpellCastingAbility());
//		builder.append(", getSpeed()=");
//		builder.append(getSpeed());
//		builder.append(", getNotes()=");
//		builder.append(getNotes());
//		builder.append(", getMaxHP()=");
//		builder.append(getMaxHP());
//		builder.append(", getCurrentHP()=");
//		builder.append(getCurrentHP());
//		builder.append(", getTempHP()=");
//		builder.append(getTempHP());
//		builder.append("]");
//		return builder.toString();
//	}

	
	
}
