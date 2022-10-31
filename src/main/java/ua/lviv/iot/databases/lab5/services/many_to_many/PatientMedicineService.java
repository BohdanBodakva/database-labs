package ua.lviv.iot.databases.lab5.services.many_to_many;

import ua.lviv.iot.databases.lab5.entities.many_to_many.PatientMedicineEntity;
import ua.lviv.iot.databases.lab5.services.GeneralService;

import java.util.List;

public interface PatientMedicineService extends GeneralService<PatientMedicineEntity, Integer> {
    List<PatientMedicineEntity> findPatientMedicineEntitiesByPatientId(int patientId);
    List<PatientMedicineEntity> findPatientMedicineEntitiesByMedicineName(String medicineName);
}
