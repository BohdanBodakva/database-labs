package ua.lviv.iot.database.lab4.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.database.lab4.dao.CityDao;
import ua.lviv.iot.database.lab4.models.City;
import ua.lviv.iot.database.lab4.services.CityService;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    private final CityDao cityDao;

    @Autowired
    public CityServiceImpl(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public List<City> getAllCitiesFromRegionByRegionId(String regionId) {
        return cityDao.getAllCitiesFromRegionByRegionId(regionId);
    }

    @Override
    public List<City> getAllCitiesByName(String cityName) {
        return cityDao.getAllCitiesByName(cityName);
    }

    @Override
    public List<City> findAll() {
        return cityDao.findAll();
    }

    @Override
    public City findById(String s) {
        return cityDao.findById(s);
    }

    @Override
    public String create(City city) {
        return cityDao.create(city);
    }

    @Override
    public String update(String s, City city) {
        return cityDao.update(s, city);
    }

    @Override
    public String delete(String s) {
        return cityDao.delete(s);
    }
}
