package com.pizza.beans;

public class SauceJspBean {
	
	private Integer sauceId;
	private Integer quantity;
	
	public Integer getSauceId() {
		return sauceId;
	}
	public void setSauceId(Integer sauceId) {
		this.sauceId = sauceId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "SauceJspBean [sauceId=" + sauceId + ", quantity=" + quantity + "]";
	}
	
}
