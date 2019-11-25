package dao;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import configuration.JPAConfiguration;
import entities.Drink;
import entities.Order;
import entities.Sauce;

public class DrinkDAO implements DAO<Drink>{
	private static final String SELECT_DRINK_BY_ID = "FROM Drink d WHERE d.id = :id";
	private EntityManager entityManager ;
	private OrderDAO orderDao;
	Scanner scan;
	
	public DrinkDAO(){
		JPAConfiguration config = new JPAConfiguration();
		entityManager = config.getEntityManager();
		orderDao = new OrderDAO();
	}

	@Override
	public Drink get(int id) {		
		Drink drink = entityManager.createQuery(SELECT_DRINK_BY_ID, Drink.class)
				                   .setParameter("id", id).getSingleResult();
		return drink;
	}

	@Override
	public Collection<Drink> getAll() {
		List<Drink> drinks = entityManager.createQuery("FROM Drink", Drink.class).getResultList();
		return drinks;
	}

	@Override
	public void save(Drink drink) {		
		entityManager.getTransaction().begin();
		entityManager.persist(drink);
		entityManager.getTransaction().commit();
		System.out.println("DRINK SAVED");
	}

	@Override
	public void update(int id) {
		scan = new Scanner(System.in);
		Drink drink = entityManager.find(Drink.class, id);
		System.out.println(drink);
		System.out.println("Update price: ");
		BigDecimal newPrice = scan.nextBigDecimal();
		drink.setPrice(newPrice);
		entityManager.getTransaction().begin();
		entityManager.merge(drink);
		entityManager.getTransaction().commit();	
		System.out.println("UPDATED");		
	}

	@Override
	public void delete(int id) {
		Drink drink = entityManager.find(Drink.class, id);
		entityManager.getTransaction().begin();
		Collection<Order> orders = orderDao.getAllBy(id);
		for (Order order : orders) {
			order.getDrinks().remove(drink);
		}
		entityManager.remove(drink);
		entityManager.getTransaction().commit();
		System.out.println("PIZZA REMOVED");
	}

	@Override
	public Collection<Drink> getAllBy(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
