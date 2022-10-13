package ua.lviv.iot.database.lab4.dao.implementation;

import org.springframework.stereotype.Repository;
import ua.lviv.iot.database.lab4.models.Diagnosis;
import ua.lviv.iot.database.lab4.dao.DiagnosisDao;

import java.util.List;
import java.util.Optional;

@Repository
public class DiagnosisDaoImpl implements DiagnosisDao {

    @Override
    public List<Diagnosis> getAllDiagnosisByName(String diagnosisName) {
        return null;
    }

    @Override
    public List<Diagnosis> findAll() {
        return null;
    }

    @Override
    public Diagnosis findById(String s) {
        return null;
    }

    @Override
    public int create(Diagnosis entity) {
        return 0;
    }

    @Override
    public int update(String s, Diagnosis entity) {
        return 0;
    }

    @Override
    public int delete(String s) {
        return 0;
    }
}
