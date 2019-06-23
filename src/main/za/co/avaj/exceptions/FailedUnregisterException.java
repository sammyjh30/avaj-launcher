package za.co.avaj.exceptions;

public class FailedUnregisterException extends Exception {
	public FailedUnregisterException(String errorMessage) {
		super(errorMessage);
	}
}
