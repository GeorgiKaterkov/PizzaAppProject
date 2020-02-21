package com.pizza.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.beans.DrinkBean;
import com.pizza.beans.OrderBean;
import com.pizza.beans.OrderIdNameBean;
import com.pizza.beans.PizzaBean;
import com.pizza.beans.SauceBean;
import com.pizza.dao.DrinkDao;
import com.pizza.dao.OrderDao;
import com.pizza.dao.OrderDaoImpl;
import com.pizza.dao.PizzaDao;
import com.pizza.dao.SauceDao;
import com.pizza.model.Drink;
import com.pizza.model.Order;
import com.pizza.model.Pizza;
import com.pizza.model.Sauce;
import com.pizza.model.User;


@Service
public class OrderServiceImpl implements OrderService {
	private User user;
	private Order order;	

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private PizzaDao pizzaDao;
	@Autowired
	private SauceDao sauceDao;
	@Autowired
	private DrinkDao drinkDao;

	@Override
	public List<OrderBean> getNotProcessedOrders() {		
		List<OrderBean> beanOrders = new ArrayList<>();
		Collection<Order> orders = orderDao.getAll();
		for (Order order : orders) {
			OrderBean bean = new OrderBean();
			bean.setId(order.getId());
			bean.setUser(order.getUser().toString());
			bean.setDate(order.getOrderDate().toString());
			beanOrders.add(bean);
		}
		return beanOrders;
	}

	@Override
	public void processOrders() {
		Collection<Order> orders = orderDao.getAll();
		for (Order order : orders) {
			orderDao.processOrders(order);
		}
	}
    @Override
	public List<OrderIdNameBean> repeatPrevOrder(User user) {	
    	System.out.println("In repeat method");
		Collection<Order> orders = orderDao.getAllBy(user);
		System.out.println("After orderDao");
		List<OrderIdNameBean> ordersBean = new ArrayList<OrderIdNameBean>();
		for(Order order : orders) {
			OrderIdNameBean bean = new OrderIdNameBean();
			bean.setId(order.getId());
			bean.setName(order.getPizzas().toString()+ " "+order.getSauces().toString()+" "+order.getDrinks().toString());
			ordersBean.add(bean);
		}
		return ordersBean;
	}

    @Override
	public Order createOrderFromOldOrder(int orderId) {
		Order oldOrder = orderDao.get(orderId);
		
		Set<Pizza> pizzas = new HashSet<>();
		pizzas.addAll(oldOrder.getPizzas());
		Set<Sauce> sauces = new HashSet<>();
		sauces.addAll(oldOrder.getSauces());
		Set<Drink> drinks = new HashSet<>();
		drinks.addAll(oldOrder.getDrinks());
		User user = oldOrder.getUser();
		

		Order newOrder = new Order(pizzas, sauces, drinks, user, false, new Date());
		orderDao.save(newOrder);
		System.out.println("After SAVE");
		return order;
	}

	@Override
	public List<OrderBean> orderEnquiry(Date from, Date to) {		
		List<OrderBean> listBeans = new ArrayList<>();
		List<Order> orderEnquiry = orderDao.getAllByPeriod(from, to);
		for (Order order : orderEnquiry) {
			OrderBean bean = new OrderBean();
			bean.setId(order.getId());
			bean.setUser(order.getUser().toString());
			bean.setDate(order.getOrderDate().toString());
			listBeans.add(bean);
		}
		return listBeans;
	}
	
	@Override
	public void makeOrder(Set<PizzaBean> pizzas,Set<SauceBean> sauces, Set<DrinkBean> drinks, User user) {
		
		
		Set<Pizza> setPizzas = new HashSet<Pizza>();		
		for(PizzaBean bean : pizzas) {
			Pizza pizza = pizzaDao.get(bean.getPizzaId());	
			for(int i=0;i<bean.getQuantity();i++) {
				setPizzas.add(pizza);
			}
		}
		
		Set<Sauce> setSauces = new HashSet<Sauce>();
		for(SauceBean bean : sauces) {
			Sauce sauce = sauceDao.get(bean.getId());
			for(int i=0;i<bean.getQuantity();i++) {
				setSauces.add(sauce);
			}
		}
		
		Set<Drink> setDrinks = new HashSet<Drink>();
		for(DrinkBean bean : drinks) {
			Drink drink = drinkDao.get(bean.getId());
			for(int i=0;i<bean.getQuantity();i++) {
				setDrinks.add(drink);
			}
		}
		
		Order order = new Order(setPizzas,setSauces,setDrinks,user,false,new Date());
		orderDao.save(order);
		
	}
	
	

}
