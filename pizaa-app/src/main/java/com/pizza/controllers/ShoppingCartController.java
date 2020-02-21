package com.pizza.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.pizza.beans.DrinkBean;
import com.pizza.beans.PizzaBean;
import com.pizza.beans.SauceBean;
import com.pizza.model.ShoppingCart;
import com.pizza.model.ShoppingCartDiscard;
import com.pizza.model.User;
import com.pizza.services.DrinkService;
import com.pizza.services.PizzaService;
import com.pizza.services.SauceService;
import com.pizza.services.ShoppingCartService;

@Controller
@SessionAttributes("shoppingCart")
public class ShoppingCartController {

	@Autowired
	ShoppingCartService cartService;
	@Autowired
	PizzaService pizzaService;
	@Autowired
	SauceService sauceService;
	@Autowired
	DrinkService drinkService;

	@RequestMapping(value = "/basket/addingPizza", method = RequestMethod.POST)
	public ModelAndView toShoppingCart(final Model model, @ModelAttribute("shoppingCart") ShoppingCart shoppingCart,
			@ModelAttribute("loggedUser") User loggedUser,
			@ModelAttribute("bean") PizzaBean bean) {

		System.out.println(bean.getPizzaId() + bean.getNamePizza() + bean.getQuantity());
		ModelAndView mv = new ModelAndView("userMenu");
		if (shoppingCart != null) {
			PizzaBean pizzaBean = pizzaService.toShoppingCart(bean.getPizzaId(),bean.getQuantity());
			shoppingCart.getPizzas().add(pizzaBean);			
			model.addAttribute("shoppingCart", shoppingCart);
			mv.addObject("shoppingCart", shoppingCart);
		} else {
			ShoppingCart cart = new ShoppingCart();
			PizzaBean pizzaBean = pizzaService.toShoppingCart(bean.getPizzaId(),bean.getQuantity());
			cart.getPizzas().add(pizzaBean);					
			model.addAttribute("shoppingCart", cart);
			mv.addObject("shoppingCart", cart);
		}

		return mv;
	}

	@RequestMapping(value = "/sauceChoice", method = RequestMethod.POST)
	public ModelAndView sauceChoice(final Model model, @ModelAttribute("shoppingCart") ShoppingCart shoppingCart,
			@ModelAttribute("loggedUser") User loggedUser,
			@ModelAttribute("bean") SauceBean bean) {
		System.out.println(bean.getId() + " " + bean.getQuantity());
		ModelAndView mv = new ModelAndView("userMenu");

		if (shoppingCart != null) {
			SauceBean sauceBean = sauceService.toShoppingCart(bean.getId(), bean.getQuantity());
			shoppingCart.getSauces().add(sauceBean);			
			model.addAttribute("shoppingCart", shoppingCart);
			mv.addObject("shoppingCart", shoppingCart);
		} else {
			ShoppingCart cart = new ShoppingCart();
			SauceBean sauceBean = sauceService.toShoppingCart(bean.getId(), bean.getQuantity());
			cart.getSauces().add(sauceBean);					
			model.addAttribute("shoppingCart", cart);
			mv.addObject("shoppingCart", cart);
		}

		return mv;
	}

	@RequestMapping(value = "/drinkChoice", method = RequestMethod.POST)
	public ModelAndView drinkChoice(ModelMap model, @ModelAttribute("shoppingCart") ShoppingCart shoppingCart,
			@ModelAttribute("loggedUser") User loggedUser,
			@ModelAttribute("bean") DrinkBean bean) {
		System.out.println(bean.getId() + " " + bean.getQuantity());
		ModelAndView mv = new ModelAndView("userMenu");

		if (shoppingCart != null) {
			DrinkBean drinkBean = drinkService.toShoppingCart(bean.getId(), bean.getQuantity());
			shoppingCart.getDrinks().add(drinkBean);			
			model.addAttribute("shoppingCart", shoppingCart);
			mv.addObject("shoppingCart", shoppingCart);
		} else {
			ShoppingCart cart = new ShoppingCart();
			DrinkBean drinkBean = drinkService.toShoppingCart(bean.getId(), bean.getQuantity());
			cart.getDrinks().add(drinkBean);					
			model.addAttribute("shoppingCart", cart);
			mv.addObject("shoppingCart", cart);
		}

		return mv;
	}

	@RequestMapping(value = "/shoppingCart-detail-page", method = RequestMethod.GET)
	public ModelAndView viewShoppingCartDetails(Model model, @ModelAttribute("shoppingCart") ShoppingCart shoppingCart,
			@SessionAttribute("loggedUser") User loggedUser) {
		
		ModelAndView mv = new ModelAndView("shoppingCart");
		
		if (shoppingCart != null) {
			model.addAttribute("shoppingCart", shoppingCart);
			List<PizzaBean> pizzas = shoppingCart.getPizzas();
			BigDecimal sum = new BigDecimal("0");
			for(PizzaBean bean : pizzas) {
				for(int i=0;i<bean.getQuantity();i++) {				
				sum = sum.add(bean.getPrice());
				}
			}
			model.addAttribute("pizzas", pizzas);
			List<SauceBean> sauces = shoppingCart.getSauces();			
			for(SauceBean bean : sauces) {
				for(int i=0;i<bean.getQuantity();i++) {				
					sum = sum.add(bean.getPrice());
					}
			}
			model.addAttribute("sauces", sauces);
			List<DrinkBean> drinks = shoppingCart.getDrinks();			
			for(DrinkBean bean : drinks) {
				for(int i=0;i<bean.getQuantity();i++) {				
					sum = sum.add(bean.getPrice());
					}
			}			
			model.addAttribute("drinks", drinks);
			model.addAttribute("bean", new PizzaBean());			
			model.addAttribute("sum", sum);			
			model.addAttribute("loggedUser",loggedUser);
			mv.addObject("loggedUser", loggedUser);
			
		} else {
			model.addAttribute("shoppingCart", new ShoppingCart());			
			List<PizzaBean> pizzas = new ArrayList<PizzaBean>();
			model.addAttribute("pizzas", pizzas);
			List<SauceBean> sauces = new ArrayList<SauceBean>();
			model.addAttribute("sauces", sauces);
			List<DrinkBean> drinks = new ArrayList<DrinkBean>();
			model.addAttribute("drinks", drinks);
			model.addAttribute("bean", new PizzaBean());
		}

		return mv;
	}

	
	  @ModelAttribute("shoppingCart") public ShoppingCart shoppingCart() { return
	  new ShoppingCart(); }
	  
	/*
	 * @ModelAttribute("loggedUser") public User loggedUser() { return new User(); }
	 */ 
	 

}
