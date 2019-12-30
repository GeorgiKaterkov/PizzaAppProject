package startmenu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.persistence.PersistenceException;

import com.pizza.dao.PizzaDao;
import com.pizza.exceptions.InputMismatchPriceException;
import com.pizza.exceptions.UnparseableDataException;
import com.pizza.exceptions.drinkexceptions.NotSavedDrinkException;
import com.pizza.model.Order;
import com.pizza.model.Pizza;
import com.pizza.model.PizzaSizeEnum;
import com.pizza.model.User;
import com.pizza.services.DrinkService;
import com.pizza.services.OrderService;
import com.pizza.services.PizzaService;
import com.pizza.services.SauceService;
import com.pizza.services.UserService;

public class StartMenuAdmin {
	private static final String dateRegex = "^[0-9]{2}[-|\\\\/]{1}[0-9]{2}[-|\\\\/]{1}[0-9]{4}$";
	private Pizza pizza;
	private PizzaSizeEnum pizzaSize;
	private PizzaDao pizzaDAO;
	private User user;
	Scanner scan;

	public StartMenuAdmin(User user) {
		this.user = user;
	}

	// MAIN MENU FOR ADMIN
	public void mainMenu() throws ParseException {
		System.out.println("====================");
		System.out.println("| 1.Add new product|");
		System.out.println("| 2.Delete product |");
		System.out.println("| 3.Update product |");
		System.out.println("| 4.Process order  |");
		System.out.println("| 5.Order enquiry  |");
		System.out.println("| 6.Make user admin|");
		System.out.println("====================");
		System.out.println("  Enter option:");
		try {
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
			case 6:
				changeToAdmin();
				mainMenu();
				break;
			default:
				System.out.println("\nInvalid choice, please enter a menu option number 1-5");
			}
		} catch (InputMismatchException e) {
			throw new InputMismatchException(e.getMessage());
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
		try {
			int choice = scan.nextInt();
			switch (choice) {			
			case 1:
				try {
				PizzaService pf = new PizzaService();
				pf.addNewPizza();
			}catch(InputMismatchException e) {
				System.out.println("Invalid price!\nTry again using ',' ");
			}
				break;
			case 2:
				try {
				SauceService sf = new SauceService();
				sf.addNewSauce();
				}catch(InputMismatchException e) {
					System.out.println("Invalid price!\nTry again using ',' ");
				}
				break;
			case 3:
				try {
					DrinkService df = new DrinkService();
					df.addNewDrink();
				} catch (InputMismatchException e) {
					System.out.println("Invalid price!\nTry again using ',' ");
				}
				break;
			default:
				System.out.println("Wrong option entered!\nChoose from 1-3");
			}
		} catch (InputMismatchException e) {
			throw new InputMismatchException(e.getMessage());
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
		try {
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				PizzaService pf = new PizzaService();
				try {
				pf.getAllPizzas();
				pf.deletePizza();
				}catch(IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				SauceService sf = new SauceService();
				try {
				sf.getAllSauces();
				sf.deleteSauce();
				}catch(IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try {
				DrinkService df = new DrinkService();
				df.getAllDrinks();
				df.deleteDrink();
				}catch(IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
				System.out.println("Wrong option entered!\nChoose from 1-3");
			}
		} catch (InputMismatchException e) {
			throw new InputMismatchException(e.getMessage());
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
		try {
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
			df.updateDrink();
			break;
		default: System.out.println("Wrong option entered!\nChoose from 1-3");
		}
		}catch(InputMismatchException e) {
			throw new InputMismatchException(e.getMessage());
		}
	}

	// PROCESS
	private void processOrder() {
		OrderService of = new OrderService(user);
		of.getNotProcessedOrders();
		of.processOrders();
		System.out.println("-Orders Processed-");
	}

	// ENQUIRY OF ORDERS BY DATE
	private void orderEnquiry() throws ParseException {
		OrderService of = new OrderService(user);
		scan = new Scanner(System.in);
		System.out.println("Date format must be - dd/mm/yyyy");
		System.out.println("Enter first date: ");
		
		String dateFromInput = scan.nextLine();
		System.out.println("Enter last date: ");
		String dateToInput = scan.nextLine();
		try {
			if(dateFromInput.matches(dateRegex) 
					&& dateToInput.matches(dateRegex)) {
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				Date dateFrom = format.parse(dateFromInput);
				Date dateTo = format.parse(dateToInput);
				
				Collection<Order> orderEnquiries = of.orderEnquiry(dateFrom, dateTo);
				System.out.println("Enquiry of orders between " + dateFrom + " and " + dateTo);
				System.out.println("=======================================================================================");
				for (Order order : orderEnquiries) {
					System.out.println(order.toString());
				}				
			}
			else System.out.println("Invalid data!");
		}catch(ParseException e) {
			throw new UnparseableDataException(e.getMessage());
		}		
	}

	public void changeToAdmin() {
//		UserService userService = new UserService();
//		userService.changeUserToAdmin();
	}

}
