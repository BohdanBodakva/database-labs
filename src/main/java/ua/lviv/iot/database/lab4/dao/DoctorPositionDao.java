package ua.lviv.iot.database.lab4.dao;

import ua.lviv.iot.database.lab4.dao.GeneralDao;
import ua.lviv.iot.database.lab4.models.Doctor;
import ua.lviv.iot.database.lab4.models.DoctorPosition;

import javax.print.Doc;
import java.util.List;

public interface DoctorPositionDao extends ManyToManyDao<DoctorPosition, Integer, String> {
    List<Doctor> doctorsOnPosition(String positionName);
}
