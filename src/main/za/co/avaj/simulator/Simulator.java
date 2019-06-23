package za.co.avaj.simulator;

import java.io.*;
import java.lang.String;

public class Simulator {

	//Import what is needed.
	public static void main (String[] args) {
		System.out.println("Test");
		if (args.length != 1 || args[0] != "scenario.txt") {
			//Invalid arguments
			System.exit(1);
		}
		try {
			File file = new File(args[0]);

			BufferedReader br = new BufferedReader(new FileReader(file));

			String st;
			try {
				while ((st = br.readLine()) != null)
					System.out.println(st);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}  catch ( FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
