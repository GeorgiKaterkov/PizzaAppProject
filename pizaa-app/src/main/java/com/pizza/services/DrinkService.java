package com.pizza.services;

import java.math.BigDecimal;
import java.util.List;

import com.pizza.beans.DrinkBean;

public interface DrinkService {
	
	List<DrinkBean> getAllDrinks();

	void addNewDrink(String name, BigDecimal price);

}
