package ua.lviv.iot.databases.lab5.services.implementations.many_to_many;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databases.lab5.entities.DataEntity;
import ua.lviv.iot.databases.lab5.entities.many_to_many.PatientMedicineEntity;
import ua.lviv.iot.databases.lab5.exceptions.ResourceNotFoundException;
import ua.lviv.iot.databases.lab5.repositories.many_to_many.PatientMedicineRepository;
import ua.lviv.iot.databases.lab5.services.many_to_many.PatientMedicineService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PatientMedicineServiceImpl implements PatientMedicineService {
    private final PatientMedicineRepository patientMedicineRepository;

    @Autowired
    public PatientMedicineServiceImpl(PatientMedicineRepository patientMedicineRepository) {
        this.patientMedicineRepository = patientMedicineRepository;
    }

    @Override
    public List<PatientMedicineEntity> getAll() {
        return patientMedicineRepository.findAll();
    }

    @Override
    public PatientMedicineEntity getById(Integer id) {
        return patientMedicineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Treatment doesn't exist!"));
    }

    @Override
    @Transactional
    public PatientMedicineEntity create(PatientMedicineEntity item) {
        return patientMedicineRepository.save(item);
    }

    @Override
    @Transactional
    public PatientMedicineEntity updateById(Integer id, PatientMedicineEntity item) {
        PatientMedicineEntity patientMedicine = patientMedicineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Treatment doesn't exist!"));

        patientMedicine.setPatient(item.getPatient());
        patientMedicine.setMedicine(item.getMedicine());
        patientMedicine.setSpecialNotes(item.getSpecialNotes());

        return patientMedicineRepository.save(patientMedicine);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        patientMedicineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Treatment doesn't exist!"));

        patientMedicineRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        patientMedicineRepository.deleteAll();
    }

    @Override
    public List<PatientMedicineEntity> getPatientMedicineEntitiesByPatientId(int patientId) {
        return patientMedicineRepository.findPatientMedicineEntitiesByPatientId(patientId);
    }

    @Override
    public List<PatientMedicineEntity> getPatientMedicineEntitiesByMedicineName(String medicineName) {
        return patientMedicineRepository.findPatientMedicineEntitiesByMedicineName(medicineName);
    }
}
