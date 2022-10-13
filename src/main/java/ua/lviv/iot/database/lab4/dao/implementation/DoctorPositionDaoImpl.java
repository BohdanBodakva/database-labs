package ua.lviv.iot.database.lab4.dao.implementation;

import org.springframework.stereotype.Repository;
import ua.lviv.iot.database.lab4.dao.DoctorPositionDao;
import ua.lviv.iot.database.lab4.models.DoctorPosition;

import java.util.List;
import java.util.Optional;

@Repository
public class DoctorPositionDaoImpl implements DoctorPositionDao {
    @Override
    public List<DoctorPosition> findAll() {
        return null;
    }

    @Override
    public Optional<DoctorPosition> findById(Integer integer, String s) {
        return Optional.empty();
    }

    @Override
    public int create(DoctorPosition entity) {
        return 0;
    }

    @Override
    public int update(Integer integer, String s, DoctorPosition entity) {
        return 0;
    }

    @Override
    public int delete(Integer integer, String s) {
        return 0;
    }
}
