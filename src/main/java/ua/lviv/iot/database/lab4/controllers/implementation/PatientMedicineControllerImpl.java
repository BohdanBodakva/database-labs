package ua.lviv.iot.database.lab4.controllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.lviv.iot.database.lab4.controllers.PatientMedicineController;
import ua.lviv.iot.database.lab4.models.Patient;
import ua.lviv.iot.database.lab4.models.PatientMedicine;
import ua.lviv.iot.database.lab4.services.PatientMedicineService;

import java.util.List;

@Controller
public class PatientMedicineControllerImpl implements PatientMedicineController {
    private final PatientMedicineService patientMedicineService;

    @Autowired
    public PatientMedicineControllerImpl(PatientMedicineService patientMedicineService) {
        this.patientMedicineService = patientMedicineService;
    }

    @Override
    public List<PatientMedicine> findAll() {
        return patientMedicineService.findAll();
    }

    @Override
    public PatientMedicine findById(Integer patientId, String medicineName) {
        return patientMedicineService.findById(patientId, medicineName);
    }

    @Override
    public String create(PatientMedicine patientMedicine) {
        return patientMedicineService.create(patientMedicine);
    }

    @Override
    public String update(Integer patientId, String medicineName, PatientMedicine patientMedicine) {
        return patientMedicineService.update(patientId, medicineName, patientMedicine);
    }

    @Override
    public String delete(Integer patientId, String medicineName) {
        return patientMedicineService.delete(patientId, medicineName);
    }

    @Override
    public List<Patient> patientsThatTakesMedicine(String medicineName) {
        return patientMedicineService.patientsThatTakesMedicine(medicineName);
    }
}
