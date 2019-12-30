package com.pizza.services;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.dao.OrderDao;
import com.pizza.dao.OrderDaoImpl;
import com.pizza.model.Drink;
import com.pizza.model.Order;
import com.pizza.model.Pizza;
import com.pizza.model.Sauce;
import com.pizza.model.User;
@Service
public class OrderServiceImpl implements OrderService{
	private User user;	
	private Order order;
	
	@Autowired
	private OrderDao orderDao;
	//ADMIN
	public void getNotProcessedOrders() {
		System.out.println("Orders: ");
		Collection<Order> orders = orderDao.getAll();
		for (Order order : orders) {
			System.out.println(order.toString());
		}
		System.out.println("...Process orders...");
	}
	
	public void processOrders(){
		Collection<Order> orders = orderDao.getAll();
		for (Order order : orders) {
			orderDao.processOrders(order);
		}
	}
	
	public Collection<Order> repeatPrevOrder(){
		int id = user.getId();		
		Collection<Order> orders = orderDao.getAllBy(id);
		for(Order order : orders ){
			if(order.getUser().getId() == id && !order.getIsProceeded()){
				System.out.println(order);
			}
		}
		return orders;
	}
	
	public Order createOrderFromOldOrder(int orderId){
		Order oldOrder = orderDao.get(orderId);
		Set<Pizza> pizzas = new HashSet<>();
		pizzas.addAll(oldOrder.getPizzas());
		Set<Sauce> sauces = new HashSet<>(); 
		sauces.addAll(oldOrder.getSauces());
		Set<Drink> drinks = new HashSet<>();
		drinks.addAll(oldOrder.getDrinks());

		Order newOrder = new Order(pizzas, sauces, drinks, user, true, new Date());
		orderDao.save(newOrder);
		System.out.println("After SAVE");
		return order;		
	}
	
	public Collection<Order> orderEnquiry(Date from, Date to){
		return orderDao.getAllByPeriod(from, to);
	}

}
