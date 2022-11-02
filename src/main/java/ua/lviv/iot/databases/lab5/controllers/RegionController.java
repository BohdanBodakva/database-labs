package ua.lviv.iot.databases.lab5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.databases.lab5.entities.CityEntity;
import ua.lviv.iot.databases.lab5.entities.RegionEntity;
import ua.lviv.iot.databases.lab5.services.CityService;
import ua.lviv.iot.databases.lab5.services.RegionService;

import java.util.List;

@RestController
@RequestMapping("api/databases/lab5/regions")
public class RegionController {
    private final RegionService regionService;
    private final CityService cityService;

    @Autowired
    public RegionController(RegionService regionService, CityService cityService) {
        this.regionService = regionService;
        this.cityService = cityService;
    }

    @GetMapping("/")
    public List<RegionEntity> getAllRegions(){
        return regionService.getAll();
    }

    @GetMapping("/{id}")
    public RegionEntity getRegionById(@PathVariable String id){
        return regionService.getById(id);
    }

    @PostMapping("/")
    public RegionEntity createRegion(@RequestBody RegionEntity region){
        return regionService.create(region);
    }

//    @PutMapping("/{id}")
//    public RegionEntity updateRegion(@PathVariable String id, @RequestBody RegionEntity region){
//        return regionService.updateById(id, region);
//    }

    @DeleteMapping("/{id}")
    public void deleteRegion(@PathVariable String id){
        regionService.deleteById(id);
    }

    @DeleteMapping("/")
    public void deleteAllRegions(){
        regionService.deleteAll();
    }

    @GetMapping("/{id}/cities")
    public List<CityEntity> getAllCitiesByRegionId(@PathVariable String id){
        return cityService.getCityEntitiesByRegionName(id);
    }
}
