package ua.lviv.iot.database.lab4.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.database.lab4.dao.PatientDataDao;
import ua.lviv.iot.database.lab4.models.PatientData;
import ua.lviv.iot.database.lab4.services.PatientDataService;

import java.util.List;

@Service
public class PatientDataServiceImpl implements PatientDataService {
    private final PatientDataDao patientDataDao;

    @Autowired
    public PatientDataServiceImpl(PatientDataDao patientDataDao) {
        this.patientDataDao = patientDataDao;
    }

    @Override
    public List<PatientData> findAll() {
        return patientDataDao.findAll();
    }

    @Override
    public PatientData findById(Integer id) {
        return patientDataDao.findById(id);
    }

    @Override
    public String create(PatientData patientData) {
        return patientDataDao.create(patientData);
    }

    @Override
    public String update(Integer id, PatientData patientData) {
        return patientDataDao.update(id, patientData);
    }

    @Override
    public String delete(Integer id) {
        return patientDataDao.delete(id);
    }
}
