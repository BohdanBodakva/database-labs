package ua.lviv.iot.databases.lab5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.databases.lab5.entities.CityEntity;
import ua.lviv.iot.databases.lab5.entities.WorkPositionEntity;
import ua.lviv.iot.databases.lab5.services.CityService;

import java.util.List;

@RestController
@RequestMapping("api/databases/lab5/cities")
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/")
    public List<CityEntity> getAllCities(){
        return cityService.getAll();
    }

    @GetMapping("/{id}")
    public CityEntity getCityById(@PathVariable String id){
        return cityService.getById(id);
    }

    @PostMapping("/")
    public CityEntity createCity(@RequestBody CityEntity city){
        return cityService.create(city);
    }

    @PutMapping("/{id}")
    public CityEntity updateCity(@PathVariable String id, @RequestBody CityEntity city){
        return cityService.updateById(id, city);
    }

    @DeleteMapping("/{id}")
    public void deleteCityById(@PathVariable String id){
        cityService.deleteById(id);
    }

    @DeleteMapping("/")
    public void deleteAllCities(){
        cityService.deleteAll();
    }

    @GetMapping("/regions/{id}/cities")
    public List<CityEntity> getAllCitiesByRegionId(@PathVariable String id){
        return cityService.getCityEntitiesByRegionName(id);
    }
}
