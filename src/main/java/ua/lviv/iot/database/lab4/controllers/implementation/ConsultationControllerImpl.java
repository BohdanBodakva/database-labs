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
    public Consultation findById(Integer doctorId, Integer patientId) {
        return consultationService.findById(doctorId, patientId);
    }

    @Override
    public String create(Consultation consultation) {
        return consultationService.create(consultation);
    }

    @Override
    public String update(Integer doctorId, Integer patientId, Consultation consultation) {
        return consultationService.update(doctorId, patientId, consultation);
    }

    @Override
    public String delete(Integer doctorId, Integer patientId) {
        return consultationService.delete(doctorId, patientId);
    }
}
