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
	public void save(Pizza pizza) {
		entityManager.getTransaction().begin();
		entityManager.persist(pizza);
		entityManager.getTransaction().commit();
	}

	@Override
	public void update(int id) {
		try {
		scan = new Scanner(System.in);
		Pizza pizza = entityManager.find(Pizza.class, id);

		if (!pizza.equals(null)) {
			System.out.println(pizza);
			System.out.println("Update price: ");
			BigDecimal newPrice = scan.nextBigDecimal();
			pizza.setPrice(newPrice);
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
	public void delete(String name) {
		Pizza pizza = null;
		try{
			pizza = entityManager.createQuery(SELECT_PIZZA_BY_NAME, Pizza.class).setParameter("name", name)
					.getSingleResult();
			}	
			catch (NoResultException nre){
				//Ignore this because as per your logic this is ok!
				}
		    if(pizza==null) {
			entityManager.getTransaction().begin();
			entityManager.remove(pizza);
			entityManager.getTransaction().commit();
			System.out.println("PIZZA REMOVED");	
		    }
	}

	@Override
	public Collection<Pizza> getAllBy(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void processOrders(Pizza t) {
		// TODO Auto-generated method stub

	}

}
