package ua.lviv.iot.database.lab4.dao.implementation;

import ua.lviv.iot.database.lab4.dao.WorkPositionDao;
import ua.lviv.iot.database.lab4.models.WorkPosition;

import java.util.List;
import java.util.Optional;

public class WorkPositionDaoImpl implements WorkPositionDao {
    @Override
    public List<WorkPosition> findAll() {
        return null;
    }

    @Override
    public Optional<WorkPosition> findById(String s) {
        return Optional.empty();
    }

    @Override
    public int create(WorkPosition entity) {
        return 0;
    }

    @Override
    public int update(String s, WorkPosition entity) {
        return 0;
    }

    @Override
    public int delete(String s) {
        return 0;
    }

    @Override
    public List<WorkPosition> getAllWorkPositionsByName(String workPositionName) {
        return null;
    }
}
