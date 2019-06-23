package za.co.avaj.vehicles;

import za.co.avaj.weather.Coordinates;
import za.co.avaj.weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates); //Calls Parent class' constructor definition
	}

	public void	updateConditions(){}

	public void	registerTower(WeatherTower weatherTower) {}

	public String getFlyableName() {
		return (this.name);
	}

	public long		getFlyableId() {
		return (this.id);
	}
}