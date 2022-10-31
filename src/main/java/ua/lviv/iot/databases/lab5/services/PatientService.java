package ua.lviv.iot.databases.lab5.services;

import ua.lviv.iot.databases.lab5.entities.PatientEntity;

import java.util.List;

public interface PatientService extends GeneralService<PatientEntity, Integer> {
    PatientEntity findPatientEntityByDataId(int dataId);
    List<PatientEntity> findPatientEntitiesByDiagnosesName(String diagnosisName);
    List<PatientEntity> findPatientEntitiesByHospitalId(int hospitalId);
}
