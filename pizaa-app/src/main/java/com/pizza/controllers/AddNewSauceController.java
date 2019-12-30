package com.pizza.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pizza.services.SauceService;
@Controller
public class AddNewSauceController {
	
	@Autowired
	public SauceService sauceService;
	
	@RequestMapping(value= "/addSauce" , method = RequestMethod.GET)
	public String showAddingField(ModelMap model) {
		return "addNewSauce";
	}
	
	@RequestMapping(value= "/addNewSauce" , method = {RequestMethod.GET, RequestMethod.POST})
	public void pizzaChoice(ModelMap model,@RequestParam String sauceName,@RequestParam BigDecimal price) {
		
		sauceService.addNewSauce(sauceName, price);		
	}

}
