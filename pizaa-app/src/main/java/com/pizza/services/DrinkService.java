package com.pizza.services;

import java.math.BigDecimal;
import java.util.List;

import com.pizza.beans.DrinkBean;

public interface DrinkService {
	
	List<DrinkBean> getAllDrinks();

	void addNewDrink(String name, BigDecimal price);

	void deleteDrink(Integer id);

	void updateDrink(Integer id, BigDecimal price);

	DrinkBean toShoppingCart(Integer id, Integer quantity);

}
