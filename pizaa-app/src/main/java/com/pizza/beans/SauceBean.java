package com.pizza.beans;

import java.math.BigDecimal;

public class SauceBean {

	private int id;
	private String sauceName;
	private BigDecimal price;
	private Integer quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSauceName() {
		return sauceName;
	}

	public void setSauceName(String sauceName) {
		this.sauceName = sauceName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "SauceBean [id=" + id + ", sauceName=" + sauceName + ", price=" + price + ", quantity=" + quantity + "]";
	}
	

}
