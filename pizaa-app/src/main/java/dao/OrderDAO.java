package dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager; 

import configuration.JPAConfiguration;
import entities.Order;
import entities.Pizza;


public class OrderDAO implements DAO<Order>{
	
	private EntityManager entityManager ;
	
	public OrderDAO(){
		JPAConfiguration config = new JPAConfiguration();
		entityManager = config.getEntityManager();
	}

	@Override
	public Order get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Order> getAllBy(Integer Id) {
		Collection<Order> listOfOrders = entityManager.createQuery("FROM Order",Order.class).getResultList();		
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
	public void update(Order t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Order> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
