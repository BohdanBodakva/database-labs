package ua.lviv.iot.database.lab4.services;

import java.util.List;
import java.util.Optional;

public interface GeneralService<T, ID> {
    List<T> findAll();

    T findById(ID id);

    int create(T entity);

    int update(ID id, T entity);

    int delete(ID id);
}
