package ua.lviv.iot.database.lab4.dao;

import ua.lviv.iot.database.lab4.models.City;

import java.util.List;

public interface CityDao extends GeneralDao<City, String> {
    List<City> getAllCitiesFromRegionByRegionId(String regionId);
    List<City> getAllCitiesByName(String cityName);
}
