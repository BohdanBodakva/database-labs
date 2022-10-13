package ua.lviv.iot.database.lab4.dao.implementation;

import org.springframework.stereotype.Repository;
import ua.lviv.iot.database.lab4.dao.PatientDao;
import ua.lviv.iot.database.lab4.models.Patient;
import ua.lviv.iot.database.lab4.models.PatientData;

import java.util.List;
import java.util.Optional;

@Repository
public class PatientDaoImpl implements PatientDao {
    @Override
    public List<Patient> findAll() {
        return null;
    }

    @Override
    public Patient findById(String s) {
        return null;
    }

    @Override
    public int create(Patient entity) {
        return 0;
    }

    @Override
    public int update(String s, Patient entity) {
        return 0;
    }

    @Override
    public int delete(String s) {
        return 0;
    }

    @Override
    public PatientData getPatientDataByPatientId(Integer patientId) {
        return null;
    }

    @Override
    public List<Patient> getAllPatientsFromHospitalByHospitalId(Integer hospitalId) {
        return null;
    }

    @Override
    public List<Patient> getAllPatientsBySurname(String patientSurname) {
        return null;
    }
}
