package ua.lviv.iot.database.lab4.dao.implementation;

import org.springframework.stereotype.Repository;
import ua.lviv.iot.database.lab4.dao.PatientDataDao;
import ua.lviv.iot.database.lab4.models.PatientData;

import java.util.List;
import java.util.Optional;

@Repository
public class PatientDataDaoImpl implements PatientDataDao {
    @Override
    public List<PatientData> findAll() {
        return null;
    }

    @Override
    public PatientData findById(String s) {
        return null;
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
