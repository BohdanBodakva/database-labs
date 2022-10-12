package ua.lviv.iot.database.lab4.dao.implementation;

import ua.lviv.iot.database.lab4.dao.MedicineDao;
import ua.lviv.iot.database.lab4.models.Medicine;

import java.util.List;
import java.util.Optional;

public class MedicineDaoImpl implements MedicineDao {
    @Override
    public List<Medicine> findAll() {
        return null;
    }

    @Override
    public Optional<Medicine> findById(String s) {
        return Optional.empty();
    }

    @Override
    public int create(Medicine entity) {
        return 0;
    }

    @Override
    public int update(String s, Medicine entity) {
        return 0;
    }

    @Override
    public int delete(String s) {
        return 0;
    }

    @Override
    public List<Medicine> getAllMedicineByName(String medicineName) {
        return null;
    }
}
