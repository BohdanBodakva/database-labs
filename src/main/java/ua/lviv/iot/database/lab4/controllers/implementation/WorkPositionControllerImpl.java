package ua.lviv.iot.database.lab4.controllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.lviv.iot.database.lab4.controllers.WorkPositionController;
import ua.lviv.iot.database.lab4.models.WorkPosition;
import ua.lviv.iot.database.lab4.services.WorkPositionService;

import java.util.List;

@Controller
public class WorkPositionControllerImpl implements WorkPositionController {

    private final WorkPositionService workPositionService;

    @Autowired
    public WorkPositionControllerImpl(WorkPositionService workPositionService) {
        this.workPositionService = workPositionService;
    }

    @Override
    public List<WorkPosition> findAll() {
        return workPositionService.findAll();
    }

    @Override
    public WorkPosition findById(String s) {
        return workPositionService.findById(s);
    }

    @Override
    public String create(WorkPosition workPosition) {
        return workPositionService.create(workPosition);
    }

    @Override
    public String update(String s, WorkPosition workPosition) {
        return workPositionService.update(s, workPosition);
    }

    @Override
    public String delete(String s) {
        return workPositionService.delete(s);
    }

    @Override
    public List<WorkPosition> getAllWorkPositionsByName(String workPositionName) {
        return workPositionService.getAllWorkPositionsByName(workPositionName);
    }
}
