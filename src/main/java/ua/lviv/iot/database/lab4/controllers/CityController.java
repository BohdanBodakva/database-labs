package ua.lviv.iot.database.lab4.controllers;

import ua.lviv.iot.database.lab4.models.City;

import java.util.List;

public interface CityController extends GeneralController<City, String> {
    List<City> getAllCitiesFromRegionByRegionId(String regionId);
    List<City> getAllCitiesByName(String cityName);
}
