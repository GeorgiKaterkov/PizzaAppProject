package startmenu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

import create.DrinkService;
import create.OrderService;
import create.PizzaService;
import create.SauceService;
import dao.PizzaDao;
import entities.Order;
import entities.Pizza;
import entities.PizzaSizeEnum;
import entities.User;

public class StartMenuAdmin {
	private Pizza pizza;
	private PizzaSizeEnum pizzaSize;
	private PizzaDao pizzaDAO;
	private User user;	
	Scanner scan;

	public StartMenuAdmin(User user) {
		this.user = user;
	}
    //MAIN MENU FOR ADMIN
	public void mainMenu() throws ParseException {
		System.out.println("====================");
		System.out.println("| 1.Add new product|");
		System.out.println("| 2.Delete product |");
		System.out.println("| 3.Update product |");
		System.out.println("| 4.Process order  |");
		System.out.println("| 5.Order enquiry  |");
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
		case 4:
			processOrder();
			mainMenu();
			break;
		
		case 5:
			orderEnquiry();
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
			PizzaService pf = new PizzaService();
			pf.addNewPizza();
			break;
		case 2:
			SauceService sf = new SauceService();
			sf.addNewSauce();
			break;
		case 3:
			DrinkService df = new DrinkService();
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
			PizzaService pf = new PizzaService();
			pf.getAllPizzas();
			pf.deletePizza();
			break;
		case 2:
			SauceService sf = new SauceService();
			sf.getAllSauces();
			sf.deleteSauce();
			break;
		case 3:
			DrinkService df = new DrinkService();
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
			PizzaService pf = new PizzaService();
			pf.getAllPizzas();
			pf.updatePizza();
			break;
		case 2:
			SauceService sf = new SauceService();
			sf.getAllSauces();
			sf.updateSauce();
			break;
		case 3:
			DrinkService df = new DrinkService();
			df.getAllDrinks();
			df.updateSauce();
			break;
		}
	}
    //PROCESS
	private void processOrder() {		
		OrderService of = new OrderService(user);
		of.getNotProcessedOrders();
		of.processOrders();
		System.out.println("-Orders Processed-");
	}
	//ENQUIRY OF ORDERS BY DATE
	private void orderEnquiry() throws ParseException {
		OrderService of = new OrderService(user);
		scan = new Scanner(System.in);
		System.out.println("Date format must be - dd/mm/yyyy");
		System.out.println("Enter first date: ");
		String dateFromInput = scan.nextLine();
		System.out.println("Enter last date: ");
		String dateToInput = scan.nextLine();
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date  dateFrom  = format.parse(dateFromInput);
		Date  dateTo  = format.parse(dateToInput);
		Collection<Order> orderEnquiries = of.orderEnquiry(dateFrom, dateTo);
		System.out.println("Enquiry of orders between " + dateFrom + " and " + dateTo);
		System.out.println("=======================================================================================");
		for (Order order : orderEnquiries) {
			System.out.println(order.toString());
		}
	}

}
