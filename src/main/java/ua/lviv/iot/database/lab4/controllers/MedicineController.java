package ua.lviv.iot.database.lab4.controllers;

import ua.lviv.iot.database.lab4.models.Medicine;

import java.util.List;

public interface MedicineController extends GeneralController<Medicine, String> {
    List<Medicine> getAllMedicineByName(String medicineName);
}
