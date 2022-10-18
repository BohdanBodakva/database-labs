package ua.lviv.iot.database.lab4.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.database.lab4.dao.CityDao;
import ua.lviv.iot.database.lab4.models.City;

import java.util.List;

@Repository
public class CityDaoImpl implements CityDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CityDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String FIND_ALL = "select * from city";
    private static final String FIND_BY_ID = "select * from city where name=?";
    private static final String CREATE = "insert into city(name, region_name) values(?, ?)";
    private static final String UPDATE = "update city set name=?, region_name=? where name=?";
    private static final String DELETE = "delete from city where name=?";

    private static final String FIND_ALL_CITIES_BY_NAME = "select * from city where name like ?";
    private static final String FIND_ALL_CITIES_FROM_REGION_BY_REGION_ID = "select * from city where region_name=?";

    @Override
    public List<City> getAllCitiesFromRegionByRegionId(String regionId) {
        return jdbcTemplate.query(FIND_ALL_CITIES_FROM_REGION_BY_REGION_ID,
                new BeanPropertyRowMapper<>(City.class),
                regionId);
    }

    @Override
    public List<City> getAllCitiesByName(String cityName) {
        return jdbcTemplate.query(FIND_ALL_CITIES_BY_NAME,
                new BeanPropertyRowMapper<>(City.class),
                "%" + cityName + "%");
    }

    @Override
    public List<City> findAll() {
        return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(City.class));
    }

    @Override
    public City findById(String s) {
        City city = null;

        try {
            city = jdbcTemplate.queryForObject(FIND_BY_ID,
                    City.class, s);
        } catch (EmptyResultDataAccessException e){
            System.out.println("City with name=" + s + " don't exist!");
        }

        return city;
    }

    @Override
    public String create(City city) {
        int result = jdbcTemplate.update(CREATE, city.getName(), city.getRegionName());
        if(result == 0){
            return "City wasn't created";
        }
        return "City " + city + " was successfully created";
    }

    @Override
    public String update(String s, City city) {
        int result = jdbcTemplate.update(UPDATE, city.getName(), city.getRegionName(), s);
        if(result == 0){
            return "City wasn't updated";
        }
        return "City with name=" + s + " was successfully updated";
    }

    @Override
    public String delete(String s) {
        int result = jdbcTemplate.update(DELETE, s);
        if(result == 0){
            return "City wasn't deleted";
        }
        return "City with name=" + s + " was successfully deleted";
    }
}
