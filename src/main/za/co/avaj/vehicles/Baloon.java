package za.co.avaj.vehicles;

import za.co.avaj.weather.Coordinates;
import za.co.avaj.weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates) {}

	public void	updateConditions(){}

	public void	registerTower(WeatherTower weatherTower) {}
	
}