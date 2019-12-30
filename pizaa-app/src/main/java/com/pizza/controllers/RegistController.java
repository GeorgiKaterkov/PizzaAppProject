package com.pizza.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pizza.services.UserRegistration;

@Controller
public class RegistController {
	
	@Autowired
	UserRegistration userRegister;
	
	
	@RequestMapping(value= "/register", method = RequestMethod.GET)
	public String showRegisterPage(ModelMap model){
        return "register";
    }	
	
	@RequestMapping(value= "/register", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String username, @RequestParam String password){

	 userRegister.makeRegistration(username, password);
        return "redirect:/login";
    }

}
