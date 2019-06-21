package za.co.avaj.exceptions;

public class InvalidAircraftException extends Exception {
	public InvalidAircraftException() {
//	public InvalidAircraftException(String errorMessage) {
		super("Invalid Aircraft requested.");
	}
}
