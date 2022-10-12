package ua.lviv.iot.database.lab4.dao;


import ua.lviv.iot.database.lab4.models.Region;

import java.util.List;

public interface RegionDao extends GeneralDao<Region, String> {
    List<Region> getAllRegionsByName(String regionName);
}
