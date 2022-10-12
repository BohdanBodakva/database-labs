package ua.lviv.iot.database.lab4.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Doctor {
    private Integer id;
    private String surname;
    private String name;
    private int previousExperienceInYears;
    private LocalDate hireDate;
    private Integer hospitalId;
    private int salaryInHrn;
}
