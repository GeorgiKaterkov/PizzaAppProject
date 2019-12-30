package com.pizza.dao;

import java.util.Collection;

import com.pizza.model.Sauce;

public interface SauceDao {
    
	Sauce get(int id);
     
    Collection<Sauce> getAll();
     
    Collection<Sauce> getAllBy(Integer id);
    
    void save(Sauce sauce);
     
    void update(int id);
     
    void delete(int id);
    
    void processOrders(Sauce sauce);
}