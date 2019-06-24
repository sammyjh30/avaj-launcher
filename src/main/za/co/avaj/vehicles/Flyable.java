package za.co.avaj.vehicles;

import za.co.avaj.weather.WeatherTower;

public interface Flyable {

	public void		updateConditions();

	public void		registerTower(WeatherTower weatherTower);

	public String 		getFlyableName();

	public long			getFlyableId();

	public String		getFlyableType();
}