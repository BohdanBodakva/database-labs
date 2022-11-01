package ua.lviv.iot.databases.lab5.services;

import ua.lviv.iot.databases.lab5.entities.DoctorEntity;

import java.util.List;

public interface DoctorService extends GeneralService<DoctorEntity, Integer> {
    List<DoctorEntity> getDoctorEntitiesByPositionsName(String positionId);
    List<DoctorEntity> getDoctorEntitiesByHospitalId(int hospitalId);
}
