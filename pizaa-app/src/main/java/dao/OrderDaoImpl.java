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
		entityManager.getTransaction().begin();		
		entityManager.persist(order);		
		entityManager.getTransaction().commit();
		System.out.println("- ORDER SAVED -");
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Order> getAll() {
		List<Order> orders = entityManager.createQuery(
				"FROM Order o WHERE o.isProceeded = 0", Order.class)
				.getResultList();
		return orders;
	}

	@Override
	public void update(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processOrders(Order order) {		
		order.setIsProceeded(true);
		entityManager.getTransaction().begin();
		entityManager.merge(order);
		entityManager.getTransaction().commit();
	}

}
