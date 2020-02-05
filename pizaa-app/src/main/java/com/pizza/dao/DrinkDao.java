package com.pizza.dao;

import java.math.BigDecimal;
import java.util.Collection;

import com.pizza.model.Drink;

public interface DrinkDao {
    
    Drink get(int id);
     
    Collection<Drink> getAll();
     
    Collection<Drink> getAllBy(Integer id);
    
    void save(Drink drink);
     
    void update(int id,BigDecimal price);
     
    void delete(int id);
    
    void processOrders(Drink drink);
}