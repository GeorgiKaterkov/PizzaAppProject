package dao;

import java.util.Collection;

import entities.Drink;

public interface DrinkDao {
    
    Drink get(int id);
     
    Collection<Drink> getAll();
     
    Collection<Drink> getAllBy(Integer id);
    
    void save(Drink drink);
     
    void update(int id);
     
    void delete(int id);
    
    void processOrders(Drink drink);
}