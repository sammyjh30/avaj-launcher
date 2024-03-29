package za.co.avaj.logger;

import java.io.*;

public class Logger {
	public void     logToConsole(String type, String message) {
//		System.out.println((char)27 + "[30mYELLOW");
//		System.out.println((char)27 + "[31m" + "ERROR MESSAGE IN RED");
//		System.out.println((char)27 + "[32mGREEN");
//		System.out.println((char)27 + "[33mYELLOW");
//		System.out.println((char)27 + "[34mBLUE");
//		System.out.println((char)27 + "[35mPURPLE");
//		System.out.println((char)27 + "[36mLIGHTBLUE");
//		System.out.println((char)27 + "[37mWHITE");
		if (type.equals("error")) {
			System.out.println((char) 27 + "[31m" + "ERROR: " + (char) 27 + "[37m" + message);
		} else if (type.equals("warning")) {
			System.out.println((char) 27 + "[33m" + "NOTICE: " + (char) 27 + "[37m" + message);
		} else if (type.equals("notify")) {
			System.out.println((char) 27 + "[32m" + "NOTICE: " + (char) 27 + "[37m" + message);
		} else {
			System.out.println(message);
		}
	}

	public void     logToFile(String message) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("./simulation.txt", true));

			writer.write(message + '\n');
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
