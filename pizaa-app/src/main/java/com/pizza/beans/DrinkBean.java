package com.pizza.beans;

import java.math.BigDecimal;

public class DrinkBean {

	private int id;
	private String drinkName;
	private BigDecimal price;
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "DrinkBean [id=" + id + ", drinkName=" + drinkName + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
}
