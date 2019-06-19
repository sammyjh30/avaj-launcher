
import Aircraft;
import WeatherTower;

public class Helicopter extends Aircraft implements Flyable{
	WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates) {}

	void	updateConditions(){}

	void	registerTower(WeatherTower weatherTower) {}
	
}