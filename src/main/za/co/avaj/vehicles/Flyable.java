package za.co.avaj.vehicles;

import za.co.avaj.weather.WeatherTower;

interface Flyable {
	public void		updateConditions();

	public void		registerTower(WeatherTower weatherTower);
}