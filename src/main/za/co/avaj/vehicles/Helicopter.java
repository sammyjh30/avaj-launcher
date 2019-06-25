package za.co.avaj.vehicles;

import za.co.avaj.exceptions.FailedUnregisterException;
import za.co.avaj.exceptions.InvalidWeatherException;
import za.co.avaj.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable{
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates); //Calls Parent class' constructor definition
	}

	public void	updateConditions(){
		int		height = this.coordinates.getHeight();
		int		latitude = this.coordinates.getLatitude();
		int		longitude = this.coordinates.getLongitude();

		try {
			String weather = weatherTower.getWeather(this.coordinates);
			if (weather.equalsIgnoreCase("RAIN")) {
				this.log.logToFile(this.getFlyableType() + "#" + this.getFlyableName() + "(" + this.getFlyableId() + "): " +
								"Oh no, this rain is going to mess up my blades! I just straightened them!");
				longitude += 5;
			} else if (weather.equalsIgnoreCase("FOG")) {
				this.log.logToFile(this.getFlyableType() + "#" + this.getFlyableName() + "(" + this.getFlyableId() + "): " +
						"I can't see anything!");
				longitude += 1;
			} else if (weather.equalsIgnoreCase("SUN")) {
				this.log.logToFile(this.getFlyableType() + "#" + this.getFlyableName() + "(" + this.getFlyableId() + "): " +
						"What a lovely day!");
				longitude += 10;
				height += 2;
				if (height > 100) { height = 100; }
			} else if (weather.equalsIgnoreCase("SNOW")) {
				this.log.logToFile(this.getFlyableType() + "#" + this.getFlyableName() + "(" + this.getFlyableId() + "): " +
						"Brrr! It's getting kind of chilly, huh?");
				height -= 12;
				if (height <= 0) {
					try {
						this.log.logToFile(this.getFlyableType() + "#" + this.getFlyableName() + "(" + this.getFlyableId() + "): " +
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
		return ("Helicopter");
	}

}