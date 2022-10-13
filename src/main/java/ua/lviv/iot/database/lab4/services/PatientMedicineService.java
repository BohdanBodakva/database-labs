package ua.lviv.iot.database.lab4.services;

import ua.lviv.iot.database.lab4.dao.ManyToManyDao;
import ua.lviv.iot.database.lab4.models.PatientMedicine;

public interface PatientMedicineService extends ManyToManyService<PatientMedicine, Integer, String> {
}
