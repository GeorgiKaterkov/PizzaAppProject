package dao;

import java.util.Collection;

public interface DAO<T> {
    
    T get(int id);
     
    Collection<T> getAll();
     
    Collection<T> getAllBy(Integer id);
    
    void save(T t);
     
    void update(T t, String[] params);
     
    void delete(int id);
}