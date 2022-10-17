package ua.lviv.iot.database.lab4.controllers;

import ua.lviv.iot.database.lab4.models.Hospital;

import java.util.List;

public interface HospitalController extends GeneralController<Hospital, Integer>  {
    List<Hospital> getAllHospitalsFromCityByCityId(String cityId);
    List<Hospital> getAllHospitalsByName(String hospitalName);
}
