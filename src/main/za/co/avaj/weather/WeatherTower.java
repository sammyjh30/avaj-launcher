package za.co.avaj.weather;

import za.co.avaj.vehicles.Flyable;

public class WeatherTower extends Tower {
	public String		getWeather(Coordinates coordinates) {
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}

	public void		changeWeather() { this.conditionsChanged();}

}