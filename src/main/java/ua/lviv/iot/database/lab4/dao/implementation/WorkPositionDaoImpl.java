package ua.lviv.iot.database.lab4.dao.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.database.lab4.dao.WorkPositionDao;
import ua.lviv.iot.database.lab4.models.WorkPosition;

import java.util.List;

@Repository
public class WorkPositionDaoImpl implements WorkPositionDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WorkPositionDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String FIND_ALL = "select * from work_position";
    private static final String FIND_BY_ID = "select * from work_position where name=?";
    private static final String CREATE = "insert into work_position(name) values(?)";
    private static final String UPDATE = "update work_position set name=? where name=?";
    private static final String DELETE = "delete from work_position where name=?";

    private static final String FIND_ALL_WORK_POSITIONS_BY_NAME = "select * from work_position where name like ?";

    @Override
    public List<WorkPosition> findAll() {
        return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(WorkPosition.class));
    }

    @Override
    public WorkPosition findById(String s) {
        WorkPosition workPosition = null;

        try {
            workPosition = jdbcTemplate.queryForObject(FIND_BY_ID,
                    WorkPosition.class, s);
        } catch (EmptyResultDataAccessException e){
            System.out.println("Work position with name=" + s + " don't exist!");
        }

        return workPosition;
    }

    @Override
    public String create(WorkPosition workPosition) {
        int result = jdbcTemplate.update(CREATE, workPosition.getName());
        if(result == 0){
            return "Work position wasn't created";
        }
        return "Work position " + workPosition + " was successfully created";
    }

    @Override
    public String update(String s, WorkPosition workPosition) {
        int result = jdbcTemplate.update(UPDATE, workPosition.getName(), s);
        if(result == 0){
            return "Work position wasn't updated";
        }
        return "Work position with name=" + s + " was successfully updated";
    }

    @Override
    public String delete(String s) {
        int result = jdbcTemplate.update(DELETE, s);
        if(result == 0){
            return "Work position wasn't deleted";
        }
        return "Work position with name=" + s + " was successfully deleted";
    }

    @Override
    public List<WorkPosition> getAllWorkPositionsByName(String workPositionName) {
        return jdbcTemplate.queryForList(FIND_ALL_WORK_POSITIONS_BY_NAME,
                WorkPosition.class,
                "%" + workPositionName + "%");
    }
}
