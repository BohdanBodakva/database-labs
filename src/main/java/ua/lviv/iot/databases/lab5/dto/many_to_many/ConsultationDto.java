package ua.lviv.iot.databases.lab5.dto.many_to_many;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import ua.lviv.iot.databases.lab5.dto.DoctorDto;
import ua.lviv.iot.databases.lab5.dto.PatientDto;

import java.time.LocalDate;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "", collectionRelation = "")
public class ConsultationDto extends RepresentationModel<ConsultationDto> {
    private int id;
    private int patient;
    private int doctor;
    private LocalDate date;
    private String conclusion;
}
