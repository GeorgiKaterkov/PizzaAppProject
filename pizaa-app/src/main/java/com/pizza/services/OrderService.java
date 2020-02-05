package com.pizza.services;

import java.util.Date;
import java.util.List;

import com.pizza.beans.OrderBean;
import com.pizza.model.Order;

public interface OrderService {

	List<OrderBean> getNotProcessedOrders();

	void processOrders();

	List<OrderBean> orderEnquiry(Date from, Date to);

}
