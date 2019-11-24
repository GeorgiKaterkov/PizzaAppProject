package sap.pizaa_app;

import java.math.BigDecimal;
import java.util.Scanner;

import javax.persistence.EntityManager;

import configuration.JPAConfiguration;
import entities.Pizza;
import entities.PizzaSizeEnum;
import entities.RoleEnum;
import entities.Sauce;
import entities.User;
import startmenu.MainMenu;


public class App {
	static Scanner scan;
	public static void main(String[] args) {
		
		JPAConfiguration config = new JPAConfiguration();
		EntityManager entityManager = config.getEntityManager();		  	
				
		MainMenu mainMenu = new MainMenu();
		mainMenu.mainMenu();
		/*Pizza pizza = new Pizza("Margarita",PizzaSizeEnum.MEDIUM, new BigDecimal("10.50"));
		entityManager.getTransaction().begin();
		entityManager.persist(pizza);
		entityManager.getTransaction().commit();
		System.out.println("DONE");*/
	}
			
}
