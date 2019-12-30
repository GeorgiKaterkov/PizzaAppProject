package com.pizza.model;

public enum PizzaSizeEnum {
	SMALL("small"), MEDIUM("medium"), LARGE("large");	

	private final String name;
	
	private PizzaSizeEnum(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
