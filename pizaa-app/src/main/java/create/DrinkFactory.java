package create;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Scanner;

import dao.DrinkDAO;
import entities.Drink;

public class DrinkFactory {	
	private Drink drink;
	Scanner scan;
	DrinkDAO drinkDAO;
	
	public DrinkFactory(){
		drinkDAO = new DrinkDAO();
	}
	//user
	public void getAllDrinks(){		
		System.out.println("Menu: ");		
		Collection<Drink> drinks = drinkDAO.getAll();
		for(Drink drink : drinks){
			System.out.println(drink.toString());
		}
	}
	//user
	public Drink chooseDrink(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Option: ");
		int choice = scan.nextInt();
		Drink drink = drinkDAO.get(choice);
		System.out.println("Your choice is: " + drink.getDrinkName());
		return drink;		
	}
    //admin
	public void addNewDrink(){
		scan = new Scanner(System.in);
		System.out.println("Enter drink name: ");
        String name = scan.next();
        System.out.println("Enter drink price: ");
        BigDecimal price = scan.nextBigDecimal();
        drink = new Drink(name,price);
        drinkDAO.save(drink);
	}
	//admin
	public void deleteDrink(){
		scan = new Scanner(System.in);
		System.out.println("Enter drink id: ");
		int choice = scan.nextInt();
		drinkDAO.delete(choice);
	}
}
