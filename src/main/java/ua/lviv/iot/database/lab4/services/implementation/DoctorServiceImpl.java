package ua.lviv.iot.database.lab4.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.database.lab4.dao.DoctorDao;
import ua.lviv.iot.database.lab4.models.Doctor;
import ua.lviv.iot.database.lab4.services.DoctorService;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorDao doctorDao;

    @Autowired
    public DoctorServiceImpl(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    @Override
    public List<Doctor> getAllDoctorsBySurname(String doctorSurname) {
        return doctorDao.getAllDoctorsBySurname(doctorSurname);
    }

    @Override
    public List<Doctor> getAllDoctorsWithExperienceMoreThan(Integer experience) {
        return doctorDao.getAllDoctorsWithExperienceMoreThan(experience);
    }

    @Override
    public List<Doctor> findAll() {
        return doctorDao.findAll();
    }

    @Override
    public Doctor findById(Integer id) {
        return doctorDao.findById(id);
    }

    @Override
    public String create(Doctor doctor) {
        return doctorDao.create(doctor);
    }

    @Override
    public String update(Integer id, Doctor doctor) {
        return doctorDao.update(id, doctor);
    }

    @Override
    public String delete(Integer id) {
        return doctorDao.delete(id);
    }
}
