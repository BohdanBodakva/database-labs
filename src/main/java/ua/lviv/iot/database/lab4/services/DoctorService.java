package ua.lviv.iot.database.lab4.services;

import ua.lviv.iot.database.lab4.models.Doctor;

import java.util.List;

public interface DoctorService extends GeneralService<Doctor, Integer> {
    List<Doctor> getAllDoctorsBySurname(String doctorSurname);
    List<Doctor> getAllDoctorsWithExperienceMoreThan(Integer experience);
    List<Doctor> getAllDoctorsFromHospitalByHospitalId(Integer hospitalId);
}
