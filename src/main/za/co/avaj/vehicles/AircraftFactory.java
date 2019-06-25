package za.co.avaj.vehicles;

import za.co.avaj.exceptions.InvalidAircraftException;

public class AircraftFactory {
	public Flyable		newAircraft(String type, String name, int longitude, int latitude, int height) throws InvalidAircraftException {
		Coordinates coords = new Coordinates(longitude, latitude, height);

		if (type.equals("JetPlane")) {
			return new JetPlane(name, coords);
		} else if (type.equals("Helicopter")) {
			return new Helicopter(name, coords);
		} else if (type.equals("Baloon")) {
			return new Baloon(name, coords);
		} else {
			throw new InvalidAircraftException((char) 27 + "[31m" + "ERROR: " + (char) 27 + "[37m" + "failed to construct new Aircraft: " + type);
		}
	}
}