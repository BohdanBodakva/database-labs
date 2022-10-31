package ua.lviv.iot.databases.lab5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.databases.lab5.entities.WorkPositionEntity;
import ua.lviv.iot.databases.lab5.services.WorkPositionService;

import java.util.List;

@RestController
@RequestMapping("/api/databases/lab5/position")
public class WorkPositionController {
    private final WorkPositionService workPositionService;

    @Autowired
    public WorkPositionController(WorkPositionService workPositionService) {
        this.workPositionService = workPositionService;
    }

    @GetMapping("/")
    public List<WorkPositionEntity> getAllWorkPositions(){
        return workPositionService.getAll();
    }

    @GetMapping("/{id}")
    public WorkPositionEntity getWorkPositionById(@PathVariable String id){
        return workPositionService.getById(id);
    }

    @PostMapping("/")
    public WorkPositionEntity createWorkPosition(@RequestBody WorkPositionEntity workPosition){
        return workPositionService.create(workPosition);
    }

    @PutMapping("/{id}")
    public WorkPositionEntity updateWorkPosition(@PathVariable String id, @RequestBody WorkPositionEntity workPosition){
        return workPositionService.updateById(id, workPosition);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkPosition(@PathVariable String id){
        workPositionService.deleteById(id);
    }

    @DeleteMapping("/")
    public void deleteAllPositions(){
        workPositionService.deleteAll();
    }

    @GetMapping("/doctors/{id}/positions")
    public List<WorkPositionEntity> getAllPositionsByDoctorId(@PathVariable int id){
        return workPositionService.getWorkPositionEntitiesByDoctorsId(id);
    }
}
