package za.co.avaj.weather;

import za.co.avaj.exceptions.InvalidFileException;
import za.co.avaj.reader.Reader;

import java.io.File;
import java.lang.String;

public class Main {

	public static void main (String[] args) {
		try {
			int numberOfRuns = 0;
			Reader reader = new Reader();
			if (args.length != 1 || !args[0].endsWith("scenario.txt")) {
				throw new InvalidFileException((char) 27 + "[31m" + "ERROR: " + (char) 27 + "[37m" + "Invalid arguments.");
			}

			File file = new File("./simulation.txt");

			if(file.delete())
			{
				reader.log.logToConsole("notify", "simulation.txt found and deleted successfully");
			}
			numberOfRuns = reader.readFile(args[0]);
			if (numberOfRuns == 0) {
				throw new InvalidFileException((char)27 + "[31m" + "ERROR: " + (char)27 + "[37m"  + "Invalid number of simulations to run.");
			} else if (numberOfRuns  < 0) {
				throw new InvalidFileException((char)27 + "[31m" + "ERROR: " + (char)27 + "[37m"  + "Invalid file.");
			}
			//Run simulation
			while (numberOfRuns-- > 0) {
				reader.weatherTower.changeWeather();
			}
			reader.log.logToConsole("notify", "Simulation complete!");
		} catch (InvalidFileException e) {
			e.printStackTrace();
			return;
		}
	}
}
