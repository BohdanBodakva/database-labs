package ua.lviv.iot.database.lab4.services;

import ua.lviv.iot.database.lab4.models.Region;
import ua.lviv.iot.database.lab4.models.WorkPosition;

import java.util.List;

public interface WorkPositionService extends GeneralService<WorkPosition, String> {
    List<WorkPosition> getAllWorkPositionsByName(String workPositionName);
}
