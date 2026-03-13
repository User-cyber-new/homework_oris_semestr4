package org.example.jdbctemplate.application.repository;

public interface CRUDRepository<T> {
    boolean create(T t);
    T read(Integer id);
    boolean update(T t);
    boolean delete(Integer id);
}
