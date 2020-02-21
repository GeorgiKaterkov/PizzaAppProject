package com.pizza.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.pizza.beans.DrinkBean;
import com.pizza.beans.PizzaBean;
import com.pizza.beans.SauceBean;
import com.pizza.model.ShoppingCart;
import com.pizza.model.User;
import com.pizza.services.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;

	@RequestMapping(value = "/basketCart", method = RequestMethod.POST)
	public ModelAndView orderProducts( final Model model, @SessionAttribute("shoppingCart") ShoppingCart shoppingCart,
			@SessionAttribute("loggedUser") User loggedUser,WebRequest request, SessionStatus status) {		
			
		ModelAndView mv = new ModelAndView("userMenu");
		List<PizzaBean> pizzas = shoppingCart.getPizzas();
		List<SauceBean> sauces = shoppingCart.getSauces();
		List<DrinkBean> drinks = shoppingCart.getDrinks();
		Set<PizzaBean>setOfPizzas = new HashSet<PizzaBean>(pizzas);
		Set<SauceBean>setOfSauces = new HashSet<SauceBean>(sauces);
		Set<DrinkBean>setOfDrinks = new HashSet<DrinkBean>(drinks);
		System.out.println("PASSED");
		orderService.makeOrder(setOfPizzas, setOfSauces, setOfDrinks, loggedUser);
		System.out.println("SENDED");
		status.setComplete();		
		request.removeAttribute("shoppingCart", WebRequest.SCOPE_SESSION);
		return mv;
	}

}
