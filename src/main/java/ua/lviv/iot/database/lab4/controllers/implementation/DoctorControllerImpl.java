package ua.lviv.iot.database.lab4.controllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.lviv.iot.database.lab4.controllers.DoctorController;
import ua.lviv.iot.database.lab4.models.Doctor;
import ua.lviv.iot.database.lab4.services.DoctorService;

import java.util.List;

@Controller
public class DoctorControllerImpl implements DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorControllerImpl(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Override
    public List<Doctor> getAllDoctorsBySurname(String doctorSurname) {
        return doctorService.getAllDoctorsBySurname(doctorSurname);
    }

    @Override
    public List<Doctor> getAllDoctorsWithExperienceMoreThan(Integer experience) {
        return doctorService.getAllDoctorsWithExperienceMoreThan(experience);
    }

    @Override
    public List<Doctor> findAll() {
        return doctorService.findAll();
    }

    @Override
    public Doctor findById(Integer id) {
        return doctorService.findById(id);
    }

    @Override
    public String create(Doctor doctor) {
        return doctorService.create(doctor);
    }

    @Override
    public String update(Integer id, Doctor doctor) {
        return doctorService.update(id, doctor);
    }

    @Override
    public String delete(Integer id) {
        return doctorService.delete(id);
    }
}
