package ua.lviv.iot.database.lab4.dao;

import ua.lviv.iot.database.lab4.models.City;
import ua.lviv.iot.database.lab4.models.Region;

import java.util.List;

public interface CityDao extends GeneralDao<City, String> {
    List<City> getAllCitiesFromRegionByRegionId(Integer regionId);
    List<City> getAllCitiesByName(String cityName);
}
