package com.pizza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pizza.beans.PizzaBean;
import com.pizza.beans.SauceBean;
import com.pizza.services.SauceService;

@Controller
public class DeleteSauceController {
	
	@Autowired
	SauceService sauceService;
	
	@RequestMapping(value = "/deleteSauce", method = { RequestMethod.GET, RequestMethod.POST })
	public String showAddingField(ModelMap model) {
		List<SauceBean> sauces = sauceService.getAllSauces();

		model.put("sauces", sauces);
		return "chooseSauceToDelete";
	}
	
	@RequestMapping(value= "/chooseSauceToDelete" , method = {RequestMethod.GET, RequestMethod.POST})
	public void pizzaChoice(ModelMap model,@RequestParam Integer id) {
		
		sauceService.deleteSauce(id);
	}
	

}
