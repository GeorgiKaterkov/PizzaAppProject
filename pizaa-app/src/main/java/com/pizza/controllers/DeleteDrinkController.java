package com.pizza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pizza.beans.DrinkBean;
import com.pizza.beans.SauceBean;
import com.pizza.services.DrinkService;
import com.pizza.services.SauceService;

@Controller
public class DeleteDrinkController {
	
	@Autowired
	DrinkService drinkService;
	
	@RequestMapping(value = "/deleteDrink", method = { RequestMethod.GET, RequestMethod.POST })
	public String showAddingField(ModelMap model) {
		List<DrinkBean> drinks = drinkService.getAllDrinks();

		model.put("drinks", drinks);
		return "chooseDrinkToDelete";
	}
	
	@RequestMapping(value= "/chooseDrinkToDelete" , method = {RequestMethod.GET, RequestMethod.POST})
	public void pizzaChoice(ModelMap model,@RequestParam Integer id) {
		
		drinkService.deleteDrink(id);
	}

}
