package ua.lviv.iot.database.lab4.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.database.lab4.dao.PatientDataDao;
import ua.lviv.iot.database.lab4.models.Medicine;
import ua.lviv.iot.database.lab4.models.PatientData;

import java.util.List;

@Repository
public class PatientDataDaoImpl implements PatientDataDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PatientDataDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String FIND_ALL = "select * from data";
    private static final String FIND_BY_ID = "select * from data where id=?";
    private static final String CREATE =
            "insert into data(temperature_in_celsius," +
                            "systolic_pressure," +
                            "diastolic_pressure," +
                            "heart_rate_in_minute," +
                            "special_notes) values(?, ?, ?, ?, ?, ?)";
    private static final String UPDATE =
            "update data set temperature_in_celsius=?," +
                            "systolic_pressure=?," +
                            "diastolic_pressure=?," +
                            "heart_rate_in_minute=?," +
                            "special_notes=? where id=?";
    private static final String DELETE = "delete from data where id=?";

    @Override
    public List<PatientData> findAll() {
        return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(PatientData.class));
    }

    @Override
    public PatientData findById(Integer id) {
        PatientData patientData = null;

        try {
            patientData = jdbcTemplate.queryForObject(FIND_BY_ID,
                    PatientData.class, id);
        } catch (EmptyResultDataAccessException e){
            System.out.println("Data with name=" + id + " don't exist!");
        }

        return patientData;
    }

    @Override
    public String create(PatientData patientData) {
        int result = jdbcTemplate
                .update(CREATE, patientData.getTemperatureInCelsius(),
                                patientData.getSystolicPressure(),
                                patientData.getDiastolicPressure(),
                                patientData.getHeartRateInMinute(),
                                patientData.getSpecialNotes());
        if(result == 0){
            return "Data wasn't created";
        }
        return "Data " + patientData + " was successfully created";
    }

    @Override
    public String update(Integer id, PatientData patientData) {
        int result = jdbcTemplate.update(UPDATE, patientData.getTemperatureInCelsius(),
                                                    patientData.getSystolicPressure(),
                                                    patientData.getDiastolicPressure(),
                                                    patientData.getHeartRateInMinute(),
                                                    patientData.getSpecialNotes(), id);
        if(result == 0){
            return "Data wasn't updated";
        }
        return "Data with name=" + id + " was successfully updated";
    }

    @Override
    public String delete(Integer id) {
        int result = jdbcTemplate.update(DELETE, id);
        if(result == 0){
            return "Data wasn't deleted";
        }
        return "Data with name=" + id + " was successfully deleted";
    }
}
