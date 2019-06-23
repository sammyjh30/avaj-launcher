package za.co.avaj.weather;

import java.util.Random;

import static java.lang.Math.abs;

public class WeatherProvider {
	private static WeatherProvider weatherProvider = new WeatherProvider();

	private static String[]		weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider(){}

	public static WeatherProvider		getProvider() {
		return weatherProvider;
	}

	public String				getCurrentWeather(Coordinates coordinates) {
		Random rand = new Random();
		int randInt = abs(rand.nextInt(coordinates.getHeight() +
												coordinates.getLatitude() +
												coordinates.getLatitude()));
		randInt = randInt % 4;
		return weather[randInt];
	}
}  