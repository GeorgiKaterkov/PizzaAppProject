
package com.pizza.dao;

import java.util.Collection;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.pizza.config.JPAConfiguration;
import com.pizza.model.RoleEnum;
import com.pizza.model.User;

@Repository
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
	public void save(String username, String password) {
		User user = new User(username, password, RoleEnum.USER);
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
	}

	@Override
	public void update(int id) {

	}

	@Override
	public void delete(int id) {

	}

	@Override
	public void changeUserToAdmin(String username) {
		User user = entityManager.createQuery(SELECT_USER_BY_USERNAME , User.class)
				.setParameter("username", username).getSingleResult();
		user.setRole(RoleEnum.ADMIN);
		entityManager.getTransaction().begin();
		entityManager.merge(user);
		entityManager.getTransaction().commit();
		System.out.println("User " + user.getName().toString() + " changed to ADMIN");
	}
	
	@Override
	public User loadUser(String username, String password) {
		User user = entityManager
				.createQuery(
						"FROM User c WHERE c.username = :username and c.password = :password ",
						User.class).setParameter("username", username).setParameter("password", password).setMaxResults(1).getSingleResult();
		return user;
	}

}
