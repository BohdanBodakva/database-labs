package ua.lviv.iot.database.lab4.dao;

import ua.lviv.iot.database.lab4.models.Consultation;

public interface ConsultationDao extends ManyToManyDao<Consultation, Integer, Integer> {
}
