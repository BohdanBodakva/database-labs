package ua.lviv.iot.database.lab4.dao;

import java.util.List;
import java.util.Optional;

public interface ManyToManyDao<T, ID1, ID2> {
    List<T> findAll();

    Optional<T> findById(ID1 id1, ID2 id2);

    int create(T entity);

    int update(ID1 id1, ID2 id2, T entity);

    int delete(ID1 id1, ID2 id2);
}
