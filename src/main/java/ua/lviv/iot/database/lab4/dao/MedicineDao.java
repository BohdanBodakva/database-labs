package ua.lviv.iot.database.lab4.dao;

import ua.lviv.iot.database.lab4.models.Medicine;

import java.util.List;

public interface MedicineDao extends GeneralDao<Medicine, String>{
    List<Medicine> getAllMedicineByName(String medicineName);
}
