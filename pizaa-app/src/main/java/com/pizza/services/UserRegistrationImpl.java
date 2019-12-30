package com.pizza.services;

import java.util.Scanner;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.config.JPAConfiguration;
import com.pizza.dao.UserDao;
import com.pizza.model.RoleEnum;
import com.pizza.model.User;

@Service
public class UserRegistrationImpl implements UserRegistration{
	
	@Autowired
	public UserDao userDao;
    
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

	@Override
	public void makeRegistration(String username, String password) {
		 userDao.save(username, password);
	}
	
}
