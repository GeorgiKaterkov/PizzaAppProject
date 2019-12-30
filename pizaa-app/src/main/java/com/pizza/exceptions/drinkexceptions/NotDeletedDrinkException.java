package com.pizza.exceptions.drinkexceptions;

public class NotDeletedDrinkException extends RuntimeException {

	private String errorMessage ;
	
    public NotDeletedDrinkException(String errorMessage) {
        this.setErrorMessage(errorMessage);
    }

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
