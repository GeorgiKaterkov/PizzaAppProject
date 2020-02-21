package com.pizza.model;

import java.util.ArrayList;
import java.util.List;

import com.pizza.beans.DrinkBean;
import com.pizza.beans.PizzaBean;
import com.pizza.beans.SauceBean;

public class ShoppingCart {

	private List<PizzaBean> pizzas = new ArrayList<PizzaBean>();
	private List<SauceBean> sauces = new ArrayList<SauceBean>();
	private List<DrinkBean> drinks = new ArrayList<DrinkBean>();
	
	
	public List<PizzaBean> getPizzas() {
		return pizzas;
	}
	public void setPizzas(List<PizzaBean> pizzas) {
		this.pizzas = pizzas;
	}
	public List<SauceBean> getSauces() {
		return sauces;
	}
	public void setSauces(List<SauceBean> sauces) {
		this.sauces = sauces;
	}
	public List<DrinkBean> getDrinks() {
		return drinks;
	}
	public void setDrinks(List<DrinkBean> drinks) {
		this.drinks = drinks;
	}
	@Override
	public String toString() {
		return "ShoppingCart [pizzas=" + pizzas + ", sauces=" + sauces + ", drinks=" + drinks + "]";
	}
	
	
}
