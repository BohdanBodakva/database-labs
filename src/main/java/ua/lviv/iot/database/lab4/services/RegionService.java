package ua.lviv.iot.database.lab4.services;

import ua.lviv.iot.database.lab4.models.Medicine;
import ua.lviv.iot.database.lab4.models.Region;

import java.util.List;

public interface RegionService extends GeneralService<Region, String> {
    List<Region> getAllRegionsByName(String regionName);
}
