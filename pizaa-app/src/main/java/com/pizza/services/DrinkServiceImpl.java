package com.pizza.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.beans.DrinkBean;
import com.pizza.beans.PizzaBean;
import com.pizza.dao.DrinkDao;
import com.pizza.dao.DrinkDaoImpl;
import com.pizza.exceptions.InputMismatchPriceException;
import com.pizza.model.Drink;
import com.pizza.model.Pizza;
@Service
public class DrinkServiceImpl implements DrinkService {
	private Drink drink;
	Scanner scan;
	@Autowired
	DrinkDao drinkDAO;
	
	
	@Override
	public DrinkBean toShoppingCart(Integer id, Integer quantity) {
		Drink drink = drinkDAO.get(id);
		DrinkBean bean = new DrinkBean();	
		bean.setId(drink.getId());
		bean.setDrinkName(drink.getDrinkName());
		bean.setPrice(drink.getPrice());		
		bean.setQuantity(quantity);		
		return bean;
	}

	@Override
	public List<DrinkBean> getAllDrinks() {
		List<DrinkBean> listDrinksBean = new ArrayList<>();
		Collection<Drink> drinks = drinkDAO.getAll();
		for (Drink drink : drinks) {
			DrinkBean bean = new DrinkBean();
			bean.setId(drink.getId());
			bean.setDrinkName(drink.getDrinkName());
			bean.setPrice(drink.getPrice());
			listDrinksBean.add(bean);		
			}
		return listDrinksBean;
	}

	// user
	public Drink chooseDrink() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Option: ");
		int choice = scan.nextInt();
		Drink drink = drinkDAO.get(choice);
		System.out.println("Your choice is: " + drink.getDrinkName());
		return drink;
	}

	@Override
	public void addNewDrink(String name, BigDecimal price) {		
		drink = new Drink(name, price);
		drinkDAO.save(drink);
		
	}

	@Override
	public void deleteDrink(Integer id) {		
		drinkDAO.delete(id);
	}

	@Override
	public void updateDrink(Integer id,BigDecimal price) {		
		drinkDAO.update(id,price);
	}
}
