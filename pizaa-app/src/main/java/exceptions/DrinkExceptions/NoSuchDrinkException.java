package exceptions.DrinkExceptions;

public class NoSuchDrinkException  extends RuntimeException{

	private String errorMessage ;
	
    public NoSuchDrinkException(String errorMessage) {
        this.setErrorMessage(errorMessage);
    }

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
