package ua.lviv.iot.database.lab4.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.database.lab4.dao.PatientDiagnosisDao;
import ua.lviv.iot.database.lab4.models.Patient;
import ua.lviv.iot.database.lab4.models.PatientDiagnosis;
import ua.lviv.iot.database.lab4.services.PatientDiagnosisService;

import java.util.List;

@Service
public class PatientDiagnosisServiceImpl implements PatientDiagnosisService {
    private final PatientDiagnosisDao patientDiagnosisDao;

    @Autowired
    public PatientDiagnosisServiceImpl(PatientDiagnosisDao patientDiagnosisDao) {
        this.patientDiagnosisDao = patientDiagnosisDao;
    }

    @Override
    public List<PatientDiagnosis> findAll() {
        return patientDiagnosisDao.findAll();
    }

    @Override
    public PatientDiagnosis findById(Integer patientId, String diagnosisName) {
        return patientDiagnosisDao.findById(patientId, diagnosisName);
    }

    @Override
    public String create(PatientDiagnosis patientDiagnosis) {
        return patientDiagnosisDao.create(patientDiagnosis);
    }

    @Override
    public String update(Integer patientId, String diagnosisName, PatientDiagnosis patientDiagnosis) {
        return patientDiagnosisDao.update(patientId, diagnosisName, patientDiagnosis);
    }

    @Override
    public String delete(Integer patientId, String diagnosisName) {
        return patientDiagnosisDao.delete(patientId, diagnosisName);
    }

    @Override
    public List<Patient> patientsWithDiagnosis(String diagnosisName) {
        return patientDiagnosisDao.patientsWithDiagnosis(diagnosisName);
    }
}
