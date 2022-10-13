package ua.lviv.iot.database.lab4.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.database.lab4.dao.PatientDiagnosisDao;
import ua.lviv.iot.database.lab4.models.Diagnosis;
import ua.lviv.iot.database.lab4.models.PatientDiagnosis;
import ua.lviv.iot.database.lab4.models.PatientMedicine;

import java.util.List;
import java.util.Optional;

@Repository
public class PatientDiagnosisDaoImpl implements PatientDiagnosisDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PatientDiagnosisDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String FIND_ALL = "select * from patient_diagnosis";
    private static final String FIND_BY_ID = "select * from patient_diagnosis where patient_id=? and diagnosis_name=?";
    private static final String CREATE = "insert into patient_diagnosis(patient_id, diagnosis_name)" +
            "values(?, ?, ?)";
    private static final String UPDATE = "update patient_diagnosis set patient_id=?," +
            "diagnosis_name=? where patient_id=? and diagnosis_name=?";
    private static final String DELETE = "delete from patient_diagnosis where patient_id=? and diagnosis_name=?";

    @Override
    public List<PatientDiagnosis> findAll() {
        return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(PatientDiagnosis.class));
    }

    @Override
    public PatientDiagnosis findById(Integer patientId, String diagnosisName) {
        PatientDiagnosis patientDiagnosis = null;

        try {
            patientDiagnosis = jdbcTemplate.queryForObject(FIND_BY_ID,
                    PatientDiagnosis.class, patientId, diagnosisName);
        } catch (EmptyResultDataAccessException e){
            System.out.println("Patient-Diagnosis link {patient_id=" + patientId +
                    ", medicine_name=" + diagnosisName + "} don't exist!");
        }

        return patientDiagnosis;
    }

    @Override
    public String create(PatientDiagnosis patientDiagnosis) {
        int result = jdbcTemplate.update(CREATE, patientDiagnosis.getPatientId(), patientDiagnosis.getDiagnosisId());
        if(result == 0){
            return "Patient-Diagnosis link wasn't created";
        }
        return "Patient-Diagnosis " + patientDiagnosis + " was successfully created";
    }

    @Override
    public String update(Integer patientId, String diagnosisName, PatientDiagnosis patientMedicine) {
        int result = jdbcTemplate.update(UPDATE, patientMedicine.getPatientId(), patientMedicine.getDiagnosisId(),
                patientId, diagnosisName);
        if(result == 0){
            return "Patient-Diagnosis link wasn't updated";
        }
        return "Patient-Diagnosis {patient_id=" + patientId +
                ", medicine_name=" + diagnosisName + "} was successfully updated";
    }

    @Override
    public String delete(Integer patientId, String diagnosisName) {
        int result = jdbcTemplate.update(DELETE, patientId, diagnosisName);
        if(result == 0){
            return "Patient-Diagnosis link wasn't deleted";
        }
        return "Patient-Diagnosis {patient_id=" + patientId +
                ", medicine_name=" + diagnosisName + "} was successfully updated";
    }
}
