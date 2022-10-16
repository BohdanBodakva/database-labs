package ua.lviv.iot.database.lab4.controllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.lviv.iot.database.lab4.controllers.ConsultationController;
import ua.lviv.iot.database.lab4.models.Consultation;
import ua.lviv.iot.database.lab4.services.ConsultationService;

import java.util.List;

@Controller
public class ConsultationControllerImpl implements ConsultationController {
    private final ConsultationService consultationService;

    @Autowired
    public ConsultationControllerImpl(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @Override
    public List<Consultation> findAll() {
        return consultationService.findAll();
    }

    @Override
    public Consultation findById(Integer doctorId, Integer patientId, String date) {
        return consultationService.findById(doctorId, patientId, date);
    }

    @Override
    public String create(Consultation consultation) {
        return consultationService.create(consultation);
    }

    @Override
    public String update(Integer doctorId, Integer patientId, String date, Consultation consultation) {
        return consultationService.update(doctorId, patientId, date, consultation);
    }

    @Override
    public String delete(Integer doctorId, Integer patientId, String date) {
        return consultationService.delete(doctorId, patientId, date);
    }

    @Override
    public List<Consultation> getConsultationsOnDate(String date) {
        return consultationService.getConsultationsOnDate(date);
    }

    @Override
    public List<Consultation> getAllConsultationsForPatient(Integer patientId) {
        return consultationService.getAllConsultationsForPatient(patientId);
    }

    @Override
    public List<Consultation> getAllConsultationsForDoctor(Integer doctorId) {
        return consultationService.getAllConsultationsForDoctor(doctorId);
    }
}
