package ua.lviv.iot.database.lab4.controllers;

import ua.lviv.iot.database.lab4.models.Patient;
import ua.lviv.iot.database.lab4.models.PatientData;

import java.util.List;

public interface PatientController extends GeneralController<Patient, Integer> {
    PatientData getPatientDataByPatientId(Integer patientId);
    List<Patient> getAllPatientsFromHospitalByHospitalId(Integer hospitalId);
    List<Patient> getAllPatientsBySurname(String patientSurname);
}
