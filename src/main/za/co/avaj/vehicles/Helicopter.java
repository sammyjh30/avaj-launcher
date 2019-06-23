package za.co.avaj.vehicles;

import za.co.avaj.weather.Coordinates;
import za.co.avaj.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable{
	private WeatherTower weatherTower;

	public Helicopter(String name, Coordinates coordinates) {
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

	public String		getFlyableType() {
		return ("Helicopter");
	}
}