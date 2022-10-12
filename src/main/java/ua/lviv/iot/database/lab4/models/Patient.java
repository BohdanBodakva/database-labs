package ua.lviv.iot.database.lab4.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient {
    private Integer id;
    private String surname;
    private String name;
    private LocalDate registrationDate;
    private Integer patientDataId;
    private Integer hospitalId;
}
