package com.pizza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pizza.beans.DrinkBean;
import com.pizza.services.DrinkService;

@Controller
public class DrinksController {
	
	@Autowired
	DrinkService drinkService;
	
	@RequestMapping(value= "/drinks" ,method = { RequestMethod.GET, RequestMethod.POST })
	public String showAllDrinks(ModelMap model) {
		
		List<DrinkBean> drinks = drinkService.getAllDrinks();
		
		model.put("drinks", drinks);
		return "allDrinks";		
	}

}
