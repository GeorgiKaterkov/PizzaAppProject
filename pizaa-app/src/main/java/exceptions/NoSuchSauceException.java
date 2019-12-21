package exceptions;

public class NoSuchSauceException extends RuntimeException {

	private String errorMessage;

	public NoSuchSauceException(String errorMessage) {
		this.setErrorMessage(errorMessage);
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
