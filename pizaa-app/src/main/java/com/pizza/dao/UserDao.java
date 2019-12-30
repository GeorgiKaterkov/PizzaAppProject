package com.pizza.dao;

import java.util.Collection;

import com.pizza.model.User;

public interface UserDao {
	
    User get(int id);
    
    Collection<User> getAll();
     
    Collection<User> getAllBy(Integer id);
    
    void save(String username, String password);
     
    void update(int id);
     
    void delete(int id);
    
    void changeUserToAdmin(String username);

	User loadUser(String username, String password);

}
