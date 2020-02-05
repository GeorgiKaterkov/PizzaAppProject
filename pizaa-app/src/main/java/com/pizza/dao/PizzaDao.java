package com.pizza.dao;

import java.math.BigDecimal;
import java.util.Collection;

import com.pizza.model.Pizza;

public interface PizzaDao {
    
	Pizza get(int id);
     
    Collection<Pizza> getAll();
     
    Collection<Pizza> getAllBy(Integer id);
    
    void save(Pizza pizza);
     
    void update(int id,BigDecimal price);
     
    void delete(Integer id);
    
    void processOrders(Pizza pizza);

	Collection<Pizza> getAllBy(String pizzaName);

	Collection<String> getAllByDistinctName();
}