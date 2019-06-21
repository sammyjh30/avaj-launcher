
import Aircraft;
import WeatherTower;

public class Helicopter extends Aircraft implements Flyable{
	private WeatherTower weatherTower;

	/* ~ package */ Helicopter(String name, Coordinates coordinates) {}

	public void	updateConditions(){}

	public void	registerTower(WeatherTower weatherTower) {}
	
}