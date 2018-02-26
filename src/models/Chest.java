package models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import interfaces.ConsoleUI;
import item.Items;

public class Chest {
	
	public static ArrayList<Items> chestList = new ArrayList<>();
	
	public static void getItem() {
		Items i1 = new Items("Potion","This is a potion");
		Items i2 = new Items("Weapon", "This is a weapon");
		Items i3 = new Items("Armor", "This is armor");
		chestList.add(i1);
		chestList.add(i2);
		chestList.add(i3);
		for(int i = 0;i<chestList.size();i++) {
			System.out.println(chestList.get(i));
			System.out.println();
		}
	}
	
	public static void addItem() throws IOException {
		String name = ConsoleUI.promptForInput("What is the name", false);
		String notes = ConsoleUI.promptForInput("What is this?", false);;
		Items i = new Items(name, notes);
	}
	
	public static void randomItem() {
		Items i1 = new Items("Potion","This is a potion");
		Items i2 = new Items("Weapon", "This is a weapon");
		Items i3 = new Items("Armor", "This is armor");
		chestList.add(i1);
		chestList.add(i2);
		chestList.add(i3);
		Random rand = new Random();
		for(int i =0;i<chestList.size();i++) {
			int index = rand.nextInt(chestList.size());
		System.out.println(chestList.get(index));
			
		}
//		System.out.println();
	}

}
