package ua.lviv.iot.database.lab4.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.database.lab4.dao.DiagnosisDao;
import ua.lviv.iot.database.lab4.models.Diagnosis;
import ua.lviv.iot.database.lab4.services.DiagnosisService;

import java.util.List;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

    private final DiagnosisDao diagnosisDao;

    @Autowired
    public DiagnosisServiceImpl(DiagnosisDao diagnosisDao) {
        this.diagnosisDao = diagnosisDao;
    }

    @Override
    public List<Diagnosis> getAllDiagnosisByName(String diagnosisName) {
        return diagnosisDao.getAllDiagnosisByName(diagnosisName);
    }

    @Override
    public List<Diagnosis> findAll() {
        return diagnosisDao.findAll();
    }

    @Override
    public Diagnosis findById(String s) {
        return diagnosisDao.findById(s);
    }

    @Override
    public String create(Diagnosis diagnosis) {
        return diagnosisDao.create(diagnosis);
    }

    @Override
    public String update(String s, Diagnosis diagnosis) {
        return diagnosisDao.update(s, diagnosis);
    }

    @Override
    public String delete(String s) {
        return diagnosisDao.delete(s);
    }
}
