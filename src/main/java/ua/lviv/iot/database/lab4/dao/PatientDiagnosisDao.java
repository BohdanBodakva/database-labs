package ua.lviv.iot.database.lab4.dao;

import ua.lviv.iot.database.lab4.models.Diagnosis;
import ua.lviv.iot.database.lab4.models.Patient;
import ua.lviv.iot.database.lab4.models.PatientDiagnosis;

import java.util.List;

public interface PatientDiagnosisDao extends ManyToManyDao<PatientDiagnosis, Integer, String> {
    List<Patient> patientsWithDiagnosis(String diagnosisName);
}
