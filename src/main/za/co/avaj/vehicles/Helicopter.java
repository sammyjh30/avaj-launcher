package za.co.avaj.vehicles;

import za.co.avaj.weather.Coordinates;
import za.co.avaj.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable{
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates) {}

	public void	updateConditions(){}

	public void	registerTower(WeatherTower weatherTower) {}
	
}