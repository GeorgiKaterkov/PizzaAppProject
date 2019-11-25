package dao;

import java.util.Collection;

public interface DAO<T> {
    
    T get(int id);
     
    Collection<T> getAll();
     
    Collection<T> getAllBy(Integer id);
    
    void save(T t);
     
    void update(int id);
     
    void delete(int id);
}