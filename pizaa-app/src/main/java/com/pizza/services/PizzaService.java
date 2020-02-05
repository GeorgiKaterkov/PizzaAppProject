package com.pizza.services;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.pizza.beans.PizzaBean;
import com.pizza.model.Pizza;

public interface PizzaService {

	Collection<PizzaBean> getAllPizzas();

	void addNewPizza(String name,String size, BigDecimal price);

	void deletePizza(Integer id);	

	Collection<PizzaBean> getOptionsByPizzaName(String name);

	Collection<PizzaBean> getAllPizzasForDeleting();	

	PizzaBean returnBeanToUpdate(Integer id);

	void updatePizza(Integer id, BigDecimal price);

	PizzaBean toShoppingCart(Integer id, Integer quantity);
}
