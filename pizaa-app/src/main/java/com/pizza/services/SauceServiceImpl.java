package com.pizza.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.beans.PizzaBean;
import com.pizza.beans.SauceBean;
import com.pizza.dao.SauceDao;
import com.pizza.dao.SauceDaoImpl;
import com.pizza.model.Pizza;
import com.pizza.model.Sauce;

@Service
public class SauceServiceImpl implements SauceService{
	private Sauce sauce;
	Scanner scan;
	
	@Autowired
	public SauceDao sauceDAO;	

	@Override
	public SauceBean toShoppingCart(Integer id, Integer quantity) {
		Sauce sauce = sauceDAO.get(id);
		SauceBean bean = new SauceBean();
		bean.setId(sauce.getId());
		bean.setSauceName(sauce.getSauceName());
		bean.setPrice(sauce.getPrice());		
		bean.setQuantity(quantity);		
		return bean;
	}
	
	@Override
	public List<SauceBean> getAllSauces() {
		List<SauceBean> listSauceBean = new ArrayList<>();
		Collection<Sauce> sauces = sauceDAO.getAll();
		for (Sauce sauce : sauces) {
			SauceBean bean = new SauceBean();
			bean.setId(sauce.getId());
			bean.setSauceName(sauce.getSauceName());
			bean.setPrice(sauce.getPrice());
			listSauceBean.add(bean);
		}
		return listSauceBean;
	}

	// USER
	public Sauce chooseSauce() {
		scan = new Scanner(System.in);
		System.out.println("Enter option: ");
		int choice = scan.nextInt();
		Sauce sauce = sauceDAO.get(choice);
		System.out.println("Your choice is: " + sauce.getSauceName());
		return sauce;
	}

	@Override
	public void addNewSauce(String name, BigDecimal price) {		
		sauce = new Sauce(name, price);
		sauceDAO.save(sauce);
	}

	@Override
	public void deleteSauce(Integer id) {		
		sauceDAO.delete(id);
	}

	@Override
	public void updateSauce(Integer id, BigDecimal price) {		
		sauceDAO.update(id,price);
	}
}
