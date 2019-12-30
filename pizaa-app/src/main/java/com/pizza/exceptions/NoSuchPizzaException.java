package com.pizza.exceptions;

public class NoSuchPizzaException extends RuntimeException{

	private String errorMessage;

	public NoSuchPizzaException(String errorMessage) {
        this.setErrorMessage(errorMessage);
    }

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
