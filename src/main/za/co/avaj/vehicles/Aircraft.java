package za.co.avaj.vehicles;

import za.co.avaj.weather.Coordinates;

public class Aircraft {
	protected long				id;
	protected String			name;
	protected Coordinates 		coordinates;
	private static long			idCounter;

	protected 		Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
		this.id = nextId();
	}

	public String 	getName() {
		return this.name;
	}

	public long		getId() {
		return this.id;
	}

	private long	nextId() {
		return idCounter++;
	}
}