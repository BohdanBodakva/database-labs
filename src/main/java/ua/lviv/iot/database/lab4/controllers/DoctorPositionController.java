package ua.lviv.iot.database.lab4.controllers;

import ua.lviv.iot.database.lab4.models.Doctor;
import ua.lviv.iot.database.lab4.models.DoctorPosition;
import ua.lviv.iot.database.lab4.services.DoctorPositionService;

import java.util.List;

public interface DoctorPositionController extends ManyToManyController<DoctorPosition, Integer, String> {
    List<Doctor> doctorsOnPosition(String positionName);
}
