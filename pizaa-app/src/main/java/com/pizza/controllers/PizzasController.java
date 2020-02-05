package com.pizza.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pizza.beans.PizzaBean;
import com.pizza.beans.PizzaIdNameBean;
import com.pizza.beans.PizzaJspBean;
import com.pizza.model.Pizza;
import com.pizza.services.PizzaService;
import com.pizza.shoppingcard.ShoppingCart;

@Controller
public class PizzasController {

	@Autowired
	PizzaService pizzaService;

	@RequestMapping(value = "/pizzas", method = { RequestMethod.GET, RequestMethod.POST })
	public String showAllPizzas(ModelMap model) {

		List<PizzaBean> pizzas = (List<PizzaBean>) pizzaService.getAllPizzas();
		model.put("pizzas", pizzas);
		return "allPizzas";
	}

	@RequestMapping(value = "/basket/pizza", method = { RequestMethod.GET, RequestMethod.POST })
	public String addPizzaToBasket(Model model, @RequestParam String namePizza) {

		List<PizzaBean> pizzaOptions = (List<PizzaBean>) pizzaService.getOptionsByPizzaName(namePizza);
		List<PizzaIdNameBean> pizzaVariaty = new ArrayList<PizzaIdNameBean>();
		for (PizzaBean pizzaBean : pizzaOptions) {
			PizzaIdNameBean bean = new PizzaIdNameBean();
			bean.setPizzaId(pizzaBean.getPizzaId());
			bean.setName(pizzaBean.getNamePizza() + "/" + pizzaBean.getPizzaSize() + "/" + pizzaBean.getPrice());
			pizzaVariaty.add(bean);
		}
		model.addAttribute("pizzaVariaty", pizzaVariaty);
		model.addAttribute("bean", new PizzaBean());		
		return "sizePriceAdd";
	}

	/*
	 * @RequestMapping(value = "/basket/addingPizza", method = RequestMethod.POST)
	 * public String toShoppingCart(ModelMap model, @ModelAttribute("bean")
	 * PizzaBean bean) {
	 * 
	 * System.out.println(bean.getPizzaId() + " " + bean.getQuantity());
	 * 
	 * List<PizzaBean> listPizzas =
	 * pizzaService.toShoppingCart(bean.getPizzaId(),bean.getQuantity());
	 * 
	 * model.put("listPizzas", listPizzas);
	 * 
	 * return "shoppingCart"; }
	 */
}






