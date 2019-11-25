package startmenu;

import java.math.BigDecimal;
import java.util.Scanner;
import create.DrinkFactory;
import create.PizzaFactory;
import create.SauceFactory;
import dao.PizzaDAO;
import entities.Pizza;
import entities.User;
import entities.PizzaSizeEnum;

public class StartMenuAdmin {
	private Pizza pizza;
	private PizzaSizeEnum pizzaSize;
	private PizzaDAO pizzaDAO;
	private User user;
	Scanner scan;

	public StartMenuAdmin(User user) {
		this.user = user;
	}

	public void mainMenu() {
		System.out.println("====================");
		System.out.println("| 1.Add new product|");
		System.out.println("| 2.Delete product |");
		System.out.println("| 3.Update product |");
		System.out.println("====================");
		System.out.println("  Enter option:");
		scan = new Scanner(System.in);
		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			addNewProduct();
			mainMenu();
			break;
		case 2:
			deleteProduct();
			mainMenu();
			break;
		case 3:
			updateProduct();
			mainMenu();
			break;
		}
	}

	// ADD
	public void addNewProduct() {
		System.out.println("==============");
		System.out.println("| 1.Add pizza|");
		System.out.println("| 2.Add sauce|");
		System.out.println("| 3.Add drink|");
		System.out.println("==============");
		System.out.println(" Enter option:");
		scan = new Scanner(System.in);
		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			PizzaFactory pf = new PizzaFactory();
			pf.addNewPizza();
			break;
		case 2:
			SauceFactory sf = new SauceFactory();
			sf.addNewSauce();
			break;
		case 3:
			DrinkFactory df = new DrinkFactory();
			df.addNewDrink();
			break;

		}
	}

	// DELETE
	public void deleteProduct() {
		System.out.println("=================");
		System.out.println("| 1.Delete pizza|");
		System.out.println("| 2.Delete sauce|");
		System.out.println("| 3.Delete drink|");
		System.out.println("=================");
		System.out.println(" Enter option:");
		scan = new Scanner(System.in);
		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			PizzaFactory pf = new PizzaFactory();
			pf.getAllPizzas();
			pf.deletePizza();
			break;
		case 2:
			SauceFactory sf = new SauceFactory();
			sf.getAllSauces();
			sf.deleteSauce();
			break;
		case 3:
			DrinkFactory df = new DrinkFactory();
			df.getAllDrinks();
			df.deleteDrink();
			break;
		}
	}

	// UPDATE(price)
	public void updateProduct() {
		System.out.println("=================");
		System.out.println("| 1.Update pizza|");
		System.out.println("| 2.Update sauce|");
		System.out.println("| 3.Update drink|");
		System.out.println("=================");
		System.out.println(" Enter option:");
		scan = new Scanner(System.in);
		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			PizzaFactory pf = new PizzaFactory();
			pf.getAllPizzas();
			pf.updatePizza();
			break;
		case 2:
			SauceFactory sf = new SauceFactory();
			sf.getAllSauces();
			sf.updateSauce();
			break;
		case 3:
			DrinkFactory df = new DrinkFactory();
			df.getAllDrinks();
			df.updateSauce();
			break;
		}
	}
}
