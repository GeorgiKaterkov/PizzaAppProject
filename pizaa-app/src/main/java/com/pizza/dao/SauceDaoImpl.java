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
import com.pizza.exceptions.NoSuchSauceException;
import com.pizza.model.Order;
import com.pizza.model.Sauce;

@Repository
public class SauceDaoImpl implements SauceDao {

	private EntityManager entityManager;
	
	@Autowired
	private OrderDao orderDao;
	Scanner scan;

	public SauceDaoImpl() {
		JPAConfiguration config = new JPAConfiguration();
		entityManager = config.getEntityManager();
	}

	@Override
	public Sauce get(int id) {
		try {
			Sauce sauce = entityManager.createQuery("FROM Sauce s WHERE s.id = :id", Sauce.class).setParameter("id", id)
					.getSingleResult();
			return sauce;
		} catch (PersistenceException e) {
			throw new NoSuchSauceException(e.getMessage());
		}
	}

	@Override
	public Collection<Sauce> getAll() {
		List<Sauce> sauces = entityManager.createQuery("FROM Sauce", Sauce.class).getResultList();
		return sauces;
	}

	@Override
	public void save(Sauce sauce) {
		entityManager.getTransaction().begin();
		entityManager.persist(sauce);
		entityManager.getTransaction().commit();
		System.out.println("SAUCE SAVED");
	}

	@Override
	public void update(int id, BigDecimal price) {
		try {			
			Sauce sauce = entityManager.find(Sauce.class, id);

			if (!sauce.equals(null)) {				
				sauce.setPrice(price);
				entityManager.getTransaction().begin();
				entityManager.merge(sauce);
				entityManager.getTransaction().commit();
				System.out.println("UPDATED");
			} else
				System.out.println("Invalid sauce's id\nTry again");
		} catch (NullPointerException e) {
			System.out.println("Invalid sauce\nTry again");
		}
	}

	@Override
	public void delete(int id) {
		Sauce sauce = entityManager.find(Sauce.class, id);
		entityManager.getTransaction().begin();
		/*
		 * Collection<Order> orders = orderDao.getAllBy(id); for (Order order : orders)
		 * { order.getSauces().remove(sauce); }
		 */
		entityManager.remove(sauce);
		entityManager.getTransaction().commit();		
	} 

	@Override
	public Collection<Sauce> getAllBy(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void processOrders(Sauce t) {
		// TODO Auto-generated method stub

	}

}
