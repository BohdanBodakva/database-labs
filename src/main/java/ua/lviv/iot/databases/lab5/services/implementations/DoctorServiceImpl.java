package ua.lviv.iot.databases.lab5.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databases.lab5.entities.DiagnosisEntity;
import ua.lviv.iot.databases.lab5.entities.DoctorEntity;
import ua.lviv.iot.databases.lab5.exceptions.ResourceNotFoundException;
import ua.lviv.iot.databases.lab5.repositories.DoctorRepository;
import ua.lviv.iot.databases.lab5.services.DoctorService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<DoctorEntity> getDoctorEntitiesByPositionsName(String positionId) {
        return doctorRepository.findDoctorEntitiesByPositionsName(positionId);
    }

    @Override
    public List<DoctorEntity> getDoctorEntitiesByHospitalId(int hospitalId) {
        return doctorRepository.findDoctorEntitiesByHospitalId(hospitalId);
    }

    @Override
    public List<DoctorEntity> getAll() {
        return doctorRepository.findAll();
    }

    @Override
    public DoctorEntity getById(Integer id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor doesn't exist!"));
    }

    @Override
    @Transactional
    public DoctorEntity create(DoctorEntity item) {
        return doctorRepository.save(item);
    }

    @Override
    @Transactional
    public DoctorEntity updateById(Integer id, DoctorEntity item) {
        DoctorEntity doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor doesn't exist!"));

        doctor.setSurname(item.getSurname());
        doctor.setName(item.getName());
        doctor.setExperience(item.getExperience());
        doctor.setHireDate(item.getHireDate());
        doctor.setHospital(item.getHospital());
        doctor.setSalary(item.getSalary());

        return doctorRepository.save(doctor);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor doesn't exist!"));

        doctorRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        doctorRepository.deleteAll();
    }
}
