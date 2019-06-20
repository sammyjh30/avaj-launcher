package za.co.avaj.vehicles;

import Aircraft;
import WeatherTower;

public class JetPlain extends Aircraft implements Flyable{
	private WeatherTower weatherTower;

	/* ~ package*/ JetPlain(String name, Coordinates coordinates) {}

	public void	updateConditions(){}

	public void	registerTower(WeatherTower weatherTower) {}
	
}