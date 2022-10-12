package ua.lviv.iot.database.lab4.dao;

import ua.lviv.iot.database.lab4.models.Hospital;

import java.util.List;

public interface HospitalDao extends GeneralDao<Hospital, String> {
    List<Hospital> getAllHospitalsFromCityByCityId(Integer cityId);
    List<Hospital> getAllHospitalsByName(String hospitalName);
}
