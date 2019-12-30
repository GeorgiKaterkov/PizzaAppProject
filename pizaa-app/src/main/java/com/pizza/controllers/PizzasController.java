package com.pizza.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pizza.beans.PizzaBean;
import com.pizza.model.Pizza;
import com.pizza.services.PizzaService;

@Controller
public class PizzasController {
	
	@Autowired
	PizzaService pizzaService;
	
	@RequestMapping(value= "/pizzas" , method = { RequestMethod.GET, RequestMethod.POST })
    public String showAllPizzas(ModelMap model){
		
		List<PizzaBean> pizzas = (List<PizzaBean>) pizzaService.getAllPizzas();
		
		model.put("pizzas", pizzas);
        return "allPizzas";
    }
	

}
