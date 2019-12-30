package com.pizza.services;

import java.math.BigDecimal;
import java.util.List;

import com.pizza.beans.SauceBean;

public interface SauceService {

	List<SauceBean> getAllSauces();

	void addNewSauce(String name, BigDecimal price);
	
}
