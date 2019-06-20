package za.co.avaj.vehicles;

import WeatherTower;

interface Flyable {
	public void		updateConditions();

	public void		registerTower(WeatherTower weatherTower);
}