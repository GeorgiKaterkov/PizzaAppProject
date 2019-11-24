package dao;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import configuration.JPAConfiguration;
import entities.Order;
import entities.Pizza;

public class PizzaDAO implements DAO<Pizza>{

	private EntityManager entityManager ;
	
	private OrderDAO orderDao;
	
	public PizzaDAO(){
		JPAConfiguration config = new JPAConfiguration();
		entityManager = config.getEntityManager();
		orderDao = new OrderDAO();
	}
	
	@Override
	public Pizza get(int id) {
		Pizza pizza = entityManager.createQuery("FROM Pizza p WHERE p.id = :id", Pizza.class)
                .setParameter("id", id).getSingleResult();
		return pizza;
	}

	@Override
	public Collection<Pizza> getAll() {
		List<Pizza> listOfPizzas = entityManager.createQuery("FROM Pizza",Pizza.class).getResultList();		
		return listOfPizzas;
	}

	@Override
	public void save(Pizza pizza) {		
		entityManager.getTransaction().begin();		
		entityManager.persist(pizza);	
		entityManager.getTransaction().commit();
	}

	@Override
	public void update(Pizza t, String[] params) {
		
	}

	@Override
	public void delete(int id) {
		Pizza pizza = entityManager.find(Pizza.class, id);
		entityManager.getTransaction().begin();		
		Collection<Order> orders = orderDao.getAllBy(id);
		for (Order order : orders) {
			order.getPizzas().remove(pizza);
		}
		entityManager.remove(pizza);				
		entityManager.getTransaction().commit();
		System.out.println("PIZZA REMOVED");
	}

	@Override
	public Collection<Pizza> getAllBy(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}