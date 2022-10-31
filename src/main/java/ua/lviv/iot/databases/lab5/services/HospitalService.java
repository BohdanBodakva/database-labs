package ua.lviv.iot.databases.lab5.services;

import ua.lviv.iot.databases.lab5.entities.HospitalEntity;

public interface HospitalService extends GeneralService<HospitalEntity, Integer> {
    HospitalEntity findHospitalEntitiesByCityName(String cityName);
}
