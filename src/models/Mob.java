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

	/*
	 * statMod = (int)(stat-10)/2
	 */

	public Mob(String name, int maxHP, int strength, int dexterity, int constitution, int inteligence, int wisdom,
			int charisma, int armor, int spellAttackBonus, int spellCastingAbility, int speed) {
		setName(name);
		setMaxHP(maxHP);
		setCurrentHP(maxHP);
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
		// setNotes(notes);
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
		int statMod = (int) (stat - 10) / 2;
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

	public void notes(String notes) {
		System.out.println(notes);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append("\n");
		builder.append("MaxHP: " + maxHP);
		builder.append("\n");
		builder.append("CurrentHP: " + currentHP);
		builder.append("\n");
		builder.append("TempHP: " + tempHP);
		builder.append("\n");
		builder.append("Str: " + strength + "+(" + strMod + ")");
		builder.append("\n");
		builder.append("Dex: " + dexterity + "+(" + dexMod + ")");
		builder.append("\n");
		builder.append("Con: " + constitution + "+(" + conMod + ")");
		builder.append("\n");
		builder.append("Int: " + inteligence + "+(" + intMod + ")");
		builder.append("\n");
		builder.append("Wis: " + wisdom + "+(" + wisMod + ")");
		builder.append("\n");
		builder.append("Cha: " + charisma + "+(" + chaMod + ")");
		builder.append("\n");
		builder.append("AC: " + armor);
		builder.append("\n");
		builder.append("SAB: " + spellAttackBonus);
		builder.append("\n");
		builder.append("SCA: " + spellCastingAbility);
		builder.append("\n");
		builder.append("Speed: " + speed);
		builder.append("\n");
		return builder.toString();
	}

}
