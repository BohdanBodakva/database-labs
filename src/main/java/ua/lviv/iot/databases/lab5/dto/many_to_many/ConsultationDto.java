package ua.lviv.iot.databases.lab5.dto.many_to_many;

import org.springframework.hateoas.RepresentationModel;
import ua.lviv.iot.databases.lab5.dto.DoctorDto;
import ua.lviv.iot.databases.lab5.dto.PatientDto;

import java.time.LocalDate;

public class ConsultationDto extends RepresentationModel<ConsultationDto> {
    private int id;
    private PatientDto patient;
    private DoctorDto doctor;
    private LocalDate date;
    private String conclusion;
}
