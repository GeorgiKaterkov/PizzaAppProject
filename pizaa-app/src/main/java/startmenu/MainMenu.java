package startmenu;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import create.UserRegistration;
import create.UserService;
import entities.Order;
import entities.User;
import entities.RoleEnum;
import exceptions.UserInputException;

public class MainMenu {
	Scanner scan;
	Order order;

	public void mainMenu() {
		System.out.println("====================");
		System.out.println("| 1.Login          |");
		System.out.println("| 2.Registration   |");
		System.out.println("====================");
		System.out.println("  Enter option:");
		scan = new Scanner(System.in);
		try {
		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			UserService userService = new UserService();
			userService.login();			
			break;
		case 2:
			UserRegistration userRegistration = new UserRegistration();
			userRegistration.register();
			mainMenu();
			break;
		default:
			System.out.println("Wrong option entered!");
			mainMenu();
		}	
		}catch(InputMismatchException e) {
			System.out.println("Error option");
		}
	}
	
}
