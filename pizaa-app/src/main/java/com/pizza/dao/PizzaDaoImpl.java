package com.pizza.dao;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pizza.config.JPAConfiguration;
import com.pizza.exceptions.NoSuchPizzaException;
import com.pizza.exceptions.NotDeletedPizzaException;
import com.pizza.model.Pizza;

@Repository
public class PizzaDaoImpl implements PizzaDao {

	private static final String SELECT_PIZZA_BY_NAME = "FROM Pizza p WHERE p.namePizza = :name";
	//private static final String SELECT_PIZZA_BY_DISTINCT_NAME = "DISTINCT FROM Pizza p WHERE p.namePizza = :name";
	private EntityManager entityManager;
	Scanner scan;
	@Autowired
	private PizzaDao pizzaDao;

	public PizzaDaoImpl() {
		JPAConfiguration config = new JPAConfiguration();
		entityManager = config.getEntityManager();
	}

	@Override
	public Pizza get(int id) {
		try {
			Pizza pizza = entityManager.createQuery("FROM Pizza p WHERE p.id = :id", Pizza.class).setParameter("id", id)
					.getSingleResult();
			return pizza;
		} catch (PersistenceException e) {
			throw new NoSuchPizzaException(e.getMessage());
		}
	}

	@Override
	public Collection<Pizza> getAll() {
		List<Pizza> listOfPizzas = entityManager.createQuery("FROM Pizza", Pizza.class).getResultList();
		return listOfPizzas;
	}
	
	@Override
	public Collection<String> getAllByDistinctName() {
		List<String> listOfPizzas = entityManager.createQuery("SELECT DISTINCT namePizza FROM Pizza", String.class).getResultList();
		return listOfPizzas;
	}

	@Override
	public void save(Pizza pizza) {
		entityManager.getTransaction().begin();
		entityManager.persist(pizza);
		entityManager.getTransaction().commit();
	}

	@Override
	public void update(int id, BigDecimal price) {
		try {		
		Pizza pizza = entityManager.find(Pizza.class, id);

		if (!pizza.equals(null)) {			
			pizza.setPrice(price);
			entityManager.getTransaction().begin();
			entityManager.merge(pizza);
			entityManager.getTransaction().commit();
			System.out.println("UPDATED");
		} else
			System.out.println("Invalid pizza's id");
		}catch(NullPointerException e) {
			System.out.println("Invalid pizza\nTry again");
		}
	}

	@Override
	public void delete(Integer id) {
		    Pizza pizza = entityManager.find(Pizza.class, id);
		/*
		 * Pizza pizza = entityManager.createQuery(SELECT_PIZZA_BY_NAME,
		 * Pizza.class).setParameter("name", name).setMaxResults(3) .getSingleResult();
		 */	    
			entityManager.getTransaction().begin();
			entityManager.remove(pizza);
			entityManager.getTransaction().commit();
			System.out.println("PIZZA REMOVED");			    
	}

	@Override
	public Collection<Pizza> getAllBy(String name) {
		try {
			List<Pizza> pizzasOptions = entityManager.createQuery(SELECT_PIZZA_BY_NAME, Pizza.class).setParameter("name", name)
					.getResultList();					
			return pizzasOptions;
		} catch (PersistenceException e) {
			throw new NoSuchPizzaException(e.getMessage());
		}		
	}

	@Override
	public void processOrders(Pizza t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Pizza> getAllBy(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
