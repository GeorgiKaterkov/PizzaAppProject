package exceptions;

public class InputMismatchPriceException extends RuntimeException {

	private String errorMessage ;
	
    public InputMismatchPriceException(String errorMessage) {
        this.setErrorMessage(errorMessage);
    }

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
