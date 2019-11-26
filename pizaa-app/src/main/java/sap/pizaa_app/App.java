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
		/*User user = new User("Manol","1234",RoleEnum.USER );
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		System.out.println("DONE");*/
	}
			
}
