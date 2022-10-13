package ua.lviv.iot.database.lab4.controllers;

import ua.lviv.iot.database.lab4.models.Region;
import ua.lviv.iot.database.lab4.models.WorkPosition;
import ua.lviv.iot.database.lab4.services.GeneralService;

import java.util.List;

public interface WorkPositionController extends GeneralController<WorkPosition, String>  {
    List<WorkPosition> getAllWorkPositionsByName(String workPositionName);
}
