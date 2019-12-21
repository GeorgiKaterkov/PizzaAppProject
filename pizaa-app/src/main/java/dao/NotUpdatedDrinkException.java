package dao;

public class NotUpdatedDrinkException extends RuntimeException {

	private String errorMessage ;
	
    public NotUpdatedDrinkException(String errorMessage) {
        this.setErrorMessage(errorMessage);
    }

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
