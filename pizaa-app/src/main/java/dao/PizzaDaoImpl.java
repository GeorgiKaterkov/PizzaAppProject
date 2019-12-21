package dao;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import configuration.JPAConfiguration;
import entities.Order;
import entities.Pizza;
import exceptions.NoSuchPizzaException;
import exceptions.NotDeletedPizzaException;

public class PizzaDaoImpl implements PizzaDao {

	private EntityManager entityManager;
	Scanner scan;

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
	public void delete(int id) {
		try {
			Pizza pizza = entityManager.find(Pizza.class, id);
			entityManager.getTransaction().begin();
			entityManager.remove(pizza);
			entityManager.getTransaction().commit();
			System.out.println("PIZZA REMOVED");
		} catch (PersistenceException e) {
			throw new NotDeletedPizzaException(e.getMessage());
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
