package create;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Scanner;

import dao.SauceDao;
import dao.SauceDaoImpl;
import entities.Sauce;

public class SauceService {
	private Sauce sauce;
	Scanner scan;
	private SauceDao sauceDAO;

	public SauceService() {
		sauceDAO = new SauceDaoImpl();
	}

	// USER
	public void getAllSauces() {
		System.out.println("Menu: ");
		Collection<Sauce> sauces = sauceDAO.getAll();
		for (Sauce sauce : sauces) {
			System.out.println(sauce.toString());
		}
	}

	// USER
	public Sauce chooseSauce() {
		scan = new Scanner(System.in);
		System.out.println("Enter option: ");
		int choice = scan.nextInt();
		Sauce sauce = sauceDAO.get(choice);
		System.out.println("Your choice is: " + sauce.getSauceName());
		return sauce;
	}

	// ADMIN
	public void addNewSauce() {
		scan = new Scanner(System.in);
		System.out.println("Enter sauce name: ");
		String name = scan.next();
		System.out.println("Enter sauce price: ");
		BigDecimal price = scan.nextBigDecimal();
		sauce = new Sauce(name, price);
		sauceDAO.save(sauce);
	}

	// ADMIN
	public void deleteSauce() {
		scan = new Scanner(System.in);
		System.out.println("Enter sauce id: ");
		int choice = scan.nextInt();
		System.out.println("Choice sended");
		sauceDAO.delete(choice);
	}

	// ADMIN
	public void updateSauce() {
		scan = new Scanner(System.in);
		System.out.println("Enter sauce id: ");
		int choice = scan.nextInt();
		System.out.println("Choice sended");
		sauceDAO.update(choice);
	}
}
