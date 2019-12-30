package com.pizza.exceptions;

public class UnparseableDataException extends RuntimeException{

private String errorMessage ;
	
    public UnparseableDataException(String errorMessage) {
        this.setErrorMessage(errorMessage);
    }

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
}
}
