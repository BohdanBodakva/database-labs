package ua.lviv.iot.database.lab4.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Consultation {
    private Integer patientId;
    private Integer doctorId;
    private LocalDate date;
    private String conclusion;
}
