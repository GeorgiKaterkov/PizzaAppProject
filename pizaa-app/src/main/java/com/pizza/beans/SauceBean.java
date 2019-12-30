package com.pizza.beans;

import java.math.BigDecimal;

public class SauceBean {

	private int id;
	private String sauceName;
	private BigDecimal price;

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

}
