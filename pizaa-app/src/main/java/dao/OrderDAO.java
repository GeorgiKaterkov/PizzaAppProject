package dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import configuration.JPAConfiguration;
import entities.Drink;
import entities.Order;
import entities.Pizza;

public class OrderDAO implements DAO<Order> {

	private EntityManager entityManager;

	public OrderDAO() {
		JPAConfiguration config = new JPAConfiguration();
		entityManager = config.getEntityManager();
	}

	@Override
	public Order get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Order> getAllBy(Integer id) {
		Collection<Order> listOfOrders = entityManager.createQuery(
				"FROM Order", Order.class).getResultList();
		return listOfOrders;
	}

	@Override
	public void save(Order order) {
		System.out.println("IN SAVE METHOD");
		entityManager.getTransaction().begin();
		System.out.println("IN TRANSACTION");
		entityManager.persist(order);
		System.out.println("AFTER PERSIST");
		entityManager.getTransaction().commit();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Order> getAll() {
		List<Order> orders = entityManager.createQuery(
				"FROM Order o WHERE o.isProceeded = 1", Order.class)
				.getResultList();
		return orders;
	}

	@Override
	public void update(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processOrders(Order order) {
		// order = entityManager.find(Order.class, order);
		order.setIsProceeded(false);
		entityManager.getTransaction().begin();
		entityManager.merge(order);
		entityManager.getTransaction().commit();
	}

}
