package ua.lviv.iot.database.lab4.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.database.lab4.dao.PatientMedicineDao;
import ua.lviv.iot.database.lab4.models.PatientMedicine;
import ua.lviv.iot.database.lab4.services.PatientMedicineService;

import java.util.List;

@Service
public class PatientMedicineServiceImpl implements PatientMedicineService {
    private final PatientMedicineDao patientMedicineDao;

    @Autowired
    public PatientMedicineServiceImpl(PatientMedicineDao patientMedicineDao) {
        this.patientMedicineDao = patientMedicineDao;
    }

    @Override
    public List<PatientMedicine> findAll() {
        return patientMedicineDao.findAll();
    }

    @Override
    public PatientMedicine findById(Integer patientId, String medicineName) {
        return patientMedicineDao.findById(patientId, medicineName);
    }

    @Override
    public String create(PatientMedicine patientMedicine) {
        return patientMedicineDao.create(patientMedicine);
    }

    @Override
    public String update(Integer patientId, String medicineName, PatientMedicine patientMedicine) {
        return patientMedicineDao.update(patientId, medicineName, patientMedicine);
    }

    @Override
    public String delete(Integer patientId, String medicineName) {
        return patientMedicineDao.delete(patientId, medicineName);
    }
}
