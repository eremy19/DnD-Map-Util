package item;

import java.io.Serializable;

public class Items implements Serializable{
	
	private String name;
	private String notes;
	
	public Items(String name, String notes) {
		setName(name);
		setNotes(notes);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Name: "+name);
		builder.append("\n");
		builder.append("Notes: "+notes);
		return builder.toString();
	}


	
}
