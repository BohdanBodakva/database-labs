package ua.lviv.iot.database.lab4.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.database.lab4.dao.WorkPositionDao;
import ua.lviv.iot.database.lab4.models.WorkPosition;
import ua.lviv.iot.database.lab4.services.WorkPositionService;

import java.util.List;

@Service
public class WorkPositionServiceImpl implements WorkPositionService {
    private final WorkPositionDao workPositionDao;

    @Autowired
    public WorkPositionServiceImpl(WorkPositionDao workPositionDao) {
        this.workPositionDao = workPositionDao;
    }

    @Override
    public List<WorkPosition> findAll() {
        return workPositionDao.findAll();
    }

    @Override
    public WorkPosition findById(String s) {
        return workPositionDao.findById(s);
    }

    @Override
    public String create(WorkPosition workPosition) {
        return workPositionDao.create(workPosition);
    }

    @Override
    public String update(String s, WorkPosition workPosition) {
        return workPositionDao.update(s, workPosition);
    }

    @Override
    public String delete(String s) {
        return workPositionDao.delete(s);
    }

    @Override
    public List<WorkPosition> getAllWorkPositionsByName(String workPositionName) {
        return workPositionDao.getAllWorkPositionsByName(workPositionName);
    }
}
