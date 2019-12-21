package create;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Scanner;

import javax.persistence.PersistenceException;

import dao.DrinkDao;
import dao.DrinkDaoImpl;
import entities.Drink;
import exceptions.InputMismatchPriceException;

public class DrinkService {
	private Drink drink;
	Scanner scan;
	DrinkDao drinkDAO;

	public DrinkService() {
		drinkDAO = new DrinkDaoImpl();
	}

	// user
	public void getAllDrinks() {
		System.out.println("Menu: ");
		Collection<Drink> drinks = drinkDAO.getAll();
		for (Drink drink : drinks) {
			System.out.println(drink.toString());
		}
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

	// admin
	public void addNewDrink() {
		try {
		scan = new Scanner(System.in);
		System.out.println("Enter drink name: ");
		String name = scan.next();
		System.out.println("Enter drink price: ");
		BigDecimal price = scan.nextBigDecimal();
		drink = new Drink(name, price);
		drinkDAO.save(drink);
		}catch(PersistenceException e) {
			throw new InputMismatchPriceException(e.getMessage());
		}
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
