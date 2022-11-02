package ua.lviv.iot.databases.lab5.repositories.many_to_many;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.databases.lab5.entities.many_to_many.PatientMedicineEntity;

import java.util.List;

@Repository
public interface PatientMedicineRepository extends JpaRepository<PatientMedicineEntity, Integer> {
    List<PatientMedicineEntity> findPatientMedicineEntitiesByPatientId(int patientId);
    List<PatientMedicineEntity> findPatientMedicineEntitiesByMedicineName(String medicineName);
}
