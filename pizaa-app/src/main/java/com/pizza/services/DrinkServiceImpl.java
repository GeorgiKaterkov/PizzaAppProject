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
import com.pizza.dao.DrinkDao;
import com.pizza.dao.DrinkDaoImpl;
import com.pizza.exceptions.InputMismatchPriceException;
import com.pizza.model.Drink;
@Service
public class DrinkServiceImpl implements DrinkService {
	private Drink drink;
	Scanner scan;
	@Autowired
	DrinkDao drinkDAO;
	

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

	// admin
	public void deleteDrink() {
		scan = new Scanner(System.in);
		System.out.println("Enter drink id: ");
		int choice = scan.nextInt();
		drinkDAO.delete(choice);
	}

	// ADMIN
	public void updateDrink() {
		scan = new Scanner(System.in);
		System.out.println("Enter drink id: ");
		int choice = scan.nextInt();
		System.out.println("Choice sended");
		drinkDAO.update(choice);
	}
}
