package za.co.avaj.vehicles;

import Aircraft;
import WeatherTower;

public class Baloon extends Aircraft implements Flyable{
	private WeatherTower weatherTower;

	/* ~ package */ Baloon(String name, Coordinates coordinates) {}

	public void	updateConditions(){}

	public void	registerTower(WeatherTower weatherTower) {}
	
}