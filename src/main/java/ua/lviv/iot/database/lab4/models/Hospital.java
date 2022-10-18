package ua.lviv.iot.database.lab4.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hospital {
    private Integer id;
    private String name;
    private String address;
    private String cityName;
}
