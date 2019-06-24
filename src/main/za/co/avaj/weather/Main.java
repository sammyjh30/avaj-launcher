package za.co.avaj.weather;

import za.co.avaj.exceptions.InvalidFileException;
import za.co.avaj.reader.Reader;
import java.lang.String;

public class Main {

	public static void main (String[] args) {
		try {
			int numberOfRuns = 0;
			Reader reader = new Reader();
			if (args.length != 1 || !args[0].endsWith("scenario.txt")) {
				reader.log.logToFile("error", "Invalid arguments.");
				throw new InvalidFileException("ERROR: Invalid arguments.");
			}

			if ((numberOfRuns = reader.readFile(args[0])) <= 0) {
				reader.log.logToFile("error", "Invalid number of simulations to run.");
				throw new InvalidFileException("ERROR: Invalid number of simulations to run.");
			}
			//Run simulation
			while (numberOfRuns-- > 0) {
				reader.weatherTower.changeWeather();
			}
		} catch (InvalidFileException e) {
			e.printStackTrace();
		}
	}
}
