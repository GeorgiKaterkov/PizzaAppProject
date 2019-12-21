package create;

import java.util.Scanner;

import javax.persistence.EntityManager;

import configuration.JPAConfiguration;
import entities.RoleEnum;
import entities.User;

public class UserRegistration {
    
	private static final String passRegex = "^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$";
	JPAConfiguration config = new JPAConfiguration();
	EntityManager entityManager = config.getEntityManager();       
		
	public void register(){
		Scanner scan = new Scanner(System.in);
		System.out.println("------------");
		System.out.println("Enter name: ");
		String name = scan.nextLine();
		System.out.println("Enter pass: ");
		String pass = scan.nextLine();
		if(pass.matches(passRegex)) {
			User user = new User(name, pass, RoleEnum.USER);
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
			System.out.println("User Created!");
		}else {
			System.out.println("Password must contains atleast one letter or one number!");
		}
		
	}
	
}
