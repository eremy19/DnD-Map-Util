package util;

import java.io.Serializable;

public class Map implements Serializable {

	private static final long serialVersionUID = 1L;
	public final String name;
	public final String[] mapContents;
	public final int rows = 0;
	public final int cols = 0;

	public Map(String name, String[] map) {
		this.name = name;
		this.mapContents = map;
	}
}
