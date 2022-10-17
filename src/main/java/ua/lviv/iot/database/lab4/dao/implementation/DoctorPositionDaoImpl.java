package ua.lviv.iot.database.lab4.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.database.lab4.dao.DoctorPositionDao;
import ua.lviv.iot.database.lab4.models.Doctor;
import ua.lviv.iot.database.lab4.models.DoctorPosition;

import java.util.List;

@Repository
public class DoctorPositionDaoImpl implements DoctorPositionDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DoctorPositionDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String FIND_ALL = "select * from doctor_position";
    private static final String FIND_BY_ID = "select * from doctor_position where doctor_id=? and position_name=?";
    private static final String CREATE = "insert into doctor_position(doctor_id, position_name)" +
            "values(?, ?, ?)";
    private static final String UPDATE = "update doctor_position set doctor_id=?," +
            "position_name=? where doctor_id=? and position_name=?";
    private static final String DELETE = "delete from doctor_position where doctor_id=? and position_name=?";
    private static final String FIND_DOCTORS_ON_POSITION =
            "select doctor.* from doctor " +
                    "join doctor_position on doctor.id=doctor_position.doctor_id join work_position on work_position.name=doctor_position.position_name " +
                    "where work_position.name=?";

    @Override
    public List<DoctorPosition> findAll() {
        return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(DoctorPosition.class));
    }

    @Override
    public DoctorPosition findById(Integer doctorId, String positionName) {
        DoctorPosition doctorPosition = null;

        try {
            doctorPosition = jdbcTemplate.queryForObject(FIND_BY_ID,
                    DoctorPosition.class, doctorId, positionName);
        } catch (EmptyResultDataAccessException e){
            System.out.println("Doctor-Position link {doctor_id=" + doctorId +
                    ", position_name=" + positionName + "} don't exist!");
        }

        return doctorPosition;
    }

    @Override
    public String create(DoctorPosition patientDiagnosis) {
        int result = jdbcTemplate.update(CREATE, patientDiagnosis.getDoctorId(), patientDiagnosis.getPositionName());
        if(result == 0){
            return "Doctor-Position link wasn't created";
        }
        return "Doctor-Position " + patientDiagnosis + " was successfully created";
    }

    @Override
    public String update(Integer doctorId, String positionName, DoctorPosition patientMedicine) {
        int result = jdbcTemplate.update(UPDATE, patientMedicine.getDoctorId(), patientMedicine.getPositionName(),
                doctorId, positionName);
        if(result == 0){
            return "Doctor-Position link wasn't updated";
        }
        return "Doctor-Position {doctor_id=" + doctorId +
                ", position_name=" + positionName + "} was successfully updated";
    }

    @Override
    public String delete(Integer doctorId, String positionName) {
        int result = jdbcTemplate.update(DELETE, doctorId, positionName);
        if(result == 0){
            return "Doctor-Position link wasn't deleted";
        }
        return "Doctor-Position {doctor_id=" + doctorId +
                ", position_name=" + positionName + "} was successfully updated";
    }

    @Override
    public List<Doctor> doctorsOnPosition(String positionName) {
        return jdbcTemplate.query(FIND_DOCTORS_ON_POSITION,
                new BeanPropertyRowMapper<>(Doctor.class),
                positionName);
    }
}
