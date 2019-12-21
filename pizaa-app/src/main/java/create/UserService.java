package create;

import java.text.ParseException;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import startmenu.StartMenuAdmin;
import startmenu.StartMenuUser;
import entities.RoleEnum;
import configuration.JPAConfiguration;
import dao.UserDao;
import dao.UserDaoImpl;
import entities.RoleEnum;
import entities.User;
import exceptions.NoSuchUserException;
import exceptions.UserInputException;

public class UserService {
	Scanner scan;
	public UserDao userDao;
	
	
    
	public UserService() {
		userDao = new UserDaoImpl();
	}

	public void login(){
		try{
		scan = new Scanner(System.in);

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
		System.out.println("User Found!");
		loadPropriateMenu(user);
	  }catch(NoResultException e){
		  System.out.println(e.getMessage());
		  login();
	  }
	}
	
	private void loadPropriateMenu(User user) {
		if (user.getRole().name().equals(RoleEnum.ADMIN.name())) {
			System.out.println("In StratMenuAdmin...");
			StartMenuAdmin sma = new StartMenuAdmin(user);
			try {
				sma.mainMenu();

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				System.out.println("In StartMenuUser...");
				StartMenuUser smu = new StartMenuUser(user);
				smu.mainMenu();
			} catch (UserInputException e) {
				System.out.println(e.getErrorMessage());
			}
		}
	}
	
	public void changeUserToAdmin() {
		System.out.println("Enter username that will be changed: ");
		scan = new Scanner(System.in);
		String username = scan.nextLine();
		userDao.changeUserToAdmin(username);
		
	}
}
