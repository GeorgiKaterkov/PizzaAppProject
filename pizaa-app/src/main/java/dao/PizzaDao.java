package dao;

import java.util.Collection;

import entities.Pizza;

public interface PizzaDao {
    
	Pizza get(int id);
     
    Collection<Pizza> getAll();
     
    Collection<Pizza> getAllBy(Integer id);
    
    void save(Pizza pizza);
     
    void update(int id);
     
    void delete(int id);
    
    void processOrders(Pizza pizza);
}