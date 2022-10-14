package ua.lviv.iot.database.lab4.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.database.lab4.dao.DoctorDao;
import ua.lviv.iot.database.lab4.models.Doctor;
import ua.lviv.iot.database.lab4.models.Medicine;
import ua.lviv.iot.database.lab4.models.Patient;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Repository
public class DoctorDaoImpl implements DoctorDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DoctorDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String FIND_ALL = "select * from doctor";
    private static final String FIND_BY_ID = "select * from doctor where name=?";
    private static final String CREATE = "insert into doctor" +
                                                "(surname, " +
                                                "name, " +
                                                "previous_experience_in_years, " +
                                                "hire_date, hospital_id, " +
                                                "salary_in_hrn) values(?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "update doctor set surname=?," +
                                                "name=?," +
                                                "previous_experience_in_years=?," +
                                                "hire_date=?," +
                                                "hospital_id=?," +
                                                "salary_in_hrn=? where name=?";
    private static final String DELETE = "delete from doctor where id=?";

    private static final String FIND_ALL_DOCTORS_BY_SURNAME = "select * from doctor where surname like ?";
    private static final String FIND_ALL_DOCTORS_WITH_EXPERIENCE_MORE_THAN =
                        "select * from doctor where previous_experience_in_years>=?";
    private static final String FIND_ALL_DOCTORS_FROM_HOSPITAL_BY_HOSPITAL_ID = "select * from doctor where hospital_id=?";


    @Override
    public List<Doctor> getAllDoctorsBySurname(String doctorSurname) {
        return jdbcTemplate.queryForList(FIND_ALL_DOCTORS_BY_SURNAME,
                Doctor.class,
                "%" + doctorSurname + "%");
    }

    @Override
    public List<Doctor> getAllDoctorsWithExperienceMoreThan(Integer experience) {
        return jdbcTemplate.queryForList(FIND_ALL_DOCTORS_WITH_EXPERIENCE_MORE_THAN,
                Doctor.class,
                experience);
    }

    @Override
    public List<Doctor> getAllDoctorsFromHospitalByHospitalId(Integer hospitalId) {
        return jdbcTemplate.query(FIND_ALL_DOCTORS_FROM_HOSPITAL_BY_HOSPITAL_ID,
                new BeanPropertyRowMapper<>(Doctor.class),
                hospitalId);
    }

    @Override
    public List<Doctor> findAll() {
        return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(Doctor.class));
    }

    @Override
    public Doctor findById(Integer id) {
        Doctor doctor = null;

        try {
            doctor = jdbcTemplate.queryForObject(FIND_BY_ID,
                    Doctor.class, id);
        } catch (EmptyResultDataAccessException e){
            System.out.println("Doctor with name=" + id + " don't exist!");
        }

        return doctor;
    }

    @Override
    public String create(Doctor doctor) {
        int result = jdbcTemplate.update(CREATE, doctor.getSurname(),
                                                    doctor.getName(),
                                                    doctor.getPreviousExperienceInYears(),
                                                    doctor.getHireDate(),
                                                    doctor.getHospitalId(),
                                                    doctor.getSalaryInHrn());
        if(result == 0){
            return "Doctor wasn't created";
        }
        return "Doctor " + doctor + " was successfully created";
    }

    @Override
    public String update(Integer id, Doctor doctor) {
        int result = jdbcTemplate.update(UPDATE, doctor.getSurname(),
                                                    doctor.getName(),
                                                    doctor.getPreviousExperienceInYears(),
                                                    doctor.getHireDate(),
                                                    doctor.getHospitalId(),
                                                    doctor.getSalaryInHrn(), id);
        if(result == 0){
            return "Doctor wasn't updated";
        }
        return "Doctor with name=" + id + " was successfully updated";
    }

    @Override
    public String delete(Integer id) {
        int result = jdbcTemplate.update(DELETE, id);
        if(result == 0){
            return "Doctor wasn't deleted";
        }
        return "Doctor with name=" + id + " was successfully deleted";
    }
}
