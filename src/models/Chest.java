package models;

import java.util.ArrayList;
import java.util.Random;

import item.Items;

public class Chest {
	
	static ArrayList<Items> chestList = new ArrayList<>();
	
	public static void getItem() {
		Items i1 = new Items("Potion", 50, 10);
		Items i2 = new Items("Weapon", 100, 20.5);
		Items i3 = new Items("Armor", 200, 30.25);
		chestList.add(i1);
		chestList.add(i2);
		chestList.add(i3);
		for(int i = 0;i<chestList.size();i++) {
			System.out.println(chestList.get(i));
		}
	}
	
	public static void randomItem() {
		Items i1 = new Items("Potion", 50, 10);
		Items i2 = new Items("Weapon", 100, 20.5);
		Items i3 = new Items("Armor", 200, 30.25);
		chestList.add(i1);
		chestList.add(i2);
		chestList.add(i3);
		Random rand = new Random();
		int index = rand.nextInt(chestList.size());
		System.out.println(chestList.get(index));
	}

}
