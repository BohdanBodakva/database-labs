package ua.lviv.iot.database.lab4.services;

import ua.lviv.iot.database.lab4.models.Consultation;

import java.util.List;

public interface ConsultationService extends ManyToManyService<Consultation, Integer, Integer> {
    List<Consultation> getConsultationsOnDate(String date);
    List<Consultation> getAllConsultationsForPatient(Integer patientId);
    List<Consultation> getAllConsultationsForDoctor(Integer doctorId);
}
