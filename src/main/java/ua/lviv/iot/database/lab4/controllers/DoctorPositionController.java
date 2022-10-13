package ua.lviv.iot.database.lab4.controllers;

import ua.lviv.iot.database.lab4.models.DoctorPosition;
import ua.lviv.iot.database.lab4.services.DoctorPositionService;

public interface DoctorPositionController extends ManyToManyController<DoctorPosition, Integer, String> {
}
