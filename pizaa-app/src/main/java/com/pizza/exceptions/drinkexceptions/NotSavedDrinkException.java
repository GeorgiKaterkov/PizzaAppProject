package com.pizza.exceptions.drinkexceptions;

public class NotSavedDrinkException extends RuntimeException{

private String errorMessage ;
	
    public NotSavedDrinkException(String errorMessage) {
        this.setErrorMessage(errorMessage);
    }

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
