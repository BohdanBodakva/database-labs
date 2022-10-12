package ua.lviv.iot.database.lab4.dao.implementation;

import ua.lviv.iot.database.lab4.dao.RegionDao;
import ua.lviv.iot.database.lab4.models.Region;

import java.util.List;
import java.util.Optional;

public class RegionDaoImpl implements RegionDao {
    @Override
    public List<Region> findAll() {
        return null;
    }

    @Override
    public Optional<Region> findById(String s) {
        return Optional.empty();
    }

    @Override
    public int create(Region entity) {
        return 0;
    }

    @Override
    public int update(String s, Region entity) {
        return 0;
    }

    @Override
    public int delete(String s) {
        return 0;
    }

    @Override
    public List<Region> getAllRegionsByName(String regionName) {
        return null;
    }
}
