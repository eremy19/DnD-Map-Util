package models;

import java.util.ArrayList;
import java.util.Random;

import item.Items;

public class Chest {
	
	static ArrayList<Items> chestList = new ArrayList<>();
	
	public static void getItem() {
		Items i1 = new Items("Potion","This is a potion");
		Items i2 = new Items("Weapon", "This is a weapon");
		Items i3 = new Items("Armor", "This is armor");
		chestList.add(i1);
		chestList.add(i2);
		chestList.add(i3);
		for(int i = 0;i<chestList.size();i++) {
			System.out.println(chestList.get(i));
		}
	}
	
	public static void randomItem() {
		Items i1 = new Items("Potion","This is a potion");
		Items i2 = new Items("Weapon", "This is a weapon");
		Items i3 = new Items("Armor", "This is armor");
		chestList.add(i1);
		chestList.add(i2);
		chestList.add(i3);
		Random rand = new Random();
		int index = rand.nextInt(chestList.size());
		System.out.println(chestList.get(index));
	}

}
