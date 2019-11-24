package exceptions;

public class UserInputException extends RuntimeException {

	private String errorMessage ;
	
    public UserInputException(String errorMessage) {
        this.setErrorMessage(errorMessage);
    }

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
    
}
