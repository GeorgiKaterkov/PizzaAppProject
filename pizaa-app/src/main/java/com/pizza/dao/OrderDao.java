package com.pizza.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.pizza.model.Order;
import com.pizza.model.User;

public interface OrderDao {
    
	Order get(int id);
     
    Collection<Order> getAll();
     
    Collection<Order> getAllBy(User user);
    
    void save(Order order);
     
    void update(int id);
     
    void delete(int id);
    
    void processOrders(Order order);

	List<Order> getAllByPeriod(Date from, Date to);
}