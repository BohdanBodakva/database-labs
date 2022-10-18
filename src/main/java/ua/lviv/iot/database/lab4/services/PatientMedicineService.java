package ua.lviv.iot.database.lab4.services;

import ua.lviv.iot.database.lab4.models.Patient;
import ua.lviv.iot.database.lab4.models.PatientMedicine;

import java.util.List;

public interface PatientMedicineService extends ManyToManyService<PatientMedicine, Integer, String> {
    List<Patient> patientsThatTakesMedicine(String medicineName);
}
