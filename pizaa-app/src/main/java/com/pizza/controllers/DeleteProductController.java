package com.pizza.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeleteProductController {

	@RequestMapping(value= "/delete" , method = RequestMethod.GET)
	public String showProducts(ModelMap model) {
		return "typeOfProductToDelete";
	}
}
