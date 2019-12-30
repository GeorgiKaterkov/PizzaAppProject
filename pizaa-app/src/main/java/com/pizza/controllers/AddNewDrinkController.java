package com.pizza.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pizza.services.DrinkService;

@Controller
public class AddNewDrinkController {

	@Autowired
	public DrinkService drinkService;
	
	@RequestMapping(value= "/addDrink" , method = RequestMethod.GET)
	public String showAddingField(ModelMap model) {
		return "addNewDrink";
	}
	
	@RequestMapping(value= "/addNewDrink" , method = {RequestMethod.GET, RequestMethod.POST})
	public void pizzaChoice(ModelMap model,@RequestParam String drinkName,@RequestParam BigDecimal price) {
		
		drinkService.addNewDrink(drinkName, price);		
	}
}
