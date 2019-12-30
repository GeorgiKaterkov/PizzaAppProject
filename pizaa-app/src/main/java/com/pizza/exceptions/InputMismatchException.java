package com.pizza.exceptions;

public class InputMismatchException extends RuntimeException {

    private String errorMessage ;
	
    public InputMismatchException(String errorMessage) {
        this.setErrorMessage(errorMessage);
    }

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
