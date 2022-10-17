package ua.lviv.iot.database.lab4.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.database.lab4.dao.ConsultationDao;
import ua.lviv.iot.database.lab4.dao.DoctorDao;
import ua.lviv.iot.database.lab4.dao.PatientDao;
import ua.lviv.iot.database.lab4.models.Consultation;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class ConsultationDaoImpl implements ConsultationDao {
    private final JdbcTemplate jdbcTemplate;
    private final DoctorDao doctorDao;
    private final PatientDao patientDao;

    @Autowired
    public ConsultationDaoImpl(JdbcTemplate jdbcTemplate, DoctorDao doctorDao, PatientDao patientDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.doctorDao = doctorDao;
        this.patientDao = patientDao;
    }

    private static final String FIND_ALL = "select * from consultation";
    private static final String FIND_BY_ID = "select * from consultation where doctor_id=? and patient_id=? and date=?";
    private static final String CREATE = "insert into consultation(doctor_id, patient_id, date, conclusion)" +
            "values(?, ?, ?, ?)";
    private static final String UPDATE = "update consultation set doctor_id=?," +
            "patient_id=?," +
            "date=?," +
            "conclusion=? where doctor_id=? and patient_id=? and date=?";
    private static final String DELETE = "delete from consultation where doctor_id=? and patient_id=? and date=?";
    private static final String FIND_CONSULTATIONS_ON_DATE =
            "select * from consultation where date=?";
    private static final String FIND_CONSULTATIONS_FOR_PATIENT =
            "select * from consultation where patient_id=?";
    private static final String FIND_CONSULTATIONS_FOR_DOCTOR =
            "select * from consultation where doctor_id=?";

    @Override
    public List<Consultation> findAll() {
        return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(Consultation.class));
    }

    @Override
    public Consultation findById(Integer doctorId, Integer patientId, String date) {
        Consultation consultation = null;

        try {
            consultation = (Consultation) jdbcTemplate.query(FIND_BY_ID,
                    new BeanPropertyRowMapper(Consultation.class), doctorId, patientId, LocalDate.parse(date))
                    .stream().findFirst().get();
        } catch (EmptyResultDataAccessException | NoSuchElementException e){
            System.out.println("Consultation {doctor_id=" + doctorId +
                    ", patient_id=" + patientId + ", date=" + date +  "} don't exist!");
        }

        return consultation;
    }

    @Override
    public String create(Consultation consultation) {

        LocalDate doctorHireDate = doctorDao.findById(consultation.getDoctorId()).getHireDate();
        LocalDate patientRegisterDate = patientDao.findById(consultation.getPatientId()).getRegistrationDate();

        int compare1 = consultation.getDate().compareTo(doctorHireDate);
        int compare2 = consultation.getDate().compareTo(patientRegisterDate);

        if(compare1 < 0 && compare2 < 0){
            return "You have written wrong date!";
        }


        int result = jdbcTemplate.update(CREATE, consultation.getDoctorId(), consultation.getPatientId(),
                                            consultation.getDate(), consultation.getConclusion());
        if(result == 0){
            return "Consultation wasn't created";
        }
        return "Consultation " + consultation + " was successfully created";
    }

    @Override
    public String update(Integer doctorId, Integer patientId, String date, Consultation consultation) {

        LocalDate doctorHireDate = doctorDao.findById(consultation.getDoctorId()).getHireDate();
        LocalDate patientRegisterDate = patientDao.findById(consultation.getPatientId()).getRegistrationDate();

        int compare1 = consultation.getDate().compareTo(doctorHireDate);
        int compare2 = consultation.getDate().compareTo(patientRegisterDate);

        if(compare1 < 0 && compare2 < 0){
            return "You have written wrong date!";
        }


        int result = jdbcTemplate.update(UPDATE, consultation.getDoctorId(), consultation.getPatientId(),
                consultation.getDate(), consultation.getConclusion(),
                doctorId, patientId, date);
        if(result == 0){
            return "Consultation wasn't updated";
        }
        return "Consultation {doctor_id=" + doctorId +
                ", patient_id=" + patientId + "} was successfully updated";
    }

    @Override
    public String delete(Integer doctorId, Integer patientId, String date) {
        int result = jdbcTemplate.update(DELETE, doctorId, patientId, date);
        if(result == 0){
            return "Consultation wasn't deleted";
        }
        return "Consultation {doctor_id=" + doctorId +
                ", patient_id=" + patientId + ", date=" + date +  "} was successfully deleted";
    }

    @Override
    public List<Consultation> getConsultationsOnDate(String date) {
        return jdbcTemplate.query(FIND_CONSULTATIONS_ON_DATE,
                new BeanPropertyRowMapper<>(Consultation.class),
                LocalDate.parse(date));
    }

    @Override
    public List<Consultation> getAllConsultationsForPatient(Integer patientId) {
        return jdbcTemplate.query(FIND_CONSULTATIONS_FOR_PATIENT,
                new BeanPropertyRowMapper<>(Consultation.class),
                patientId);
    }

    @Override
    public List<Consultation> getAllConsultationsForDoctor(Integer doctorId) {
        return jdbcTemplate.query(FIND_CONSULTATIONS_FOR_DOCTOR,
                new BeanPropertyRowMapper<>(Consultation.class),
                doctorId);
    }
}
