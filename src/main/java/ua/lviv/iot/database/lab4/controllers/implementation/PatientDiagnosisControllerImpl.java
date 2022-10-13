package ua.lviv.iot.database.lab4.controllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.lviv.iot.database.lab4.controllers.PatientDiagnosisController;
import ua.lviv.iot.database.lab4.models.PatientDiagnosis;
import ua.lviv.iot.database.lab4.services.PatientDiagnosisService;

import java.util.List;

@Controller
public class PatientDiagnosisControllerImpl implements PatientDiagnosisController {
    private final PatientDiagnosisService patientDiagnosisService;

    @Autowired
    public PatientDiagnosisControllerImpl(PatientDiagnosisService patientDiagnosisService) {
        this.patientDiagnosisService = patientDiagnosisService;
    }

    @Override
    public List<PatientDiagnosis> findAll() {
        return patientDiagnosisService.findAll();
    }

    @Override
    public PatientDiagnosis findById(Integer patientId, String diagnosisName) {
        return patientDiagnosisService.findById(patientId, diagnosisName);
    }

    @Override
    public String create(PatientDiagnosis patientDiagnosis) {
        return patientDiagnosisService.create(patientDiagnosis);
    }

    @Override
    public String update(Integer patientId, String diagnosisName, PatientDiagnosis patientDiagnosis) {
        return patientDiagnosisService.update(patientId, diagnosisName, patientDiagnosis);
    }

    @Override
    public String delete(Integer patientId, String diagnosisName) {
        return patientDiagnosisService.delete(patientId, diagnosisName);
    }
}
