package ua.lviv.iot.database.lab4.controllers;

import ua.lviv.iot.database.lab4.models.Medicine;
import ua.lviv.iot.database.lab4.models.Region;

import java.util.List;

public interface RegionController extends GeneralController<Region, String> {
    List<Region> getAllRegionsByName(String regionName);
}
