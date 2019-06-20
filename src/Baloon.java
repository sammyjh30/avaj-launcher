import Aircraft;
import WeatherTower;

public class Baloon extends Aircraft implements Flyable{
	WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates) {}

	void	updateConditions(){}

	void	registerTower(WeatherTower weatherTower) {}
	
}