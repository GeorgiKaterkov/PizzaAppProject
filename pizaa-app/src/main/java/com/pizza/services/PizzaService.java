package com.pizza.services;

import java.math.BigDecimal;
import java.util.Collection;

import com.pizza.beans.PizzaBean;

public interface PizzaService {

	Collection<PizzaBean> getAllPizzas();

	void addNewPizza(String name,String size, BigDecimal price);

	void deletePizza(String name);
}
