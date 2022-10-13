package ua.lviv.iot.database.lab4.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.database.lab4.dao.PatientDao;
import ua.lviv.iot.database.lab4.models.Patient;
import ua.lviv.iot.database.lab4.models.PatientData;
import ua.lviv.iot.database.lab4.services.PatientService;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public List<Patient> findAll() {
        return patientDao.findAll();
    }

    @Override
    public Patient findById(Integer id) {
        return patientDao.findById(id);
    }

    @Override
    public String create(Patient patient) {
        return patientDao.create(patient);
    }

    @Override
    public String update(Integer id, Patient patient) {
        return patientDao.update(id, patient);
    }

    @Override
    public String delete(Integer id) {
        return patientDao.delete(id);
    }

    @Override
    public PatientData getPatientDataByPatientId(Integer patientId) {
        return patientDao.getPatientDataByPatientId(patientId);
    }

    @Override
    public List<Patient> getAllPatientsFromHospitalByHospitalId(Integer hospitalId) {
        return patientDao.getAllPatientsFromHospitalByHospitalId(hospitalId);
    }

    @Override
    public List<Patient> getAllPatientsBySurname(String patientSurname) {
        return patientDao.getAllPatientsBySurname(patientSurname);
    }
}
