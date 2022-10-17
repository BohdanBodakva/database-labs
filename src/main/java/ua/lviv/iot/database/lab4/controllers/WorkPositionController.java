package ua.lviv.iot.database.lab4.controllers;

import ua.lviv.iot.database.lab4.models.WorkPosition;

import java.util.List;

public interface WorkPositionController extends GeneralController<WorkPosition, String>  {
    List<WorkPosition> getAllWorkPositionsByName(String workPositionName);
}
