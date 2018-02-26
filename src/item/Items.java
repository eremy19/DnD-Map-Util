package item;

import java.util.ArrayList;

public class Items {
	
	
	
	private String name;
	private int value;
	private double weight;
	
	public Items(String name, int value, double d) {
		setName(name);
		setValue(value);
		setWeight(d);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double d) {
		this.weight = d;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("name: "+name);
		builder.append("\n");
		builder.append("Value: "+value+"gp");
		builder.append("\n");
		builder.append("Weight: "+weight+"lb");
		builder.append("\n");
		return builder.toString();
	}
	
	
}
