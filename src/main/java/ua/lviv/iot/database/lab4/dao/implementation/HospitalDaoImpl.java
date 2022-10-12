package ua.lviv.iot.database.lab4.dao.implementation;

import ua.lviv.iot.database.lab4.dao.HospitalDao;
import ua.lviv.iot.database.lab4.models.Hospital;

import java.util.List;
import java.util.Optional;

public class HospitalDaoImpl implements HospitalDao {
    @Override
    public List<Hospital> findAll() {
        return null;
    }

    @Override
    public Optional<Hospital> findById(String s) {
        return Optional.empty();
    }

    @Override
    public int create(Hospital entity) {
        return 0;
    }

    @Override
    public int update(String s, Hospital entity) {
        return 0;
    }

    @Override
    public int delete(String s) {
        return 0;
    }

    @Override
    public List<Hospital> getAllHospitalsFromCityByCityId(Integer cityId) {
        return null;
    }

    @Override
    public List<Hospital> getAllHospitalsByName(String hospitalName) {
        return null;
    }
}
