package ua.lviv.iot.databases.lab5.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databases.lab5.entities.DiagnosisEntity;
import ua.lviv.iot.databases.lab5.exceptions.ResourceNotFoundException;
import ua.lviv.iot.databases.lab5.repositories.DiagnosisRepository;
import ua.lviv.iot.databases.lab5.services.DiagnosisService;

import java.util.List;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {
    private final DiagnosisRepository diagnosisRepository;

    @Autowired
    public DiagnosisServiceImpl(DiagnosisRepository diagnosisRepository) {
        this.diagnosisRepository = diagnosisRepository;
    }

    @Override
    public List<DiagnosisEntity> getDiagnosisEntitiesByPatientsId(int patientId) {
       return diagnosisRepository.findDiagnosisEntitiesByPatientsId(patientId);
    }

    @Override
    public List<DiagnosisEntity> getAll() {
        return diagnosisRepository.findAll();
    }

    @Override
    public DiagnosisEntity getById(String s) {
        return diagnosisRepository.findById(s)
                .orElseThrow(() -> new ResourceNotFoundException("Diagnosis doesn't exist!"));
    }

    @Override
    public DiagnosisEntity create(DiagnosisEntity item) {
        return diagnosisRepository.save(item);
    }

    @Override
    public DiagnosisEntity updateById(String s, DiagnosisEntity item) {
        DiagnosisEntity diagnosis = diagnosisRepository.findById(s)
                .orElseThrow(() -> new ResourceNotFoundException("Diagnosis doesn't exist!"));

        diagnosis.setName(item.getName());

        return diagnosisRepository.save(diagnosis);
    }

    @Override
    public void deleteById(String s) {
        diagnosisRepository.findById(s)
                .orElseThrow(() -> new ResourceNotFoundException("Diagnosis doesn't exist!"));

        diagnosisRepository.deleteById(s);
    }

    @Override
    public void deleteAll() {
        diagnosisRepository.deleteAll();
    }
}
