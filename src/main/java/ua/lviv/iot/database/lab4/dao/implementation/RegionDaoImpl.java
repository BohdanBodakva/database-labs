package ua.lviv.iot.database.lab4.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.database.lab4.dao.RegionDao;
import ua.lviv.iot.database.lab4.models.Medicine;
import ua.lviv.iot.database.lab4.models.Region;

import java.util.List;
import java.util.Optional;

@Repository
public class RegionDaoImpl implements RegionDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RegionDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String FIND_ALL = "select * from region";
    private static final String FIND_BY_ID = "select * from region where name=?";
    private static final String CREATE = "insert into region(name) values(?)";
    private static final String UPDATE = "update region set name=? where name=?";
    private static final String DELETE = "delete from region where name=?";

    private static final String FIND_ALL_REGIONS_BY_NAME = "select * from region where name like ?";

    @Override
    public List<Region> findAll() {
        return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(Region.class));
    }

    @Override
    public Region findById(String s) {
        Region region = null;

        try {
            region = jdbcTemplate.queryForObject(FIND_BY_ID,
                    Region.class, s);
        } catch (EmptyResultDataAccessException e){
            System.out.println("Region with name=" + s + " don't exist!");
        }

        return region;
    }

    @Override
    public String create(Region region) {
        int result = jdbcTemplate.update(CREATE, region.getName());
        if(result == 0){
            return "Region wasn't created";
        }
        return "Region " + region + " was successfully created";
    }

    @Override
    public String update(String s, Region region) {
        int result = jdbcTemplate.update(UPDATE, region.getName(), s);
        if(result == 0){
            return "Region wasn't updated";
        }
        return "Region with name=" + s + " was successfully updated";
    }

    @Override
    public String delete(String s) {
        int result = jdbcTemplate.update(DELETE, s);
        if(result == 0){
            return "Region wasn't deleted";
        }
        return "Region with name=" + s + " was successfully deleted";
    }

    @Override
    public List<Region> getAllRegionsByName(String regionName) {
        return jdbcTemplate.queryForList(FIND_ALL_REGIONS_BY_NAME,
                Region.class,
                "%" + regionName + "%");
    }
}
