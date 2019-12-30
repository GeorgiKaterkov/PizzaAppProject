package com.pizza.dao;

import java.util.Collection;

import com.pizza.model.Pizza;

public interface PizzaDao {
    
	Pizza get(int id);
     
    Collection<Pizza> getAll();
     
    Collection<Pizza> getAllBy(Integer id);
    
    void save(Pizza pizza);
     
    void update(int id);
     
    void delete(String name);
    
    void processOrders(Pizza pizza);
}