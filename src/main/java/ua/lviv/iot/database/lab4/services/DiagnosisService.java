package ua.lviv.iot.database.lab4.services;

import ua.lviv.iot.database.lab4.models.Diagnosis;

import java.util.List;

public interface DiagnosisService extends GeneralService<Diagnosis, String> {
    List<Diagnosis> getAllDiagnosisByName(String diagnosisName);
}
