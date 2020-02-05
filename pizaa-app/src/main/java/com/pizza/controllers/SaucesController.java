package com.pizza.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pizza.beans.PizzaBean;
import com.pizza.beans.PizzaIdNameBean;
import com.pizza.beans.PizzaJspBean;
import com.pizza.beans.SauceBean;
import com.pizza.beans.SauceIdNameBean;
import com.pizza.beans.SauceJspBean;
import com.pizza.services.SauceService;

@Controller
public class SaucesController {
    @Autowired
	SauceService sauceService;
    
    @RequestMapping(value= "/sauces" , method = { RequestMethod.GET, RequestMethod.POST })
    public String showAllSauces(Model model) {
    	List<SauceBean> sauces = sauceService.getAllSauces();
    	List<SauceIdNameBean> sauceVariaty = new ArrayList<SauceIdNameBean>();
		for (SauceBean sauceBean : sauces) {
			SauceIdNameBean bean = new SauceIdNameBean();
			bean.setSauceId(sauceBean.getId());
			bean.setName(sauceBean.getSauceName() + "/" + sauceBean.getPrice());
			sauceVariaty.add(bean);
		}    	
    	model.addAttribute("sauceVariaty", sauceVariaty); 
    	model.addAttribute("bean", new SauceBean());
    	
		return "allSauces";    	
    }
    
	/*
	 * @RequestMapping(value= "/sauceChoice" , method = RequestMethod.POST) public
	 * String sauceChoice(ModelMap model,@ModelAttribute("bean") SauceBean bean) {
	 * System.out.println(bean.getId() + " " + bean.getQuantity());
	 * 
	 * return "allSauces"; }
	 */
}
