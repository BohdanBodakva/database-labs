package ua.lviv.iot.database.lab4.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.database.lab4.dao.HospitalDao;
import ua.lviv.iot.database.lab4.models.Hospital;
import ua.lviv.iot.database.lab4.models.Medicine;

import java.util.List;
import java.util.Optional;

@Repository
public class HospitalDaoImpl implements HospitalDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HospitalDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String FIND_ALL = "select * from hospital";
    private static final String FIND_BY_ID = "select * from hospital where id=?";
    private static final String CREATE = "insert into hospital(name, address, city_name) values(?, ?, ?)";
    private static final String UPDATE = "update hospital set name=?, address=?, city_name=? where id=?";
    private static final String DELETE = "delete from hospital where id=?";

    private static final String FIND_ALL_HOSPITALS_BY_NAME = "select * from hospital where name like ?";
    private static final String FIND_ALL_HOSPITALS_FROM_CITY_BY_CITY_ID =
                                     "select * from hospital where city_name=?";

    @Override
    public List<Hospital> findAll() {
        return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(Hospital.class));
    }

    @Override
    public Hospital findById(Integer id) {
        Hospital hospital = null;

        try {
            hospital = jdbcTemplate.query(FIND_BY_ID,
                    new BeanPropertyRowMapper<>(Hospital.class), id)
                    .stream().findFirst().get();
        } catch (EmptyResultDataAccessException e){
            System.out.println("Hospital with id=" + id + " don't exist!");
        }

        return hospital;
    }

    @Override
    public String create(Hospital hospital) {
        int result = jdbcTemplate.update(CREATE, hospital.getName(),
                                                    hospital.getAddress(),
                                                    hospital.getCityName());
        if(result == 0){
            return "Hospital wasn't created";
        }
        return "Hospital " + hospital + " was successfully created";
    }

    @Override
    public String update(Integer id, Hospital hospital) {
        int result = jdbcTemplate.update(UPDATE, hospital.getName(),
                                                    hospital.getAddress(),
                                                    hospital.getCityName(), id);
        if(result == 0){
            return "Hospital wasn't updated";
        }
        return "Hospital with id=" + id + " was successfully updated";
    }

    @Override
    public String delete(Integer id) {
        int result = jdbcTemplate.update(DELETE, id);
        if(result == 0){
            return "Hospital wasn't deleted";
        }
        return "Hospital with name=" + id + " was successfully deleted";
    }

    @Override
    public List<Hospital> getAllHospitalsFromCityByCityId(String cityId) {
        return jdbcTemplate.query(FIND_ALL_HOSPITALS_FROM_CITY_BY_CITY_ID,
                new BeanPropertyRowMapper<>(Hospital.class),
                cityId);
    }

    @Override
    public List<Hospital> getAllHospitalsByName(String hospitalName) {
        return jdbcTemplate.query(FIND_ALL_HOSPITALS_BY_NAME,
                new BeanPropertyRowMapper<>(Hospital.class),
                "%" + hospitalName + "%");
    }
}
