package ua.lviv.iot.database.lab4.services;

import ua.lviv.iot.database.lab4.models.Medicine;

import java.util.List;

public interface MedicineService extends GeneralService<Medicine, String>{
    List<Medicine> getAllMedicineByName(String medicineName);
}
