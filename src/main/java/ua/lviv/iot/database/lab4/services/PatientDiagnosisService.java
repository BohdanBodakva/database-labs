package ua.lviv.iot.database.lab4.services;

import ua.lviv.iot.database.lab4.models.Patient;
import ua.lviv.iot.database.lab4.models.PatientDiagnosis;

import java.util.List;

public interface PatientDiagnosisService extends ManyToManyService<PatientDiagnosis, Integer, String> {
    List<Patient> patientsWithDiagnosis(String diagnosisName);
}
