package ua.lviv.iot.database.lab4.controllers;

import ua.lviv.iot.database.lab4.models.Patient;
import ua.lviv.iot.database.lab4.models.PatientMedicine;

import java.util.List;

public interface PatientMedicineController extends ManyToManyController<PatientMedicine, Integer, String> {
    List<Patient> patientsThatTakesMedicine(String medicineName);
}
