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
public class DeletePizzaController {

	@Autowired
	PizzaService pizzaService;

	@RequestMapping(value = "/deletePizza", method = { RequestMethod.GET, RequestMethod.POST })
	public String showAddingField(ModelMap model) {
		List<PizzaBean> pizzas = (List<PizzaBean>) pizzaService.getAllPizzas();

		model.put("pizzas", pizzas);
		return "choosePizzaToDelete";
	}

	@RequestMapping(value= "/choosePizzaToDelete" , method = {RequestMethod.GET, RequestMethod.POST})
	public void pizzaChoice(ModelMap model,@RequestParam String namePizza) {
		
			pizzaService.deletePizza(namePizza);
	}
}
