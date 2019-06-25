package za.co.avaj.reader;

import za.co.avaj.exceptions.InvalidAircraftException;
import za.co.avaj.exceptions.InvalidFileException;
import za.co.avaj.logger.Logger;
import za.co.avaj.vehicles.*;
import za.co.avaj.weather.WeatherTower;

import java.io.*;

public class Reader {

	public WeatherTower weatherTower = new WeatherTower();
	public Logger log = new Logger();

	public static boolean 	isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch(NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public boolean isStringInt(String s)
	{
		try
		{
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException ex)
		{
			return false;
		}
	}

	private int				interpretLine(String[] details) {
		AircraftFactory aircraftFactory = new AircraftFactory();
		try {
			if (details.length != 5 || !isStringInt(details[2]) || !isStringInt(details[3]) || !isStringInt(details[4])) {
				System.out.println("TEST1");
				throw new InvalidAircraftException((char) 27 + "[31m" + "ERROR: " + (char) 27 + "[37m" + "Invalid details, failed to construct new Aircraft: " + details[0]);
			} else {
				switch (details[0]) {
					case "Baloon":
						Flyable baloon = aircraftFactory.newAircraft("Baloon",details[1],
								Integer.parseInt(details[2]),
								Integer.parseInt(details[3]),
								Integer.parseInt(details[4]));
						baloon.registerTower(weatherTower);
						this.weatherTower.register(baloon);
						break;
					case "Helicopter":
						Flyable helicopter = aircraftFactory.newAircraft("Helicopter",details[1],
								Integer.parseInt(details[2]),
								Integer.parseInt(details[3]),
								Integer.parseInt(details[4]));
						helicopter.registerTower(weatherTower);
						this.weatherTower.register(helicopter);
						break;
					case "JetPlane":
						Flyable jetPlane = aircraftFactory.newAircraft("JetPlane",details[1],
								Integer.parseInt(details[2]),
								Integer.parseInt(details[3]),
								Integer.parseInt(details[4]));
						jetPlane.registerTower(weatherTower);
						this.weatherTower.register(jetPlane);
						break;
					default:
						System.out.println("TEST2");
						throw new InvalidAircraftException((char) 27 + "[31m" + "ERROR: " + (char) 27 + "[37m" + "failed to construct new Aircraft: " + details[0]);
				}
			}
		} catch (InvalidAircraftException e) {
			e.printStackTrace();
			return (-1);
		}
		return (1);
	}

	public int				readFile(String input) {
		int numberOfRuns = 0;
		try {
			File file = new File(input);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;

			int     line = 0;
			// Read file
			try {
				while ((st = br.readLine()) != null) {
					try {
						if (line == 0) {
							if (isNumeric(st)) {
								numberOfRuns = Integer.parseInt(st);
							} else {
								throw new InvalidFileException((char) 27 + "[31m" + "ERROR: " + (char) 27 + "[37m" + "Invalid first line");
							}
						} else {
							//Create and register aircraft
							String details[] = st.split(" ");
							if (this.interpretLine(details) == -1) {
								return (-1);
							}
						}
					} catch (InvalidFileException e) {
						e.printStackTrace();
					}

					line++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}  catch ( FileNotFoundException e) {
			e.printStackTrace();
		}
		return numberOfRuns;
	}
}
