package ua.lviv.iot.database.lab4.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.database.lab4.dao.PatientMedicineDao;
import ua.lviv.iot.database.lab4.models.Medicine;
import ua.lviv.iot.database.lab4.models.PatientMedicine;

import java.util.List;
import java.util.Optional;

@Repository
public class PatientMedicineDaoImpl implements PatientMedicineDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PatientMedicineDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String FIND_ALL = "select * from patient_medicine";
    private static final String FIND_BY_ID = "select * from patient_medicine where patient_id=? and medicine_name=?";
    private static final String CREATE = "insert into patient_medicine(patient_id, medicine_name, special_notes)" +
                                           "values(?, ?, ?)";
    private static final String UPDATE = "update patient_medicine set patient_id=?," +
                                            "medicine_name=?," +
                                            "special_notes=? where patient_id=? and medicine_name=?";
    private static final String DELETE = "delete from patient_medicine where patient_id=? and medicine_name=?";

    @Override
    public List<PatientMedicine> findAll() {
        return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(PatientMedicine.class));
    }

    @Override
    public PatientMedicine findById(Integer patientId, String medicine_name) {
        PatientMedicine patientMedicine = null;

        try {
            patientMedicine = jdbcTemplate.queryForObject(FIND_BY_ID,
                    PatientMedicine.class, patientId, medicine_name);
        } catch (EmptyResultDataAccessException e){
            System.out.println("Patient-Medicine link {patient_id=" + patientId +
                                ", medicine_name=" + medicine_name + "} don't exist!");
        }

        return patientMedicine;
    }

    @Override
    public String create(PatientMedicine patientMedicine) {
        int result = jdbcTemplate.update(CREATE, patientMedicine.getPatientId(), patientMedicine.getMedicineId(),
                                                                            patientMedicine.getSpecialNotes());
        if(result == 0){
            return "Patient-Medicine link wasn't created";
        }
        return "Patient-Medicine " + patientMedicine + " was successfully created";
    }

    @Override
    public String update(Integer patientId, String medicine_name, PatientMedicine patientMedicine) {
        int result = jdbcTemplate.update(UPDATE, patientMedicine.getPatientId(), patientMedicine.getMedicineId(),
                patientMedicine.getSpecialNotes(), patientId, medicine_name);
        if(result == 0){
            return "Patient-Medicine link wasn't updated";
        }
        return "Patient-Medicine {patient_id=" + patientId +
                    ", medicine_name=" + medicine_name + "} was successfully updated";
    }

    @Override
    public String delete(Integer patientId, String medicine_name) {
        int result = jdbcTemplate.update(DELETE, patientId, medicine_name);
        if(result == 0){
            return "Patient-Medicine link wasn't deleted";
        }
        return "Patient-Medicine {patient_id=" + patientId +
                ", medicine_name=" + medicine_name + "} was successfully updated";
    }
}
