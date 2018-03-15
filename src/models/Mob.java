package models;

import java.io.Serializable;

public class Mob implements Serializable {

	private String name;
	private int maxHP;
	private int currentHP;
	private int tempHP;
	private int attribute1;
	private int attribute2;
	private int attribute3;
	private int attribute4;
	private int attribute5;
	private int attribute6;
	private int experience;
	private int speed;
	private String skills;
	private String abilities;
	private String assignedDie;
	private String notes;
	private String attribute1name;
	private String attribute2name;
	private String attribute3name;
	private String attribute4name;
	private String attribute5name;
	private String attribute6name;


	
	public Mob(String name, int maxHP, int currentHP, int tempHP, int attribute1, int attribute2, int attribute3,
			int attribute4, int attribute5, int attribute6, int experience, int speed, String skills, String abilities,
			String assignedDie) {
		setName(name);
		setMaxHP(maxHP);
		setCurrentHP(currentHP);
		setTempHP(tempHP);
		setAttribute1(attribute1);
		setAttribute2(attribute2);
		setAttribute3(attribute3);
		setAttribute4(attribute4);
		setAttribute5(attribute5);
		setAttribute6(attribute6);
		setExperience(experience);
		setSpeed (speed);
		setSkills (skills);
		setAbilities (abilities);
		setAssignedDie (assignedDie);
		//defaults to basic stat names
		setAttribute1name("Strength");
		setAttribute2name("Dexterity");
		setAttribute3name("Constitution");
		setAttribute4name("Intelligence");
		setAttribute5name("Wisdom");
		setAttribute6name("Charisma");
	}

	public void updateStats(String name, int maxHP, int currentHP, int tempHP, int attribute1, int attribute2, int attribute3,
			int attribute4, int attribute5, int attribute6, int experience, int speed, String skills, String abilities,
			String assignedDie, String notes) {
		setName(name);
		setMaxHP(maxHP);
		setCurrentHP(currentHP);
		setTempHP(tempHP);
		setAttribute1(attribute1);
		setAttribute2(attribute2);
		setAttribute3(attribute3);
		setAttribute4(attribute4);
		setAttribute5(attribute5);
		setAttribute6(attribute6);
		setExperience(experience);
		setSpeed (speed);
		setSkills (skills);
		setAbilities (abilities);
		setAssignedDie (assignedDie);
		setNotes (notes);
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
		builder.append(attribute1name + ": " + attribute1);
		builder.append("\n");
		builder.append(attribute2name + ": " + attribute2);
		builder.append("\n");
		builder.append(attribute3name + ": " + attribute3);
		builder.append("\n");
		builder.append(attribute4name + ": " + attribute4);
		builder.append("\n");
		builder.append(attribute5name + ": " + attribute5);
		builder.append("\n");
		builder.append(attribute6name + ": " + attribute6);
		builder.append("\n");
		builder.append("XP: " + experience);
		builder.append("\n");
		builder.append("Speed: " + speed);
		builder.append("\n");
		builder.append("Skills: " + skills);
		builder.append("\n");
		builder.append("Abilities: " + abilities);
		builder.append("\n");
		builder.append("Die: " + assignedDie);
		builder.append("\n");
		builder.append("Notes: " + notes);
		builder.append("\n");
		return builder.toString();
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
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




	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}




	public int getTempHP() {
		return tempHP;
	}




	public void setTempHP(int tempHP) {
		this.tempHP = tempHP;
	}




	public int getAttribute1() {
		return attribute1;
	}




	public void setAttribute1(int attribute1) {
		this.attribute1 = attribute1;
	}




	public int getAttribute2() {
		return attribute2;
	}




	public void setAttribute2(int attribute2) {
		this.attribute2 = attribute2;
	}




	public int getAttribute3() {
		return attribute3;
	}




	public void setAttribute3(int attribute3) {
		this.attribute3 = attribute3;
	}




	public int getAttribute4() {
		return attribute4;
	}




	public void setAttribute4(int attribute4) {
		this.attribute4 = attribute4;
	}




	public int getAttribute5() {
		return attribute5;
	}




	public void setAttribute5(int attribute5) {
		this.attribute5 = attribute5;
	}




	public int getAttribute6() {
		return attribute6;
	}




	public void setAttribute6(int attribute6) {
		this.attribute6 = attribute6;
	}




	public int getExperience() {
		return experience;
	}




	public void setExperience(int experience) {
		this.experience = experience;
	}




	public int getSpeed() {
		return speed;
	}




	public void setSpeed(int speed) {
		this.speed = speed;
	}




	public String getSkills() {
		return skills;
	}




	public void setSkills(String skills) {
		this.skills = skills;
	}




	public String getAbilities() {
		return abilities;
	}




	public void setAbilities(String abilities) {
		this.abilities = abilities;
	}




	public String getAssignedDie() {
		return assignedDie;
	}




	public void setAssignedDie(String assignedDie) {
		this.assignedDie = assignedDie;
	}




	public String getNotes() {
		return notes;
	}




	public void setNotes(String notes) {
		this.notes = notes;
	}




	public String getAttribute1name() {
		return attribute1name;
	}




	public void setAttribute1name(String attribute1name) {
		this.attribute1name = attribute1name;
	}




	public String getAttribute2name() {
		return attribute2name;
	}




	public void setAttribute2name(String attribute2name) {
		this.attribute2name = attribute2name;
	}




	public String getAttribute3name() {
		return attribute3name;
	}




	public void setAttribute3name(String attribute3name) {
		this.attribute3name = attribute3name;
	}




	public String getAttribute4name() {
		return attribute4name;
	}




	public void setAttribute4name(String attribute4name) {
		this.attribute4name = attribute4name;
	}




	public String getAttribute5name() {
		return attribute5name;
	}




	public void setAttribute5name(String attribute5name) {
		this.attribute5name = attribute5name;
	}




	public String getAttribute6name() {
		return attribute6name;
	}




	public void setAttribute6name(String attribute6name) {
		this.attribute6name = attribute6name;
	}

}
