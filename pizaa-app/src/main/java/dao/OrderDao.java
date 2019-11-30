package dao;

import java.util.Collection;
import java.util.Date;

import entities.Order;

public interface OrderDao {
    
	Order get(int id);
     
    Collection<Order> getAll();
     
    Collection<Order> getAllBy(Integer id);
    
    void save(Order order);
     
    void update(int id);
     
    void delete(int id);
    
    void processOrders(Order order);

	Collection<Order> getAllByPeriod(Date from, Date to);
}