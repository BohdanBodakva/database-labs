package ua.lviv.iot.database.lab4.services;

import java.util.List;

public interface GeneralService<T, ID> {
    List<T> findAll();

    T findById(ID id);

    String create(T entity);

    String update(ID id, T entity);

    String delete(ID id);
}
