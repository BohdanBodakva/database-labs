package ua.lviv.iot.database.lab4.controllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.lviv.iot.database.lab4.controllers.MedicineController;
import ua.lviv.iot.database.lab4.models.Medicine;
import ua.lviv.iot.database.lab4.services.MedicineService;

import java.util.List;

@Controller
public class MedicineControllerImpl implements MedicineController {

    private final MedicineService medicineService;

    @Autowired
    public MedicineControllerImpl(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @Override
    public List<Medicine> findAll() {
        return medicineService.findAll();
    }

    @Override
    public Medicine findById(String s) {
        return medicineService.findById(s);
    }

    @Override
    public int create(Medicine medicine) {
        return medicineService.create(medicine);
    }

    @Override
    public int update(String s, Medicine medicine) {
        return medicineService.update(s, medicine);
    }

    @Override
    public int delete(String s) {
        return medicineService.delete(s);
    }

    @Override
    public List<Medicine> getAllMedicineByName(String medicineName) {
        return medicineService.getAllMedicineByName(medicineName);
    }
}
