package ua.lviv.iot.database.lab4.controllers;

import java.util.List;

public interface GeneralController<T, ID> {
    List<T> findAll();

    T findById(ID id);

    String create(T entity);

    String update(ID id, T entity);

    String delete(ID id);
}
