package com.pizza.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pizza.beans.DrinkBean;
import com.pizza.beans.DrinkIdNameBean;
import com.pizza.beans.SauceBean;
import com.pizza.beans.SauceIdNameBean;
import com.pizza.services.DrinkService;

@Controller
public class DrinksController {

	@Autowired
	DrinkService drinkService;

	@RequestMapping(value = "/drinks", method = { RequestMethod.GET, RequestMethod.POST })
	public String showAllDrinks(Model model) {

		List<DrinkBean> drinks = drinkService.getAllDrinks();
		List<DrinkIdNameBean> drinkVariaty = new ArrayList<DrinkIdNameBean>();
		for (DrinkBean drinkBean : drinks) {
			DrinkIdNameBean bean = new DrinkIdNameBean();
			bean.setDrinkId(drinkBean.getId());
			bean.setName(drinkBean.getDrinkName() + "/" + drinkBean.getPrice());
			drinkVariaty.add(bean);
		}
		model.addAttribute("drinkVariaty", drinkVariaty);
		model.addAttribute("bean", new DrinkBean());

		return "allDrinks";
	}

	/*
	 * @RequestMapping(value = "/drinkChoice", method = RequestMethod.POST) public
	 * String drinkChoice(ModelMap model, @ModelAttribute("bean") DrinkBean bean) {
	 * System.out.println(bean.getId() + " " + bean.getQuantity());
	 * 
	 * return "allSauces"; }
	 */

}
