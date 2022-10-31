package ua.lviv.iot.databases.lab5.dto;

import org.springframework.hateoas.RepresentationModel;

public class HospitalDto extends RepresentationModel<HospitalDto> {
    private int id;
    private String name;
    private String address;
    private CityDto city;
}
