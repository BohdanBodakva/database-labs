package ua.lviv.iot.database.lab4.services;

import ua.lviv.iot.database.lab4.models.Patient;
import ua.lviv.iot.database.lab4.models.PatientData;

import java.util.List;

public interface PatientService extends GeneralService<Patient, Integer> {
    PatientData getPatientDataByPatientId(Integer patientId);
    List<Patient> getAllPatientsFromHospitalByHospitalId(Integer hospitalId);
    List<Patient> getAllPatientsBySurname(String patientSurname);
}
