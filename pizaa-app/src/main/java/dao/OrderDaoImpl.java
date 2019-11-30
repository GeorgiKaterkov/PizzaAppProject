package dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import configuration.JPAConfiguration;
import entities.Order;

public class OrderDaoImpl implements OrderDao {

	private EntityManager entityManager;

	public OrderDaoImpl() {
		JPAConfiguration config = new JPAConfiguration();
		entityManager = config.getEntityManager();
	}

	@Override
	public Order get(int id) {
		Order order = entityManager
				.createQuery("FROM Order o WHERE o.id = :id", Order.class)
				.setParameter("id", id).getSingleResult();
		return order;
	}

	@Override
	public Collection<Order> getAllBy(Integer id) {
		Collection<Order> listOfOrders = entityManager.createQuery(
				"FROM Order", Order.class).getResultList();
		return listOfOrders;
	}

	@Override
	public Collection<Order> getAllByPeriod(Date from, Date to) {
		Collection<Order> listOfOrders = entityManager
				.createQuery(
						"FROM Order o where (o.orderDate between :from and :to)",
						Order.class).setParameter("from", from)
				.setParameter("to", to).getResultList();
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
