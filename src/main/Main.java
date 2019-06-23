import za.co.avaj.logger.Logger;
import za.co.avaj.vehicles.Baloon;
import za.co.avaj.vehicles.Flyable;
import za.co.avaj.vehicles.Helicopter;
import za.co.avaj.vehicles.JetPlane;
import za.co.avaj.weather.Coordinates;
import za.co.avaj.weather.WeatherProvider;
import za.co.avaj.weather.WeatherTower;

import java.io.*;
import java.lang.String;

public class Main {

	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch(NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	//Import what is needed.
	public static void main (String[] args) {
		Logger log = new Logger();
		int numberOfRuns = 0;
		WeatherTower weatherTower = new WeatherTower();

		if (args.length != 1 || !args[0].endsWith("scenario.txt")) {
			log.logToConsole("error", "Invalid Arguments");
			System.exit(1);
		}
		try {
			File file = new File(args[0]);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
			int     line = 0;
			// Read file
			try {
				while ((st = br.readLine()) != null) {
					if (line == 0) {
						if (isNumeric(st)) {
							Integer.parseInt(st);
						}
					} else {
						//Create and register aircraft
						String details[] = st.split(" ");
						if (details.length != 5) {
							log.logToConsole("error", "Invalid details.");
						} else {
							switch (details[0]) {
								case "Baloon":
										weatherTower.register(new Baloon(details[1],
												new Coordinates(Integer.parseInt(details[2]),
																Integer.parseInt(details[3]),
																Integer.parseInt(details[4]))));
										break;
								case "Helicopter":
									weatherTower.register(new Helicopter(details[1],
											new Coordinates(Integer.parseInt(details[2]),
													Integer.parseInt(details[3]),
													Integer.parseInt(details[4]))));
									break;
								case "JetPlane":
									weatherTower.register(new JetPlane(details[1],
											new Coordinates(Integer.parseInt(details[2]),
													Integer.parseInt(details[3]),
													Integer.parseInt(details[4]))));
									break;
							}
						}
					}
					line++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			//Run simulation
			while (numberOfRuns-- > 0) {
				//generate random weather
				//iterate through aircrafts applying "update condition"
				//each update condition adjusts the coords and prints appropriate statement

			}
		}  catch ( FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
