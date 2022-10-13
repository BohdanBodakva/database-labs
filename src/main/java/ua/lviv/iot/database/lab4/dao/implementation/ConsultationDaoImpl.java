package ua.lviv.iot.database.lab4.dao.implementation;

import org.springframework.stereotype.Repository;
import ua.lviv.iot.database.lab4.dao.ConsultationDao;
import ua.lviv.iot.database.lab4.models.Consultation;

import java.util.List;
import java.util.Optional;

@Repository
public class ConsultationDaoImpl implements ConsultationDao {
    @Override
    public List<Consultation> findAll() {
        return null;
    }

    @Override
    public Optional<Consultation> findById(Integer integer, Integer integer2) {
        return Optional.empty();
    }

    @Override
    public int create(Consultation entity) {
        return 0;
    }

    @Override
    public int update(Integer integer, Integer integer2, Consultation entity) {
        return 0;
    }

    @Override
    public int delete(Integer integer, Integer integer2) {
        return 0;
    }
}
