package ua.lviv.iot.database.lab4.controllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.lviv.iot.database.lab4.controllers.CityController;
import ua.lviv.iot.database.lab4.models.City;
import ua.lviv.iot.database.lab4.services.CityService;

import java.util.List;

@Controller
public class CityControllerImpl implements CityController {
    private final CityService cityService;

    @Autowired
    public CityControllerImpl(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    public List<City> getAllCitiesFromRegionByRegionId(String regionId) {
        return cityService.getAllCitiesFromRegionByRegionId(regionId);
    }

    @Override
    public List<City> getAllCitiesByName(String cityName) {
        return cityService.getAllCitiesByName(cityName);
    }

    @Override
    public List<City> findAll() {
        return cityService.findAll();
    }

    @Override
    public City findById(String s) {
        return cityService.findById(s);
    }

    @Override
    public String create(City city) {
        return cityService.create(city);
    }

    @Override
    public String update(String s, City city) {
        return cityService.update(s, city);
    }

    @Override
    public String delete(String s) {
        return cityService.delete(s);
    }
}
