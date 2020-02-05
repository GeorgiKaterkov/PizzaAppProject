package com.pizza.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pizza.beans.PizzaBean;
import com.pizza.services.PizzaService;

@Controller
public class UpdatePizzaController {

	@Autowired
	PizzaService pizzaService;
	
	Integer id = 0;
	
	@RequestMapping(value = "/updatePizza", method = { RequestMethod.GET, RequestMethod.POST })
	public String showAddingField(ModelMap model) {
		List<PizzaBean> pizzas = (List<PizzaBean>) pizzaService.getAllPizzasForDeleting();//UPDATING NOT DELETING

		model.put("pizzas", pizzas);
		return "choosePizzaToUpdate";
	}
	
	@RequestMapping(value= "/choosePizzaToUpdate" , method = {RequestMethod.GET, RequestMethod.POST})
	public String pizzaChoice(ModelMap model,@RequestParam Integer pizzaId) {
		id = pizzaId;
		PizzaBean bean = pizzaService.returnBeanToUpdate(pizzaId);
		
		model.put("bean", bean);
		return "UpdatePizzaPrice";
	}
	
	@RequestMapping(value= "/updatePizzaPrice" , method = {RequestMethod.GET, RequestMethod.POST})
	public String pizzaChoice(ModelMap model,@RequestParam BigDecimal price) {
		System.out.println(id);
		pizzaService.updatePizza(id, price);
		return "adminMenu";		
	}
}
