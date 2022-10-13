package ua.lviv.iot.database.lab4.services;

import ua.lviv.iot.database.lab4.models.City;

import java.util.List;

public interface CityService extends GeneralService<City, String> {
    List<City> getAllCitiesFromRegionByRegionId(Integer regionId);
    List<City> getAllCitiesByName(String cityName);
}
