package configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAConfiguration {
	
	private static final String PERSISTENCE_UNIT_NAME = "pizza";
  
	/*public <T> T inTransaction(Function<EntityManager ,T> function) {
		EntityManager entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			T result = function.apply(entityManager);
			entityManager.getTransaction().commit();
			return result;
		} catch (PersistenceException e) {
			throw new RuntimeException(e);
		}
	}*/

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
}
