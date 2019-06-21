package za.co.avaj.vehicles;

import za.co.avaj.weather.Coordinates;
import za.co.avaj.weather.WeatherTower;

public class JetPlain extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlain(String name, Coordinates coordinates) {}

    public void	updateConditions(){}

    public void	registerTower(WeatherTower weatherTower) {}

}