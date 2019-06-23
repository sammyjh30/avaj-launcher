package za.co.avaj.vehicles;

import za.co.avaj.weather.Coordinates;
import za.co.avaj.exceptions.InvalidAircraftException;

public class AircraftFactory {
	public Flyable		newAircraft(String type, int longitude, int latitude, int height) throws InvalidAircraftException {
		Coordinates coords = new Coordinates(longitude, latitude, height);

		if (type == "JetPlane") {
			return new JetPlane("name", coords);
		} else if (type == "Helicopter") {
			return new Helicopter("name", coords);
		} else if (type == "Baloon") {
			return new Baloon("name", coords);
		} else {
			throw new InvalidAircraftException("ERROR: failed to construct new Aircraft: " + type);
		}
	}
}