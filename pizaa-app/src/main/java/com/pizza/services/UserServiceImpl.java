package com.pizza.services;

import java.text.ParseException;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.config.JPAConfiguration;
import com.pizza.dao.UserDao;
import com.pizza.exceptions.UserInputException;
import com.pizza.model.RoleEnum;
import com.pizza.model.User;

import startmenu.StartMenuAdmin;
import startmenu.StartMenuUser;

@Service
public class UserServiceImpl implements UserService {
	Scanner scan;
	
	@Autowired
	public UserDao userDao;

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
	
	@Override
	public void changeUserToAdmin(String username) {		
		userDao.changeUserToAdmin(username);
		
	}
	
	@Override
	public User loadUser(String username, String password) {
		return userDao.loadUser(username, password);
	}
	
}
