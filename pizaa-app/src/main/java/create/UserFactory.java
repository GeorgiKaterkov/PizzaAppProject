package create;

import java.util.Scanner;

import javax.persistence.EntityManager;

import configuration.JPAConfiguration;
import entities.RoleEnum;
import entities.User;

public class UserFactory {

	public User getUser() {
		Scanner scan = new Scanner(System.in);

		JPAConfiguration config = new JPAConfiguration();
		EntityManager entityManager = config.getEntityManager();       
		
		System.out.println("------------");
		System.out.println("Enter name: ");
		String name = scan.nextLine();
		System.out.println("Enter pass: ");
		String pass = scan.nextLine();
		User user = entityManager
					.createQuery(
							"FROM User c WHERE c.username = :username ",
							User.class).setParameter("username", name).getSingleResult();
		
		if(user != null) {
			System.out.println("User Found!");
		} else {
			if(pass.contains("Admin123")) {
				user = new User(name, pass, RoleEnum.ADMIN);
			} else {
				user = new User(name, pass, RoleEnum.USER);
			}
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
			System.out.println("User Created!");
		}
		
		return user;
	}
	
}
