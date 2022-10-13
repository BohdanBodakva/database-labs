package ua.lviv.iot.database.lab4.controllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.lviv.iot.database.lab4.controllers.DiagnosisController;
import ua.lviv.iot.database.lab4.models.Diagnosis;
import ua.lviv.iot.database.lab4.services.DiagnosisService;

import java.util.List;

@Controller
public class DiagnosisControllerImpl implements DiagnosisController {
    private final DiagnosisService diagnosisService;

    @Autowired
    public DiagnosisControllerImpl(DiagnosisService diagnosisService) {
        this.diagnosisService = diagnosisService;
    }

    @Override
    public List<Diagnosis> getAllDiagnosisByName(String diagnosisName) {
        return diagnosisService.getAllDiagnosisByName(diagnosisName);
    }

    @Override
    public List<Diagnosis> findAll() {
        return diagnosisService.findAll();
    }

    @Override
    public Diagnosis findById(String s) {
        return diagnosisService.findById(s);
    }

    @Override
    public String create(Diagnosis diagnosis) {
        return diagnosisService.create(diagnosis);
    }

    @Override
    public String update(String s, Diagnosis diagnosis) {
        return diagnosisService.update(s, diagnosis);
    }

    @Override
    public String delete(String s) {
        return diagnosisService.delete(s);
    }
}
