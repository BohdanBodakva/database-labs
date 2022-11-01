package ua.lviv.iot.databases.lab5.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.databases.lab5.entities.WorkPositionEntity;
import ua.lviv.iot.databases.lab5.exceptions.ResourceNotFoundException;
import ua.lviv.iot.databases.lab5.repositories.WorkPositionRepository;
import ua.lviv.iot.databases.lab5.services.GeneralService;
import ua.lviv.iot.databases.lab5.services.WorkPositionService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class WorkPositionServiceImpl implements WorkPositionService {
    private final WorkPositionRepository workPositionRepository;

    @Autowired
    public WorkPositionServiceImpl(WorkPositionRepository workPositionRepository) {
        this.workPositionRepository = workPositionRepository;
    }

    @Override
    public List<WorkPositionEntity> getAll() {
        return workPositionRepository.findAll();
    }

    @Override
    public WorkPositionEntity getById(String s) {
        return workPositionRepository.findById(s)
                .orElseThrow(() -> new ResourceNotFoundException("Position doesn't exist!"));
    }

    @Override
    @Transactional
    public WorkPositionEntity create(WorkPositionEntity item) {
        return workPositionRepository.save(item);
    }

    @Override
    @Transactional
    public WorkPositionEntity updateById(String s, WorkPositionEntity item) {
        WorkPositionEntity position = workPositionRepository.findById(s)
                .orElseThrow(() -> new ResourceNotFoundException("Position doesn't exist!"));

        position.setName(item.getName());

        return workPositionRepository.save(position);
    }

    @Override
    @Transactional
    public void deleteById(String s) {
        workPositionRepository.findById(s)
                .orElseThrow(() -> new ResourceNotFoundException("Position doesn't exist!"));

        workPositionRepository.deleteById(s);
    }

    @Override
    @Transactional
    public void deleteAll() {
        workPositionRepository.deleteAll();
    }

    @Override
    public List<WorkPositionEntity> getWorkPositionEntitiesByDoctorsId(int doctorId) {
        return workPositionRepository.findWorkPositionEntitiesByDoctorsId((doctorId));
    }
}
