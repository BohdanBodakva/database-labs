package ua.lviv.iot.database.lab4.dao.implementation;

import ua.lviv.iot.database.lab4.dao.CityDao;
import ua.lviv.iot.database.lab4.models.City;

import java.util.List;
import java.util.Optional;

public class CityDaoImpl implements CityDao {

    @Override
    public List<City> getAllCitiesFromRegionByRegionId(Integer regionId) {
        return null;
    }

    @Override
    public List<City> getAllCitiesByName(String cityName) {
        return null;
    }

    @Override
    public List<City> findAll() {
        return null;
    }

    @Override
    public Optional<City> findById(String s) {
        return Optional.empty();
    }

    @Override
    public int create(City entity) {
        return 0;
    }

    @Override
    public int update(String s, City entity) {
        return 0;
    }

    @Override
    public int delete(String s) {
        return 0;
    }
}
