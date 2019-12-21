package dao;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import configuration.JPAConfiguration;
import entities.Order;
import entities.Sauce;
import exceptions.NoSuchSauceException;

public class SauceDaoImpl implements SauceDao {

	private EntityManager entityManager;
	private OrderDao orderDao;
	Scanner scan;

	public SauceDaoImpl() {
		JPAConfiguration config = new JPAConfiguration();
		entityManager = config.getEntityManager();
		orderDao = new OrderDaoImpl();
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
	public void update(int id) {
		try {
			scan = new Scanner(System.in);
			Sauce sauce = entityManager.find(Sauce.class, id);

			if (!sauce.equals(null)) {
				System.out.println(sauce);
				System.out.println("Update price: ");
				BigDecimal newPrice = scan.nextBigDecimal();
				sauce.setPrice(newPrice);
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
		Collection<Order> orders = orderDao.getAllBy(id);
		for (Order order : orders) {
			order.getSauces().remove(sauce);
		}
		entityManager.remove(sauce);
		entityManager.getTransaction().commit();
		System.out.println("SAUCE REMOVED");
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
