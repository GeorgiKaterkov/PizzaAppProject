package com.pizza.exceptions.drinkexceptions;

public class NoCollectionDrinksException extends RuntimeException {

	private String errorMessage ;
	
    public NoCollectionDrinksException(String errorMessage) {
        this.setErrorMessage(errorMessage);
    }

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
