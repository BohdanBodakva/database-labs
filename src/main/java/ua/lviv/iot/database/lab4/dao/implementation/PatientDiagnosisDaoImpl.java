package ua.lviv.iot.database.lab4.dao.implementation;

import org.springframework.stereotype.Repository;
import ua.lviv.iot.database.lab4.dao.PatientDiagnosisDao;
import ua.lviv.iot.database.lab4.models.PatientDiagnosis;

import java.util.List;
import java.util.Optional;

@Repository
public class PatientDiagnosisDaoImpl implements PatientDiagnosisDao {
    @Override
    public List<PatientDiagnosis> findAll() {
        return null;
    }

    @Override
    public Optional<PatientDiagnosis> findById(Integer integer, String s) {
        return Optional.empty();
    }

    @Override
    public int create(PatientDiagnosis entity) {
        return 0;
    }

    @Override
    public int update(Integer integer, String s, PatientDiagnosis entity) {
        return 0;
    }

    @Override
    public int delete(Integer integer, String s) {
        return 0;
    }
}
