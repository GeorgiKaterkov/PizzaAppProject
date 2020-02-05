package com.pizza.dao;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pizza.config.JPAConfiguration;
import com.pizza.exceptions.InputMismatchPriceException;
import com.pizza.exceptions.drinkexceptions.NoCollectionDrinksException;
import com.pizza.exceptions.drinkexceptions.NoSuchDrinkException;
import com.pizza.exceptions.drinkexceptions.NotDeletedDrinkException;
import com.pizza.model.Drink;
import com.pizza.model.Order;

@Repository
public class DrinkDaoImpl implements DrinkDao {
	private static final String SELECT_DRINK_BY_ID = "FROM Drink d WHERE d.id = :id";
	private EntityManager entityManager;
	
	@Autowired
	private OrderDao orderDao;
	
	Scanner scan;

	public DrinkDaoImpl() {
		JPAConfiguration config = new JPAConfiguration();
		entityManager = config.getEntityManager();
	}

	@Override
	public Drink get(int id) {
		try {
			Drink drink = entityManager.createQuery(SELECT_DRINK_BY_ID, Drink.class).setParameter("id", id)
					.getSingleResult();
			return drink;
		} catch (PersistenceException e) {
			throw new NoSuchDrinkException(e.getMessage());
		}
	}

	@Override
	public Collection<Drink> getAll() {
		try {
			List<Drink> drinks = entityManager.createQuery("FROM Drink", Drink.class).getResultList();
			return drinks;
		} catch (PersistenceException e) {
			throw new NoCollectionDrinksException(e.getMessage() + " nqma napitki");
		}
	}

	@Override
	public void save(Drink drink) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(drink);
			entityManager.getTransaction().commit();
			System.out.println("DRINK SAVED");
		} catch (PersistenceException e) {
			throw new InputMismatchPriceException(e.getMessage() + " Ne se zapazi");
		}
	}

	@Override
	public void update(int id, BigDecimal price) {
		try {		
			Drink drink = entityManager.find(Drink.class, id);
			if (!drink.equals(null)) {				
				drink.setPrice(price);
				entityManager.getTransaction().begin();
				entityManager.merge(drink);
				entityManager.getTransaction().commit();
				System.out.println("UPDATED");
			} else
				System.out.println("Invalid drink's id");
		} catch (NullPointerException e) {
			System.out.println("Invalid drink's id\nTry again");
		}
	}

	@Override
	public void delete(int id) {
		try {
			Drink drink = entityManager.find(Drink.class, id);
			entityManager.getTransaction().begin();
			/*
			 * Collection<Order> orders = orderDao.getAllBy(id); for (Order order : orders)
			 * { order.getDrinks().remove(drink); }
			 */
			entityManager.remove(drink);
			entityManager.getTransaction().commit();
			System.out.println("DRINK REMOVED");
		} catch (PersistenceException e) {
			throw new NotDeletedDrinkException(e.getMessage());
		}
	}

	@Override
	public Collection<Drink> getAllBy(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void processOrders(Drink t) {
		// TODO Auto-generated method stub

	}

}
