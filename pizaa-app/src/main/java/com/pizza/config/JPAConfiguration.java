package com.pizza.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAConfiguration {
	
	private static final String PERSISTENCE_UNIT_NAME = "pizza";
  
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
}