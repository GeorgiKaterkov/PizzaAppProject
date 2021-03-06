package startmenu;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.pizza.dao.OrderDao;
import com.pizza.dao.OrderDaoImpl;
import com.pizza.exceptions.*;
import com.pizza.exceptions.drinkexceptions.NoSuchDrinkException;
import com.pizza.model.Drink;
import com.pizza.model.Order;
import com.pizza.model.Pizza;
import com.pizza.model.Sauce;
import com.pizza.model.User;
import com.pizza.services.DrinkService;
import com.pizza.services.OrderService;
import com.pizza.services.PizzaService;
import com.pizza.services.SauceService;

public class StartMenuUser {
	private User user;
	private Scanner scan;
	private Set<Pizza> pizzas = new HashSet<>();
	private Set<Sauce> sauces = new HashSet<>();
	private Set<Drink> drinks = new HashSet<>();
	private Order order;
	private OrderDao orderDAO;

	public StartMenuUser(User user) {
		this.user = user;
	}

	public void mainMenu() {		
		System.out.println("============================");
		System.out.println("| 1.Choose pizza           |");
		System.out.println("| 2.Choose sauce           |");
		System.out.println("| 3.Choose drink           |");
		System.out.println("| 4.Finish order           |");
		System.out.println("| 5.Repeat a previous order|");
		System.out.println("============================");
		System.out.println("       Select option:");
		scan = new Scanner(System.in);
		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			try {
			pizzas = getUserPizza();
			mainMenu();
			}catch(NoSuchPizzaException e) {
				System.out.println(e.getErrorMessage());
				mainMenu();
			}
			break;
		case 2:
			try {
			sauces = getUserSauce();
			mainMenu();
			}catch(NoSuchSauceException e) {
				System.out.println(e.getErrorMessage());
				mainMenu();
			}
			break;
		case 3:
			try {
				drinks = getUserDrink();
				mainMenu();
			} catch (NoSuchDrinkException e) {
				System.out.println(e.getErrorMessage());
				mainMenu();
			}
			break;
		case 4:
			finishOrder();
			break;
		case 5:
			repeatPreviousOrder();
			break;
		default:
			throw new UserInputException("Wrong option entered !");			
		}
	}

	private Set<Pizza> getUserPizza() {
		PizzaService pz = new PizzaService();
		pz.getAllPizzas();
		Pizza pizza = pz.choosePizza();
		pizzas.add(pizza);
		return pizzas;
	}

	public Set<Sauce> getUserSauce() {
		SauceService sc = new SauceService();
		sc.getAllSauces();
		Sauce sauce = sc.chooseSauce();
		sauces.add(sauce);
		return sauces;
	}

	public Set<Drink> getUserDrink() {
		DrinkService dr = new DrinkService();
		dr.getAllDrinks();
		Drink drink = dr.chooseDrink();
		drinks.add(drink);
		return drinks;
	}

	private void finishOrder() {
		order = new Order(pizzas, sauces, drinks, user, false, new Date());
		System.out.println(order.toString());
		BigDecimal sum = new BigDecimal("0");
		for (Pizza pizza : pizzas) {
			sum = sum.add(pizza.getPrice());
		}
		for (Sauce sauce : sauces) {
			sum = sum.add(sauce.getPrice());
		}
		for (Drink drink : drinks) {
			sum = sum.add(drink.getPrice());
		}
		System.out.println("Price of order: " + sum + "lv ");
		orderDAO = new OrderDaoImpl();
		orderDAO.save(order);
	}

	private void repeatPreviousOrder() {
		scan = new Scanner(System.in);
		System.out.println("Your previuos orders:");
		OrderService of = new OrderService(user);
		Collection<Order> orders = of.repeatPrevOrder();
		System.out.println("Enter order id:");
		int orderId = scan.nextInt();
		of.createOrderFromOldOrder(orderId);
		System.out.println("-Order sended-");
	}
}
