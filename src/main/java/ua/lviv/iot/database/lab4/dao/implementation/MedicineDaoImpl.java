package ua.lviv.iot.database.lab4.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.database.lab4.dao.MedicineDao;
import ua.lviv.iot.database.lab4.models.Medicine;

import java.util.List;

@Repository
public class MedicineDaoImpl implements MedicineDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MedicineDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String FIND_ALL = "select * from medicine";
    private static final String FIND_BY_ID = "select * from medicine where name=?";
    private static final String CREATE = "insert into medicine(name) values(?)";
    private static final String UPDATE = "update medicine set name=? where name=?";
    private static final String DELETE = "delete from medicine where name=?";

    private static final String FIND_ALL_MEDICINE_BY_NAME = "select * from medicine where name like ?";

    @Override
    public List<Medicine> findAll() {
        return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(Medicine.class));
    }

    @Override
    public Medicine findById(String s) {
        Medicine medicine = null;

        try {
            medicine = jdbcTemplate.queryForObject(FIND_BY_ID,
                    Medicine.class, s);
        } catch (EmptyResultDataAccessException e){
            System.out.println("Medicine with name=" + s + " don't exist!");
        }

        return medicine;
    }

    @Override
    public String create(Medicine medicine) {
        int result = jdbcTemplate.update(CREATE, medicine.getName());
        if(result == 0){
            return "Medicine wasn't created";
        }
        return "Medicine " + medicine + " was successfully created";
    }

    @Override
    public String update(String s, Medicine medicine) {
        int result = jdbcTemplate.update(UPDATE, medicine.getName(), s);
        if(result == 0){
            return "Medicine wasn't updated";
        }
        return "Medicine with name=" + s + " was successfully updated";
    }

    @Override
    public String delete(String s) {
        int result = jdbcTemplate.update(DELETE, s);
        if(result == 0){
            return "Medicine wasn't deleted";
        }
        return "Medicine with name=" + s + " was successfully deleted";
    }

    @Override
    public List<Medicine> getAllMedicineByName(String medicineName) {
        return jdbcTemplate.queryForList(FIND_ALL_MEDICINE_BY_NAME,
                Medicine.class,
                "%" + medicineName + "%");
    }
}
