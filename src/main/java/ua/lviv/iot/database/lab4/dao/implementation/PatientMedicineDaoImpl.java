package ua.lviv.iot.database.lab4.dao.implementation;

import org.springframework.stereotype.Repository;
import ua.lviv.iot.database.lab4.dao.PatientMedicineDao;
import ua.lviv.iot.database.lab4.models.PatientMedicine;

import java.util.List;
import java.util.Optional;

@Repository
public class PatientMedicineDaoImpl implements PatientMedicineDao {
    @Override
    public List<PatientMedicine> findAll() {
        return null;
    }

    @Override
    public Optional<PatientMedicine> findById(Integer integer, String s) {
        return Optional.empty();
    }

    @Override
    public int create(PatientMedicine entity) {
        return 0;
    }

    @Override
    public int update(Integer integer, String s, PatientMedicine entity) {
        return 0;
    }

    @Override
    public int delete(Integer integer, String s) {
        return 0;
    }
}
