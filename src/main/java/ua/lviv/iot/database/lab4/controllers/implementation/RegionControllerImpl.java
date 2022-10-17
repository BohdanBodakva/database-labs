package ua.lviv.iot.database.lab4.controllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.lviv.iot.database.lab4.controllers.RegionController;
import ua.lviv.iot.database.lab4.models.Region;
import ua.lviv.iot.database.lab4.services.RegionService;

import java.util.List;

@Controller
public class RegionControllerImpl implements RegionController {

    private final RegionService regionService;

    @Autowired
    public RegionControllerImpl(RegionService regionService) {
        this.regionService = regionService;
    }

    @Override
    public List<Region> findAll() {
        return regionService.findAll();
    }

    @Override
    public Region findById(String s) {
        return regionService.findById(s);
    }

    @Override
    public String create(Region region) {
        return regionService.create(region);
    }

    @Override
    public String update(String s, Region region) {
        return regionService.update(s, region);
    }

    @Override
    public String delete(String s) {
        return regionService.delete(s);
    }

    @Override
    public List<Region> getAllRegionsByName(String regionName) {
        return regionService.getAllRegionsByName(regionName);
    }
}
