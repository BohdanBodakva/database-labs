package ua.lviv.iot.database.lab4.dao;

import ua.lviv.iot.database.lab4.models.Doctor;

import java.util.List;

public interface DoctorDao extends GeneralDao<Doctor, String> {
    List<Doctor> getAllDoctorsBySurname(String doctorSurname);
}
