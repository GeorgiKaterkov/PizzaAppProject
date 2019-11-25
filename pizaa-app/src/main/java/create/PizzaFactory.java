package create;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Order;

import org.hibernate.dialect.Database;

import configuration.JPAConfiguration;
import entities.Pizza;
import entities.PizzaSizeEnum;
import dao.PizzaDAO;
public class PizzaFactory {
	private PizzaSizeEnum pizzaSize;
	private Pizza pizza;
    private PizzaDAO pizzaDAO ;
    Scanner scan;
    
    public PizzaFactory(){
    	pizzaDAO = new PizzaDAO();
    };
	//USER
	public void getAllPizzas(){	
		
		System.out.println("Menu: ");
		Collection<Pizza> pizzas = pizzaDAO.getAll();
		for(Pizza pizza : pizzas)
		System.out.println(pizza.toString());	
		
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
	//ADMIN	
	public void addNewPizza(){
		scan = new Scanner(System.in);
		System.out.println("Enter pizza name: ");
        String name = scan.next();
        System.out.println("Enter pizza price: ");
        BigDecimal price = scan.nextBigDecimal();
        System.out.println("Enter pizza size: ");
        String size = scan.next();
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
	//ADMIN
	public void deletePizza(){
		scan = new Scanner(System.in);
		System.out.println("Enter pizza id: ");
		int choice = scan.nextInt();
		System.out.println("Choice sended");
		pizzaDAO.delete(choice);		
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
