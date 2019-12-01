package startmenu;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import create.DrinkService;
import create.OrderService;
import create.PizzaService;
import create.SauceService;
import dao.OrderDao;
import dao.OrderDaoImpl;
import entities.Drink;
import entities.Order;
import entities.Pizza;
import entities.Sauce;
import entities.User;
import exceptions.UserInputException;

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
		// System.out.println("1.Choose pizza\n2.Choose sauce\n3.Choose drink\n4.Finish Order\nEnter option:");
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
			pizzas = getUserPizza();
			mainMenu();
			break;
		case 2:
			sauces = getUserSauce();
			mainMenu();
			break;
		case 3:
			drinks = getUserDrink();
			mainMenu();
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
		order = new Order(pizzas, sauces, drinks, user, true, new Date());
		System.out.println(order.toString());
		BigDecimal sum = new BigDecimal("0");		
		for(Pizza pizza : pizzas){
			sum = sum.add(pizza.getPrice());							
		}
		for(Sauce sauce : sauces){
			sum = sum.add(sauce.getPrice());
		}
		for(Drink drink : drinks){
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
