package ua.lviv.iot.database.lab4.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.database.lab4.dao.RegionDao;
import ua.lviv.iot.database.lab4.models.Region;
import ua.lviv.iot.database.lab4.services.RegionService;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    private final RegionDao regionDao;

    @Autowired
    public RegionServiceImpl(RegionDao regionDao) {
        this.regionDao = regionDao;
    }

    @Override
    public List<Region> findAll() {
        return regionDao.findAll();
    }

    @Override
    public Region findById(String s) {
        return regionDao.findById(s);
    }

    @Override
    public String create(Region region) {
        return regionDao.create(region);
    }

    @Override
    public String update(String s, Region region) {
        return regionDao.update(s, region);
    }

    @Override
    public String delete(String s) {
        return regionDao.delete(s);
    }

    @Override
    public List<Region> getAllRegionsByName(String regionName) {
        return regionDao.getAllRegionsByName(regionName);
    }
}
