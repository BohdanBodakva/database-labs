package ua.lviv.iot.databases.lab5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.databases.lab5.entities.DiagnosisEntity;
import ua.lviv.iot.databases.lab5.entities.WorkPositionEntity;
import ua.lviv.iot.databases.lab5.services.DiagnosisService;

import java.util.List;

@RestController
@RequestMapping("api/databases/lab5/diagnoses")
public class DiagnosisController {
    private final DiagnosisService diagnosisService;

    @Autowired
    public DiagnosisController(DiagnosisService diagnosisService) {
        this.diagnosisService = diagnosisService;
    }

    @GetMapping("/")
    public List<DiagnosisEntity> getAllDiagnoses(){
        return diagnosisService.getAll();
    }

    @GetMapping("/{id}")
    public DiagnosisEntity getDiagnosisById(@PathVariable String id){
        return diagnosisService.getById(id);
    }

    @PostMapping("/")
    public DiagnosisEntity createDiagnosis(@RequestBody DiagnosisEntity diagnosis){
        return diagnosisService.create(diagnosis);
    }

    @PutMapping("/{id}")
    public DiagnosisEntity updateDiagnosis(@PathVariable String id, @RequestBody DiagnosisEntity diagnosis){
        return diagnosisService.updateById(id, diagnosis);
    }

    @DeleteMapping("/{id}")
    public void deleteDiagnosis(@PathVariable String id){
        diagnosisService.deleteById(id);
    }

    @DeleteMapping("/")
    public void deleteAllDiagnoses(){
        diagnosisService.deleteAll();
    }

    @GetMapping("/doctors/{id}/positions")
    public List<DiagnosisEntity> getAllDiagnosesByPatientId(@PathVariable int id){
        return diagnosisService.getDiagnosisEntitiesByPatientsId(id);
    }
}
