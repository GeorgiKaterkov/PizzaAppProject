package com.pizza.beans;

public class PizzaJspBean {
	
	private Integer pizzaId;
	private Integer quantity;
	
	
	public Integer getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(Integer pizzaId) {
		this.pizzaId = pizzaId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "PizzaJspBean [id=" + pizzaId + ", quantity=" + quantity + "]";
	} 
	

}
