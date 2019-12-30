package com.pizza.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pizza.services.PizzaService;
@Controller
public class AddNewPizzaController {
	
	@Autowired
	public PizzaService pizzaService;
	
	@RequestMapping(value= "/addPizza" , method = RequestMethod.GET)
	public String showAddingField(ModelMap model) {
		return "addNewPizza";
	}
	
	@RequestMapping(value= "/addNewPizza" , method = {RequestMethod.GET, RequestMethod.POST})
	public void pizzaChoice(ModelMap model,@RequestParam String pizzaName,@RequestParam String size,@RequestParam BigDecimal price) {
		
		pizzaService.addNewPizza(pizzaName, size, price);		
	}

}
