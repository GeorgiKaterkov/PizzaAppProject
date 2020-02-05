package com.pizza.beans;

import java.math.BigDecimal;

public class PizzaBean {
	
	private int pizzaId;
	private String namePizza;
	private String pizzaSize;
	private BigDecimal price;
	private int quantity=0;
	
	public int getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}
	
	public String getNamePizza() {
		return namePizza;
	}
	public void setNamePizza(String namePizza) {
		this.namePizza = namePizza;
	}
	public String getPizzaSize() {
		return pizzaSize;
	}
	public void setPizzaSize(String pizzaSize) {
		this.pizzaSize = pizzaSize;
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
		return "PizzaBean [pizzaId=" + pizzaId + ", namePizza=" + namePizza + ", pizzaSize=" + pizzaSize + ", price="
				+ price + "]";
	}
		
}
