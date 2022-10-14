package ua.lviv.iot.database.lab4.controllers;

import ua.lviv.iot.database.lab4.models.Patient;
import ua.lviv.iot.database.lab4.models.PatientDiagnosis;

import java.util.List;

public interface PatientDiagnosisController extends ManyToManyController<PatientDiagnosis, Integer, String> {
    List<Patient> patientsWithDiagnosis(String diagnosisName);
}
