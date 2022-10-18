package ua.lviv.iot.database.lab4.controllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.lviv.iot.database.lab4.controllers.HospitalController;
import ua.lviv.iot.database.lab4.models.Hospital;
import ua.lviv.iot.database.lab4.services.HospitalService;

import java.util.List;

@Controller
public class HospitalControllerImpl implements HospitalController {
    private final HospitalService hospitalService;

    @Autowired
    public HospitalControllerImpl(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @Override
    public List<Hospital> findAll() {
        return hospitalService.findAll();
    }

    @Override
    public Hospital findById(Integer id) {
        return hospitalService.findById(id);
    }

    @Override
    public String create(Hospital hospital) {
        return hospitalService.create(hospital);
    }

    @Override
    public String update(Integer id, Hospital hospital) {
        return hospitalService.update(id, hospital);
    }

    @Override
    public String delete(Integer id) {
        return hospitalService.delete(id);
    }

    @Override
    public List<Hospital> getAllHospitalsFromCityByCityId(String cityId) {
        return hospitalService.getAllHospitalsFromCityByCityId(cityId);
    }

    @Override
    public List<Hospital> getAllHospitalsByName(String hospitalName) {
        return hospitalService.getAllHospitalsByName(hospitalName);
    }
}
