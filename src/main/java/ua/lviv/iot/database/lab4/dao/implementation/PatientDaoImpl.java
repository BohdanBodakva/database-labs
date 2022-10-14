package ua.lviv.iot.database.lab4.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.database.lab4.dao.PatientDao;
import ua.lviv.iot.database.lab4.dao.PatientDataDao;
import ua.lviv.iot.database.lab4.models.Patient;
import ua.lviv.iot.database.lab4.models.PatientData;

import java.util.List;

@Repository
public class PatientDaoImpl implements PatientDao {
    private final JdbcTemplate jdbcTemplate;
    private final PatientDataDao patientDataDao;

    @Autowired
    public PatientDaoImpl(JdbcTemplate jdbcTemplate, PatientDataDao patientDataDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.patientDataDao = patientDataDao;
    }

    private static final String FIND_ALL = "select * from patient";
    private static final String FIND_BY_ID = "select * from patient where name=?";
    private static final String CREATE =
            "insert into patient(surname, name, registration_date, data_id, hospital_id) " +
                        "values(?, ?, ?, ?, ?)";
    private static final String UPDATE =
            "update patient set " +
                    "surname=?, name=?, registration_date=?, data_id=?, hospital_id=?" +
                    " where id=?";
    private static final String DELETE = "delete from patient where id=?";

    private static final String FIND_ALL_PATIENTS_BY_SURNAME = "select * from patient where surname like ?";
    private static final String FIND_PATIENT_DATA_BY_PATIENT_ID =
                            "select data.* from data join patient on patient.data_id=data.id where patient.id=?";
    private static final String FIND_ALL_PATIENTS_FROM_HOSPITAL_BY_HOSPITAL_ID =
                                                "select * from patient where hospital_id=?";

    @Override
    public List<Patient> findAll() {
        return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(Patient.class));
    }

    @Override
    public Patient findById(Integer id) {
        Patient patient = null;

        try {
            patient = jdbcTemplate.queryForObject(FIND_BY_ID,
                    Patient.class, id);
        } catch (EmptyResultDataAccessException e){
            System.out.println("Patient with id=" + id + " don't exist!");
        }

        return patient;
    }

    @Override
    public String create(Patient patient) {
        int result = jdbcTemplate.update(CREATE, patient.getName());
        if(result == 0){
            return "Patient wasn't created";
        }
        return "Patient " + patient + " was successfully created";
    }

    @Override
    public String update(Integer id, Patient patient) {
        int result = jdbcTemplate.update(UPDATE, patient.getName(),id);
        if(result == 0){
            return "Patient wasn't updated";
        }
        return "Patient with name=" + id + " was successfully updated";
    }

    @Override
    public String delete(Integer id) {
        int result = jdbcTemplate.update(DELETE, id);
        if(result == 0){
            return "Patient wasn't deleted";
        }
        return "Patient with name=" + id + " was successfully deleted";
    }

    @Override
    public PatientData getPatientDataByPatientId(Integer patientId) {
        return jdbcTemplate.query(FIND_PATIENT_DATA_BY_PATIENT_ID,
                new BeanPropertyRowMapper<>(PatientData.class),
                patientId).get(0);
    }

    @Override
    public List<Patient> getAllPatientsFromHospitalByHospitalId(Integer hospitalId) {
        return jdbcTemplate.query(FIND_ALL_PATIENTS_FROM_HOSPITAL_BY_HOSPITAL_ID,
                new BeanPropertyRowMapper<>(Patient.class),
                hospitalId);
    }

    @Override
    public List<Patient> getAllPatientsBySurname(String patientSurname) {
        return jdbcTemplate.query(FIND_ALL_PATIENTS_BY_SURNAME,
                new BeanPropertyRowMapper<>(Patient.class),
                "%" + patientSurname + "%");
    }
}
