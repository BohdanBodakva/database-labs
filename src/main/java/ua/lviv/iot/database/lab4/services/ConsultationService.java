package ua.lviv.iot.database.lab4.services;

import ua.lviv.iot.database.lab4.models.Consultation;

import java.util.List;

public interface ConsultationService {
    List<Consultation> findAll();

    Consultation findById(Integer doctorId, Integer patientId, String date);

    String create(Consultation consultation);

    String update(Integer doctorId, Integer patientId, String date, Consultation consultation);

    String delete(Integer doctorId, Integer patientId, String date);
    List<Consultation> getConsultationsOnDate(String date);
    List<Consultation> getAllConsultationsForPatient(Integer patientId);
    List<Consultation> getAllConsultationsForDoctor(Integer doctorId);
}
