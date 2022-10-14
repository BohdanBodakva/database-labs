package ua.lviv.iot.database.lab4.dao;

import ua.lviv.iot.database.lab4.models.Patient;
import ua.lviv.iot.database.lab4.models.PatientMedicine;

import java.util.List;

public interface PatientMedicineDao extends ManyToManyDao<PatientMedicine, Integer, String> {
    List<Patient> patientsThatTakesMedicine(String medicineName);
}
