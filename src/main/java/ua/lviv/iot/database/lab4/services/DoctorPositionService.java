package ua.lviv.iot.database.lab4.services;

import ua.lviv.iot.database.lab4.models.Doctor;
import ua.lviv.iot.database.lab4.models.DoctorPosition;

import java.util.List;

public interface DoctorPositionService extends ManyToManyService<DoctorPosition, Integer, String> {
    List<Doctor> getDoctorsOnPosition(String positionName);
}
