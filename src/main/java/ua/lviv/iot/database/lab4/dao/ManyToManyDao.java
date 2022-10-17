package ua.lviv.iot.database.lab4.dao;

import java.util.List;

public interface ManyToManyDao<T, ID1, ID2> {
    List<T> findAll();

    T findById(ID1 id1, ID2 id2);

    String create(T entity);

    String update(ID1 id1, ID2 id2, T entity);

    String delete(ID1 id1, ID2 id2);
}
