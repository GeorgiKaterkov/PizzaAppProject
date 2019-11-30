package dao;

import java.util.Collection;

import entities.Sauce;

public interface SauceDao {
    
	Sauce get(int id);
     
    Collection<Sauce> getAll();
     
    Collection<Sauce> getAllBy(Integer id);
    
    void save(Sauce sauce);
     
    void update(int id);
     
    void delete(int id);
    
    void processOrders(Sauce sauce);
}