package ua.lviv.iot.databases.lab5.dto;

import org.springframework.hateoas.RepresentationModel;

public class DataDto extends RepresentationModel<DataDto> {
    private int id;
    private float temperature;
    private int systolicPressure;
    private int diastolicPressure;
    private int heartRate;
    private String specialNotes;
}
