package com.pizza.exceptions;

public class NotDeletedPizzaException extends RuntimeException{
	
    private String errorMessage ;
	
    public NotDeletedPizzaException(String errorMessage) {
        this.setErrorMessage(errorMessage);
    }

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
