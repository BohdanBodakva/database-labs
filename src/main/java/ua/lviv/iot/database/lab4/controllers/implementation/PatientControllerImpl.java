package ua.lviv.iot.database.lab4.controllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.lviv.iot.database.lab4.controllers.PatientController;
import ua.lviv.iot.database.lab4.models.Patient;
import ua.lviv.iot.database.lab4.models.PatientData;
import ua.lviv.iot.database.lab4.services.PatientService;

import java.util.List;

@Controller
public class PatientControllerImpl implements PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientControllerImpl(PatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    public List<Patient> findAll() {
        return patientService.findAll();
    }

    @Override
    public Patient findById(Integer id) {
        return patientService.findById(id);
    }

    @Override
    public String create(Patient patient) {
        return patientService.create(patient);
    }

    @Override
    public String update(Integer id, Patient patient) {
        return patientService.update(id, patient);
    }

    @Override
    public String delete(Integer id) {
        return patientService.delete(id);
    }

    @Override
    public PatientData getPatientDataByPatientId(Integer patientId) {
        return patientService.getPatientDataByPatientId(patientId);
    }

    @Override
    public List<Patient> getAllPatientsFromHospitalByHospitalId(Integer hospitalId) {
        return patientService.getAllPatientsFromHospitalByHospitalId(hospitalId);
    }

    @Override
    public List<Patient> getAllPatientsBySurname(String patientSurname) {
        return patientService.getAllPatientsBySurname(patientSurname);
    }
}
