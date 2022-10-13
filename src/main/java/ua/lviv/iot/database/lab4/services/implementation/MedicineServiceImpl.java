package ua.lviv.iot.database.lab4.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.database.lab4.dao.MedicineDao;
import ua.lviv.iot.database.lab4.models.Medicine;
import ua.lviv.iot.database.lab4.services.MedicineService;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    private final MedicineDao medicineDao;

    @Autowired
    public MedicineServiceImpl(MedicineDao medicineDao) {
        this.medicineDao = medicineDao;
    }

    @Override
    public List<Medicine> findAll() {
        return medicineDao.findAll();
    }

    @Override
    public Medicine findById(String s) {
        return medicineDao.findById(s);
    }

    @Override
    public int create(Medicine medicine) {
        return medicineDao.create(medicine);
    }

    @Override
    public int update(String s, Medicine medicine) {
        return medicineDao.update(s, medicine);
    }

    @Override
    public int delete(String s) {
        return medicineDao.delete(s);
    }

    @Override
    public List<Medicine> getAllMedicineByName(String medicineName) {
        return medicineDao.getAllMedicineByName(medicineName);
    }
}
