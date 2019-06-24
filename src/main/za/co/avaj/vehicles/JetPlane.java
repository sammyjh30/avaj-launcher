package za.co.avaj.vehicles;

import za.co.avaj.exceptions.FailedUnregisterException;
import za.co.avaj.exceptions.InvalidWeatherException;
import za.co.avaj.weather.Coordinates;
import za.co.avaj.weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	public JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates); //Calls Parent class' constructor definition
	}

	public void	updateConditions(){
		int		height = this.coordinates.getHeight();
		int		latitude = this.coordinates.getLatitude();
		int		longitude = this.coordinates.getLongitude();

		try {
			String weather = weatherTower.getWeather(this.coordinates);
			if (weather.equalsIgnoreCase("RAIN")) {
				this.log.logToFile("default", this.getFlyableType() + "#" + this.getFlyableName() + "(" + this.getFlyableId() + "): " +
						"Rain! I better turn on my wipers!");
				latitude += 5;
			} else if (weather.equalsIgnoreCase("FOG")) {
				this.log.logToFile("default", this.getFlyableType() + "#" + this.getFlyableName() + "(" + this.getFlyableId() + ") " +
						"It's hard to see.. better move a bit slower!");
				latitude += 1;
			} else if (weather.equalsIgnoreCase("SUN")) {
				this.log.logToFile("default", this.getFlyableType() + "#" + this.getFlyableName() + "(" + this.getFlyableId() + "): " +
						"Clear skies, let's go!");
				latitude += 10;
				height += 4;
				if (height > 100) { height = 100; }
			} else if (weather.equalsIgnoreCase("SNOW")) {
				this.log.logToFile("default", this.getFlyableType() + "#" + this.getFlyableName() + "(" + this.getFlyableId() + "): " +
						"The cold is gonna freeze my engines!");
				height -= 7;
				if (height <= 0) {
					try {
						this.log.logToFile("default", this.getFlyableType() + "#" + this.getFlyableName() + "(" + this.getFlyableId() + "): " +
								"landing.");
						weatherTower.unregister(this);
						return;
					} catch (FailedUnregisterException e) {
						e.printStackTrace();
					}
				}
			} else {
				throw new InvalidWeatherException("ERROR: Invalid weather: " + weather);
			}
		} catch (InvalidWeatherException e) {
			e.printStackTrace();
		}

		this.coordinates.setHeight(height);
		this.coordinates.setLongitude(longitude);
		this.coordinates.setLatitude(latitude);
	}

	public void	registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
	}


	public String getFlyableName() {
		return (this.name);
	}

	public long		getFlyableId() {
		return (this.id);
	}

	public String		getFlyableType() {
		return ("JetPlane");
	}
}