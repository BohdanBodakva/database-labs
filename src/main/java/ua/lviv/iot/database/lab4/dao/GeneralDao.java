package ua.lviv.iot.database.lab4.dao;

import java.util.List;

public interface GeneralDao<T, ID> {
    List<T> findAll();

    T findById(ID id);

    String create(T entity);

    String update(ID id, T entity);

    String delete(ID id);
}
