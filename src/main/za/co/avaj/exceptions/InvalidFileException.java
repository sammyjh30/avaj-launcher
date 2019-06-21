package za.co.avaj.exceptions;

public class InvalidFileException extends Exception {
    public InvalidFileException(String errorMessage) {
    	super(errorMessage);
    }
}
