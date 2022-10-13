package ua.lviv.iot.database.lab4.controllers;

import org.springframework.data.relational.core.sql.In;
import ua.lviv.iot.database.lab4.models.Doctor;

import java.util.List;

public interface DoctorController extends GeneralController<Doctor, Integer> {
    List<Doctor> getAllDoctorsBySurname(String doctorSurname);
    List<Doctor> getAllDoctorsWithExperienceMoreThan(Integer experience);
}
