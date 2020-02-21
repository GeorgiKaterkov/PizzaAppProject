package com.pizza.services;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.pizza.beans.DrinkBean;
import com.pizza.beans.OrderBean;
import com.pizza.beans.OrderIdNameBean;
import com.pizza.beans.PizzaBean;
import com.pizza.beans.SauceBean;
import com.pizza.model.Order;
import com.pizza.model.User;

public interface OrderService {

	List<OrderBean> getNotProcessedOrders();

	void processOrders();

	List<OrderBean> orderEnquiry(Date from, Date to);

	void makeOrder(Set<PizzaBean> pizzas, Set<SauceBean> sauces, Set<DrinkBean> drinks, User user);

	List<OrderIdNameBean> repeatPrevOrder(User user);

	Order createOrderFromOldOrder(int orderId);

}
