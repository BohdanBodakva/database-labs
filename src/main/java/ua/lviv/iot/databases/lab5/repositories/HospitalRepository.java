package ua.lviv.iot.databases.lab5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.databases.lab5.entities.HospitalEntity;

@Repository
public interface HospitalRepository extends JpaRepository<HospitalEntity, Integer> {
    HospitalEntity findHospitalEntitiesByCityName(String cityName);
}
