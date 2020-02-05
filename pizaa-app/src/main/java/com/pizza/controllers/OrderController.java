package com.pizza.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pizza.beans.PizzaBean;
import com.pizza.model.ShoppingCart;
import com.pizza.model.User;
import com.pizza.services.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "/basketCart", method = RequestMethod.POST)
	public ModelAndView orderProducts(final Model model, @ModelAttribute("loggedUser") User loggedUser,
			@ModelAttribute("shoppingCart") ShoppingCart shoppingCart,
			@ModelAttribute("bean") PizzaBean bean) {

		ModelAndView mv = new ModelAndView("userMenu");
		if (shoppingCart != null) {			
			shoppingCart.getPizzas();	
			shoppingCart.getSauces();
			shoppingCart.getDrinks();			
			loggedUser.getId();
			System.out.println(shoppingCart.getPizzas().toString()+shoppingCart.getSauces().toString()+shoppingCart.getDrinks().toString()+loggedUser.getId());
		} else {
			/*
			 * ShoppingCart cart = new ShoppingCart(); PizzaBean pizzaBean =
			 * pizzaService.toShoppingCart(bean.getPizzaId(),bean.getQuantity());
			 * cart.getPizzas().add(pizzaBean); model.addAttribute("shoppingCart", cart);
			 * mv.addObject("shoppingCart", cart);
			 */
		}
				

		return mv;
	}
	
	@ModelAttribute("loggedUser") public User loggedUser() { return
			  new User(); }
}
