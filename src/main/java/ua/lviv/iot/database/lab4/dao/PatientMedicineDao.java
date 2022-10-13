package ua.lviv.iot.database.lab4.dao;

import ua.lviv.iot.database.lab4.models.PatientMedicine;

public interface PatientMedicineDao extends ManyToManyDao<PatientMedicine, Integer, String> {
}
