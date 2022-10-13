package ua.lviv.iot.database.lab4.dao;

import ua.lviv.iot.database.lab4.dao.GeneralDao;
import ua.lviv.iot.database.lab4.models.DoctorPosition;

public interface DoctorPositionDao extends ManyToManyDao<DoctorPosition, Integer, String> {
}
