package com.revature.dao;

import java.sql.SQLException;
import java.util.Set;

public interface CrudRepository<T> {
    public T save(T t);
    public Set<T> findAll() throws SQLException;
    public T findById(int id) throws SQLException;
    public boolean update(T t) throws SQLException;
    public boolean deleteById(int id) throws SQLException;


}