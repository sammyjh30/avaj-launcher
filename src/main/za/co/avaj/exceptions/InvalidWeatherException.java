package za.co.avaj.exceptions;

public class InvalidWeatherException extends Exception {
	public InvalidWeatherException(String errorMessage) {
		super(errorMessage);
	}
}
