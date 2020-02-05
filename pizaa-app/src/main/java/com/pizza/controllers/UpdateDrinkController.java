package com.pizza.controllers;

import java.math.BigDecimal;
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

@Controller
public class UpdateDrinkController {

	@Autowired
	DrinkService drinkService;
	
	@RequestMapping(value = "/updateDrink", method = { RequestMethod.GET, RequestMethod.POST })
	public String showAddingField(ModelMap model) {
		List<DrinkBean> drinks = drinkService.getAllDrinks();

		model.put("drinks", drinks);
		return "chooseDrinkToUpdate";
	}
	
	@RequestMapping(value= "/chooseDrinkToUpdate" , method = {RequestMethod.GET, RequestMethod.POST})
	public String sauceChoice(ModelMap model,@RequestParam Integer id, @RequestParam BigDecimal price) {
		
		drinkService.updateDrink(id, price);
		
		return "adminMenu";
	}
}
