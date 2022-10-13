package ua.lviv.iot.database.lab4.dao;

import ua.lviv.iot.database.lab4.models.PatientDiagnosis;

public interface PatientDiagnosisDao extends ManyToManyDao<PatientDiagnosis, Integer, String> {
}
