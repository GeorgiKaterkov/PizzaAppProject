package com.pizza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pizza.beans.SauceBean;
import com.pizza.services.SauceService;

@Controller
public class SaucesController {
    @Autowired
	SauceService sauceService;
    
    @RequestMapping(value= "/sauces" , method = { RequestMethod.GET, RequestMethod.POST })
    public String showAllSauces(ModelMap model) {
    	List<SauceBean> sauces = sauceService.getAllSauces();
    	model.put("sauces", sauces);
    	
		return "allSauces";    	
    }
}
