package dao;

import java.util.Collection;

import entities.User;

public interface UserDao {
	
    User get(int id);
    
    Collection<User> getAll();
     
    Collection<User> getAllBy(Integer id);
    
    void save(User user);
     
    void update(int id);
     
    void delete(int id);
    
    void changeUserToAdmin(String username);

}
