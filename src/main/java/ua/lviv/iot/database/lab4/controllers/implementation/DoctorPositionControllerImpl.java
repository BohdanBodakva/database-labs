package ua.lviv.iot.database.lab4.controllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.lviv.iot.database.lab4.controllers.DoctorPositionController;
import ua.lviv.iot.database.lab4.models.Doctor;
import ua.lviv.iot.database.lab4.models.DoctorPosition;
import ua.lviv.iot.database.lab4.services.DoctorPositionService;

import java.util.List;

@Controller
public class DoctorPositionControllerImpl implements DoctorPositionController {
    private final DoctorPositionService doctorPositionService;

    @Autowired
    public DoctorPositionControllerImpl(DoctorPositionService doctorPositionService) {
        this.doctorPositionService = doctorPositionService;
    }

    @Override
    public List<DoctorPosition> findAll() {
        return doctorPositionService.findAll();
    }

    @Override
    public DoctorPosition findById(Integer doctorId, String positionName) {
        return doctorPositionService.findById(doctorId, positionName);
    }

    @Override
    public String create(DoctorPosition doctorPosition) {
        return doctorPositionService.create(doctorPosition);
    }

    @Override
    public String update(Integer doctorId, String positionName, DoctorPosition doctorPosition) {
        return doctorPositionService.update(doctorId, positionName, doctorPosition);
    }

    @Override
    public String delete(Integer doctorId, String positionName) {
        return doctorPositionService.delete(doctorId, positionName);
    }

    @Override
    public List<Doctor> doctorsOnPosition(String positionName) {
        return doctorPositionService.getDoctorsOnPosition(positionName);
    }
}
