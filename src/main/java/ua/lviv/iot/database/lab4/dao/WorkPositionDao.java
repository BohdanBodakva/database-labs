package ua.lviv.iot.database.lab4.dao;


import ua.lviv.iot.database.lab4.models.WorkPosition;

import java.util.List;

public interface WorkPositionDao extends GeneralDao<WorkPosition, String> {
    List<WorkPosition> getAllWorkPositionsByName(String workPositionName);
}
