package dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import dao.OrderDAO;
import configuration.JPAConfiguration;
import entities.Order;
import entities.Sauce;

public class SauceDAO implements DAO<Sauce>{
	
	private EntityManager entityManager ;
	private OrderDAO orderDao;
	
	public SauceDAO(){
		JPAConfiguration config = new JPAConfiguration();
		entityManager = config.getEntityManager();
		orderDao = new OrderDAO();
	}

	@Override
	public Sauce get(int id) {
		Sauce sauce = entityManager.createQuery("FROM Sauce s WHERE s.id = :id", Sauce.class)
				                   .setParameter("id", id).getSingleResult();
		return sauce;
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
	public void update(Sauce t, String[] params) {
		// TODO Auto-generated method stub		
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
	
	

}
