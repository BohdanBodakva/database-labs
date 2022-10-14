package ua.lviv.iot.database.lab4.dao;

import ua.lviv.iot.database.lab4.models.Consultation;

import java.util.List;

public interface ConsultationDao extends ManyToManyDao<Consultation, Integer, Integer> {
    List<Consultation> getConsultationsOnDate(String date);
    List<Consultation> getAllConsultationsForPatient(Integer patientId);
    List<Consultation> getAllConsultationsForDoctor(Integer doctorId);
}
