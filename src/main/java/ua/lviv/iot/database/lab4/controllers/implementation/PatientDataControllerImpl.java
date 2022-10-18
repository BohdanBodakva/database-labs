package ua.lviv.iot.database.lab4.controllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.lviv.iot.database.lab4.controllers.PatientDataController;
import ua.lviv.iot.database.lab4.models.PatientData;
import ua.lviv.iot.database.lab4.services.PatientDataService;

import java.util.List;

@Controller
public class PatientDataControllerImpl implements PatientDataController {
    private final PatientDataService patientDataService;

    @Autowired
    public PatientDataControllerImpl(PatientDataService patientDataService) {
        this.patientDataService = patientDataService;
    }

    @Override
    public List<PatientData> findAll() {
        return patientDataService.findAll();
    }

    @Override
    public PatientData findById(Integer id) {
        return patientDataService.findById(id);
    }

    @Override
    public String create(PatientData patientData) {
        return patientDataService.create(patientData);
    }

    @Override
    public String update(Integer id, PatientData patientData) {
        return patientDataService.update(id, patientData);
    }

    @Override
    public String delete(Integer id) {
        return patientDataService.delete(id);
    }
}
