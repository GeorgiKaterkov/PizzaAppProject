package com.pizza.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pizza.beans.PizzaBean;
import com.pizza.dao.PizzaDao;
import com.pizza.model.Pizza;
import com.pizza.model.PizzaSizeEnum;
import com.pizza.shoppingcard.ShoppingCart;

@Service
public class PizzaServiceImpl implements PizzaService {
	private PizzaSizeEnum pizzaSize;
	private Pizza pizza;
	Scanner scan;

	@Autowired
	private PizzaDao pizzaDAO;

	@Override
	public PizzaBean toShoppingCart(Integer id, Integer quantity) {
		Pizza pizza = pizzaDAO.get(id);
		PizzaBean bean = new PizzaBean();				
		bean.setNamePizza(pizza.getNamePizza());
		bean.setPizzaSize(pizza.getPizzaSize().toString());
		bean.setPrice(pizza.getPrice());
		bean.setQuantity(quantity);		
		return bean;
	}

	@Override
	public Collection<PizzaBean> getAllPizzas() {
		Collection<String> pizzas = pizzaDAO.getAllByDistinctName();
		List<PizzaBean> listPizzaBean = new ArrayList<>();
		for (String string : pizzas) {
			PizzaBean bean = new PizzaBean();
			bean.setNamePizza(string);
			listPizzaBean.add(bean);
		}
		/*
		 * List<PizzaBean> listPizzaBean = new ArrayList<>(); for(String pizza : pizzas)
		 * { PizzaBean bean = new PizzaBean(); bean.setPizzaId(pizza.getId());
		 * bean.setNamePizza(pizza.getNamePizza());
		 * bean.setPizzaSize(pizza.getPizzaSize().getName());
		 * bean.setPrice(pizza.getPrice()); listPizzaBean.add(bean); }
		 */
		return listPizzaBean;
	}

	@Override
	public Collection<PizzaBean> getAllPizzasForDeleting() {
		Collection<Pizza> pizzas = pizzaDAO.getAll();
		List<PizzaBean> listPizzaBean = new ArrayList<>();
		for (Pizza pizza : pizzas) {
			PizzaBean bean = new PizzaBean();
			bean.setPizzaId(pizza.getId());
			bean.setNamePizza(pizza.getNamePizza());
			bean.setPizzaSize(pizza.getPizzaSize().toString());
			listPizzaBean.add(bean);
		}
		return listPizzaBean;
	}

	@Override
	public Collection<PizzaBean> getOptionsByPizzaName(String name) {
		List<PizzaBean> optionListForPizza = new ArrayList<>();
		Collection<Pizza> optionForPizza = pizzaDAO.getAllBy(name);
		for (Pizza pizza : optionForPizza) {
			PizzaBean bean = new PizzaBean();
			bean.setPizzaId(pizza.getId());
			bean.setNamePizza(pizza.getNamePizza());
			bean.setPizzaSize(pizza.getPizzaSize().toString());
			bean.setPrice(pizza.getPrice());
			optionListForPizza.add(bean);
		}
		return optionListForPizza;
	}

	// USER
	public Pizza choosePizza() {
		System.out.println("Enter your option: ");
		scan = new Scanner(System.in);
		int choice = scan.nextInt();
		Pizza pizza = pizzaDAO.get(choice);
		System.out.println("Your choice is: " + pizza.getNamePizza() + " - " + pizza.getPizzaSize());
		return pizza;
	}

	@Override
	public void addNewPizza(String name, String size, BigDecimal price) {

		if (size.equals(PizzaSizeEnum.SMALL.getName())) {
			pizza = new Pizza(name, pizzaSize.SMALL, price);
		}
		if (size.equals(PizzaSizeEnum.MEDIUM.getName())) {
			pizza = new Pizza(name, pizzaSize.MEDIUM, price);
		}
		if (size.equals(PizzaSizeEnum.LARGE.getName())) {
			pizza = new Pizza(name, pizzaSize.LARGE, price);
		}
		System.out.println("After IF");
		pizzaDAO.save(pizza);
	}

	@Override
	public void deletePizza(Integer id) {
		pizzaDAO.delete(id);
	}

	@Override
	public void updatePizza(Integer id, BigDecimal price) {
		pizzaDAO.update(id, price);
	}

	@Override
	public PizzaBean returnBeanToUpdate(Integer id) {
		Pizza pizza = pizzaDAO.get(id);
		PizzaBean bean = new PizzaBean();
		bean.setPizzaId(pizza.getId());
		bean.setNamePizza(pizza.getNamePizza());
		bean.setPizzaSize(pizza.getPizzaSize().toString());
		bean.setPrice(pizza.getPrice());
		return bean;
	}
}
