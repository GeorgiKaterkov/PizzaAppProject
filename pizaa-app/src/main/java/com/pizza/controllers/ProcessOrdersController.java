package com.pizza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pizza.beans.OrderBean;
import com.pizza.model.Order;
import com.pizza.services.OrderService;


@Controller
public class ProcessOrdersController {

	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "/process", method =RequestMethod.GET)
	public String showProcessedOrders(ModelMap model) {
		
		List<OrderBean> orders = orderService.getNotProcessedOrders();
		
		model.put("orders", orders);
		return "newOrdersShown";
	}
	
	@RequestMapping(value= "/processOrders" , method = {RequestMethod.GET, RequestMethod.POST})
	public void pizzaChoice(ModelMap model) {		
			orderService.processOrders();
	}
}
