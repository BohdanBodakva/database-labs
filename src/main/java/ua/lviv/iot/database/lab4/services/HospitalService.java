package ua.lviv.iot.database.lab4.services;

import ua.lviv.iot.database.lab4.models.Hospital;

import java.util.List;

public interface HospitalService extends GeneralService<Hospital, Integer> {
    List<Hospital> getAllHospitalsFromCityByCityId(String cityId);
    List<Hospital> getAllHospitalsByName(String hospitalName);
}
