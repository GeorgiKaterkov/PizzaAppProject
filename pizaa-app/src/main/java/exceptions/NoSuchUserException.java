package exceptions;

public class NoSuchUserException extends RuntimeException {

	private String errorMessage ;
	
    public NoSuchUserException(String errorMessage) {
        this.setErrorMessage(errorMessage);
    }

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
    
}