package com.pizza.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.pizza.services.UserService;

@Controller
public class UserToAdminController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/userToAdmin", method =RequestMethod.GET)
	public String showProcessedOrders(ModelMap model) {		
		return "changeUserToAdmin";
	}
	
	@RequestMapping(value= "/changeUserToAdmin" , method = {RequestMethod.GET, RequestMethod.POST})
	public void pizzaChoice(ModelMap model, @RequestParam String username) {
		
				userService.changeUserToAdmin(username);
}
}
