package ua.lviv.iot.database.lab4.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.database.lab4.dao.ConsultationDao;
import ua.lviv.iot.database.lab4.models.Consultation;
import ua.lviv.iot.database.lab4.services.ConsultationService;

import java.util.List;

@Service
public class ConsultationServiceImpl implements ConsultationService {
    private final ConsultationDao consultationDao;

    @Autowired
    public ConsultationServiceImpl(ConsultationDao consultationDao) {
        this.consultationDao = consultationDao;
    }

    @Override
    public List<Consultation> findAll() {
        return consultationDao.findAll();
    }

    @Override
    public Consultation findById(Integer doctorId, Integer patientId, String date) {
        return consultationDao.findById(doctorId, patientId, date);
    }

    @Override
    public String create(Consultation consultation) {
        return consultationDao.create(consultation);
    }

    @Override
    public String update(Integer doctorId, Integer patientId, String date, Consultation consultation) {
        return consultationDao.update(doctorId, patientId, date, consultation);
    }

    @Override
    public String delete(Integer doctorId, Integer patientId, String date) {
        return consultationDao.delete(doctorId, patientId, date);
    }

    @Override
    public List<Consultation> getConsultationsOnDate(String date) {
        return consultationDao.getConsultationsOnDate(date);
    }

    @Override
    public List<Consultation> getAllConsultationsForPatient(Integer patientId) {
        return consultationDao.getAllConsultationsForPatient(patientId);
    }

    @Override
    public List<Consultation> getAllConsultationsForDoctor(Integer doctorId) {
        return consultationDao.getAllConsultationsForDoctor(doctorId);
    }
}
