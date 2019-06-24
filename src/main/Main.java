import za.co.avaj.reader.Reader;
import java.lang.String;

public class Main {

	public static void main (String[] args) {
		int numberOfRuns = 0;
		Reader reader = new Reader();
		if (args.length != 1 || !args[0].endsWith("scenario.txt")) {
			reader.log.logToConsole("error", "Invalid Arguments");
			System.exit(1);
		}
		numberOfRuns = reader.readFile(args[0]);
		System.out.println(numberOfRuns);
		//Run simulation
		while (numberOfRuns-- > 0) {
			reader.weatherTower.changeWeather();
		}
	}
}
