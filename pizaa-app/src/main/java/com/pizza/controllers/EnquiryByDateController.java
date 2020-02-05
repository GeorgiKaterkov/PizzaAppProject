package com.pizza.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pizza.beans.OrderBean;
import com.pizza.exceptions.UnparseableDataException;
import com.pizza.model.Order;
import com.pizza.services.OrderService;

@Controller
public class EnquiryByDateController {

	private static final String dateRegex = "^[0-9]{2}[-|\\\\/]{1}[0-9]{2}[-|\\\\/]{1}[0-9]{4}$";
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "/enquiry", method =RequestMethod.GET)
	public String showProcessedOrders(ModelMap model) {		
		return "dataFrom&DataTo";
	}
	
	@RequestMapping(value= "/dataFrom&DataTo" , method = {RequestMethod.GET, RequestMethod.POST})
	public String pizzaChoice(ModelMap model, @RequestParam String dateFrom, @RequestParam String dateTo) {
		try {
		if(dateFrom.matches(dateRegex) 
				&& dateTo.matches(dateRegex)) {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date startDate = format.parse(dateFrom);
			Date endDate = format.parse(dateTo);
			List<OrderBean> orderEnquiries = orderService.orderEnquiry(startDate, endDate);
			model.put("orderEnquiries", orderEnquiries);			
		}else System.out.println("Invalid data!");
		}catch(ParseException e) {
			throw new UnparseableDataException(e.getMessage());
		}
		return "listEnquiry";			
}}