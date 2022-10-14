package ua.lviv.iot.database.lab4.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.database.lab4.dao.DoctorPositionDao;
import ua.lviv.iot.database.lab4.models.Doctor;
import ua.lviv.iot.database.lab4.models.DoctorPosition;
import ua.lviv.iot.database.lab4.services.DoctorPositionService;

import java.util.List;

@Service
public class DoctorPositionServiceImpl implements DoctorPositionService {
    private final DoctorPositionDao doctorPositionDao;

    @Autowired
    public DoctorPositionServiceImpl(DoctorPositionDao doctorPositionDao) {
        this.doctorPositionDao = doctorPositionDao;

    }

    @Override
    public List<DoctorPosition> findAll() {
        return doctorPositionDao.findAll();
    }

    @Override
    public DoctorPosition findById(Integer doctorId, String positionName) {
        return doctorPositionDao.findById(doctorId, positionName);
    }

    @Override
    public String create(DoctorPosition doctorPosition) {
        return doctorPositionDao.create(doctorPosition);
    }

    @Override
    public String update(Integer doctorId, String positionName, DoctorPosition doctorPosition) {
        return doctorPositionDao.update(doctorId, positionName, doctorPosition);
    }

    @Override
    public String delete(Integer doctorId, String positionName) {
        return doctorPositionDao.delete(doctorId, positionName);
    }

    @Override
    public List<Doctor> doctorsOnPosition(String positionName) {
        return doctorPositionDao.doctorsOnPosition(positionName);
    }
}
