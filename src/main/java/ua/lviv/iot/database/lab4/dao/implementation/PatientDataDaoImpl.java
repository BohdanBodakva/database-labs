package ua.lviv.iot.database.lab4.dao.implementation;

import ua.lviv.iot.database.lab4.dao.PatientDataDao;
import ua.lviv.iot.database.lab4.models.PatientData;

import java.util.List;
import java.util.Optional;

public class PatientDataDaoImpl implements PatientDataDao {
    @Override
    public List<PatientData> findAll() {
        return null;
    }

    @Override
    public Optional<PatientData> findById(String s) {
        return Optional.empty();
    }

    @Override
    public int create(PatientData entity) {
        return 0;
    }

    @Override
    public int update(String s, PatientData entity) {
        return 0;
    }

    @Override
    public int delete(String s) {
        return 0;
    }
}
