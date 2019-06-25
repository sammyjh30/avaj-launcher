package za.co.avaj.weather;

import za.co.avaj.vehicles.Coordinates;

public class WeatherTower extends Tower {
	public String		getWeather(Coordinates coordinates) {
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}

	void		changeWeather() { this.conditionsChanged();}

}