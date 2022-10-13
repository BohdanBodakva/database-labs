package ua.lviv.iot.database.lab4.dao.implementation;

import org.springframework.stereotype.Repository;
import ua.lviv.iot.database.lab4.dao.DoctorDao;
import ua.lviv.iot.database.lab4.models.Doctor;

import java.util.List;
import java.util.Optional;

@Repository
public class DoctorDaoImpl implements DoctorDao {
    @Override
    public List<Doctor> getAllDoctorsBySurname(String doctorSurname) {
        return null;
    }

    @Override
    public List<Doctor> findAll() {
        return null;
    }

    @Override
    public Doctor findById(String s) {
        return null;
    }

    @Override
    public int create(Doctor entity) {
        return 0;
    }

    @Override
    public int update(String s, Doctor entity) {
        return 0;
    }

    @Override
    public int delete(String s) {
        return 0;
    }
}
