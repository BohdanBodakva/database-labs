package ua.lviv.iot.databases.lab5.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "", collectionRelation = "")
public class DataDto extends RepresentationModel<DataDto> {
    private int id;
    private float temperature;
    private int systolicPressure;
    private int diastolicPressure;
    private int heartRate;
    private String specialNotes;
    private String patient;
}
