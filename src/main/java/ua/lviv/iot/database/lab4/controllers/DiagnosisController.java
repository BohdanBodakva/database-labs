package ua.lviv.iot.database.lab4.controllers;

import ua.lviv.iot.database.lab4.models.Diagnosis;
import ua.lviv.iot.database.lab4.models.Medicine;

import java.util.List;

public interface DiagnosisController extends GeneralController<Diagnosis, String> {
    List<Diagnosis> getAllDiagnosisByName(String diagnosisName);
}
