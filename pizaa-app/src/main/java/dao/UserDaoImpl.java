package dao;

import java.util.Collection;

import javax.persistence.EntityManager;

import configuration.JPAConfiguration;
import entities.RoleEnum;
import entities.User;

public class UserDaoImpl implements UserDao {

	private static final String SELECT_USER_BY_USERNAME = "FROM User c WHERE c.username = :username";
	private EntityManager entityManager;

	public UserDaoImpl() {
		JPAConfiguration config = new JPAConfiguration();
		entityManager = config.getEntityManager();
	}

	@Override
	public User get(int id) {
		return null;
	}

	@Override
	public Collection<User> getAll() {
		return null;
	}

	@Override
	public Collection<User> getAllBy(Integer id) {
		return null;
	}

	@Override
	public void save(User user) {

	}

	@Override
	public void update(int id) {

	}

	@Override
	public void delete(int id) {

	}

	@Override
	public void changeUserToAdmin(String username) {
		User user = entityManager.createQuery(SELECT_USER_BY_USERNAME, User.class)
				.setParameter("username", username).getSingleResult();
		user.setRole(RoleEnum.ADMIN);
		entityManager.getTransaction().begin();
		entityManager.merge(user);
		entityManager.getTransaction().commit();
		System.out.println("User " + user.getName().toString() + " changed to ADMIN");
	}

}
