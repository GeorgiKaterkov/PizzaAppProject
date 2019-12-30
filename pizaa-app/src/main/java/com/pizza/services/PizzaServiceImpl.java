package com.pizza.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pizza.beans.PizzaBean;
import com.pizza.dao.PizzaDao;
import com.pizza.model.Pizza;
import com.pizza.model.PizzaSizeEnum;
@Service
public class PizzaServiceImpl implements PizzaService{
	private PizzaSizeEnum pizzaSize;
	private Pizza pizza;    
    Scanner scan;
    
    @Autowired
    private PizzaDao pizzaDAO ;
    
    
	@Override
	public Collection<PizzaBean> getAllPizzas(){	
		List<PizzaBean> listPizzaBean = new ArrayList<>();
		Collection<Pizza> pizzas = pizzaDAO.getAll();
		for(Pizza pizza : pizzas) {
			PizzaBean bean = new PizzaBean();
			bean.setPizzaId(pizza.getId());
			bean.setNamePizza(pizza.getNamePizza());
			bean.setPizzaSize(pizza.getPizzaSize().getName());
			bean.setPrice(pizza.getPrice());
			listPizzaBean.add(bean);
		}
		return listPizzaBean;			
	}
	//USER
	public Pizza choosePizza(){		
		System.out.println("Enter your option: ");
		scan = new Scanner(System.in);
		int choice = scan.nextInt();
		Pizza pizza = pizzaDAO.get(choice);
		System.out.println("Your choice is: " + pizza.getNamePizza() + " - " + pizza.getPizzaSize());
		return pizza;		
	}
	@Override
	public void addNewPizza(String name,String size, BigDecimal price){
		
        if(size.equals(PizzaSizeEnum.SMALL.getName())){
       	 pizza = new Pizza(name,pizzaSize.SMALL,price);        	 
        }
        if(size.equals(PizzaSizeEnum.MEDIUM.getName())){
       	 pizza = new Pizza(name,pizzaSize.MEDIUM,price);
        }
        if(size.equals(PizzaSizeEnum.LARGE.getName())){
       	 pizza = new Pizza(name,pizzaSize.LARGE,price);
        }		         		         
        System.out.println("After IF");        
        pizzaDAO.save(pizza);
	}
	@Override
	public void deletePizza(String name){		
		pizzaDAO.delete(name);		
	}
	//ADMIN
	public void updatePizza(){
		scan = new Scanner(System.in);
		System.out.println("Enter pizza id: ");
		int choice = scan.nextInt();
		System.out.println("Choice sended");
		pizzaDAO.update(choice);
	}
}
