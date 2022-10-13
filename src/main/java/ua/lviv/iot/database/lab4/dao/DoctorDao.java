package ua.lviv.iot.database.lab4.dao;

import ua.lviv.iot.database.lab4.models.Doctor;

import javax.print.Doc;
import java.util.List;

public interface DoctorDao extends GeneralDao<Doctor, Integer> {
    List<Doctor> getAllDoctorsBySurname(String doctorSurname);
    List<Doctor> getAllDoctorsWithExperienceMoreThan(Integer experience);
}
