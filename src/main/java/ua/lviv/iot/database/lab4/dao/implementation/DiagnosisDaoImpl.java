package ua.lviv.iot.database.lab4.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.database.lab4.dao.DiagnosisDao;
import ua.lviv.iot.database.lab4.models.Diagnosis;

import java.util.List;

@Repository
public class DiagnosisDaoImpl implements DiagnosisDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DiagnosisDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String FIND_ALL = "select * from diagnosis";
    private static final String FIND_BY_ID = "select * from diagnosis where name=?";
    private static final String CREATE = "insert into diagnosis(name) values(?)";
    private static final String UPDATE = "update diagnosis set name=? where name=?";
    private static final String DELETE = "delete from diagnosis where name=?";

    private static final String FIND_ALL_DIAGNOSIS_BY_NAME = "select * from diagnosis where name like ?";

    @Override
    public List<Diagnosis> findAll() {
        return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(Diagnosis.class));
    }

    @Override
    public Diagnosis findById(String s) {
        Diagnosis diagnosis = null;

        try {
            diagnosis = jdbcTemplate.queryForObject(FIND_BY_ID,
                    Diagnosis.class, s);
        } catch (EmptyResultDataAccessException e){
            System.out.println("Diagnosis with name=" + s + " don't exist!");
        }

        return diagnosis;
    }

    @Override
    public String create(Diagnosis diagnosis) {
        int result = jdbcTemplate.update(CREATE, diagnosis.getName());
        if(result == 0){
            return "Diagnosis wasn't created";
        }
        return "Diagnosis " + diagnosis + " was successfully created";
    }

    @Override
    public String update(String s, Diagnosis diagnosis) {
        int result = jdbcTemplate.update(UPDATE, diagnosis.getName(), s);
        if(result == 0){
            return "Diagnosis wasn't updated";
        }
        return "Diagnosis with name=" + s + " was successfully updated";
    }

    @Override
    public String delete(String s) {
        int result = jdbcTemplate.update(DELETE, s);
        if(result == 0){
            return "Diagnosis wasn't deleted";
        }
        return "Diagnosis with name=" + s + " was successfully deleted";
    }

    @Override
    public List<Diagnosis> getAllDiagnosisByName(String diagnosisName) {
        return jdbcTemplate.queryForList(FIND_ALL_DIAGNOSIS_BY_NAME,
                Diagnosis.class,
                "%" + diagnosisName + "%");
    }
}
