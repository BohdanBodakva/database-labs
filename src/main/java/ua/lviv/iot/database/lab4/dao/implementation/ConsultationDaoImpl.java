package ua.lviv.iot.database.lab4.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.database.lab4.dao.ConsultationDao;
import ua.lviv.iot.database.lab4.models.Consultation;
import ua.lviv.iot.database.lab4.models.DoctorPosition;

import java.util.List;
import java.util.Optional;

@Repository
public class ConsultationDaoImpl implements ConsultationDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ConsultationDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String FIND_ALL = "select * from consultation";
    private static final String FIND_BY_ID = "select * from consultation where doctor_id=? and patient_id=?";
    private static final String CREATE = "insert into consultation(doctor_id, patient_id, date, conclusion)" +
            "values(?, ?, ?, ?)";
    private static final String UPDATE = "update consultation set doctor_id=?," +
            "patient_id=?," +
            "date=?," +
            "conclusion=? where doctor_id=? and patient_id=?";
    private static final String DELETE = "delete from consultation where doctor_id=? and patient_id=?";

    @Override
    public List<Consultation> findAll() {
        return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(Consultation.class));
    }

    @Override
    public Consultation findById(Integer doctorId, Integer patientId) {
        Consultation consultation = null;

        try {
            consultation = jdbcTemplate.queryForObject(FIND_BY_ID,
                    Consultation.class, doctorId, patientId);
        } catch (EmptyResultDataAccessException e){
            System.out.println("Consultation {doctor_id=" + doctorId +
                    ", patient_id=" + patientId + "} don't exist!");
        }

        return consultation;
    }

    @Override
    public String create(Consultation consultation) {
        int result = jdbcTemplate.update(CREATE, consultation.getDoctorId(), consultation.getPatientId(),
                                            consultation.getDate(), consultation.getConclusion());
        if(result == 0){
            return "Consultation wasn't created";
        }
        return "Consultation " + consultation + " was successfully created";
    }

    @Override
    public String update(Integer doctorId, Integer patientId, Consultation consultation) {
        int result = jdbcTemplate.update(UPDATE, consultation.getDoctorId(), consultation.getPatientId(),
                doctorId, patientId);
        if(result == 0){
            return "Consultation wasn't updated";
        }
        return "Consultation {doctor_id=" + doctorId +
                ", patient_id=" + patientId + "} was successfully updated";
    }

    @Override
    public String delete(Integer doctorId, Integer patientId) {
        int result = jdbcTemplate.update(DELETE, doctorId, patientId);
        if(result == 0){
            return "Consultation wasn't deleted";
        }
        return "Consultation {doctor_id=" + doctorId +
                ", patient_id=" + patientId + "} was successfully updated";
    }
}
