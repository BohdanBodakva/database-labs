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
    public Consultation findById(Integer doctorId, Integer patientId) {
        return consultationDao.findById(doctorId, patientId);
    }

    @Override
    public String create(Consultation consultation) {
        return consultationDao.create(consultation);
    }

    @Override
    public String update(Integer doctorId, Integer patientId, Consultation consultation) {
        return consultationDao.update(doctorId, patientId, consultation);
    }

    @Override
    public String delete(Integer doctorId, Integer patientId) {
        return consultationDao.delete(doctorId, patientId);
    }
}
