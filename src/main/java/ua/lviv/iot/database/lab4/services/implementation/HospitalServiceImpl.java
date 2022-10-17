package ua.lviv.iot.database.lab4.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.database.lab4.dao.HospitalDao;
import ua.lviv.iot.database.lab4.models.Hospital;
import ua.lviv.iot.database.lab4.services.HospitalService;

import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService {
    private final HospitalDao hospitalDao;

    @Autowired
    public HospitalServiceImpl(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @Override
    public List<Hospital> findAll() {
        return hospitalDao.findAll();
    }

    @Override
    public Hospital findById(Integer id) {
        return hospitalDao.findById(id);
    }

    @Override
    public String create(Hospital hospital) {
        return hospitalDao.create(hospital);
    }

    @Override
    public String update(Integer id, Hospital hospital) {
        return hospitalDao.update(id, hospital);
    }

    @Override
    public String delete(Integer id) {
        return hospitalDao.delete(id);
    }

    @Override
    public List<Hospital> getAllHospitalsFromCityByCityId(String cityId) {
        return hospitalDao.getAllHospitalsFromCityByCityId(cityId);
    }

    @Override
    public List<Hospital> getAllHospitalsByName(String hospitalName) {
        return hospitalDao.getAllHospitalsByName(hospitalName);
    }
}
