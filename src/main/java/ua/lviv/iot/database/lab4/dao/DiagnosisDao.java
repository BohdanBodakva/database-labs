package ua.lviv.iot.database.lab4.dao;

import ua.lviv.iot.database.lab4.models.Diagnosis;

import java.util.List;

public interface DiagnosisDao extends GeneralDao<Diagnosis, String> {
    List<Diagnosis> getAllDiagnosisByName(String diagnosisName);
}
