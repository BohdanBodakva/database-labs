package ua.lviv.iot.database.lab4.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientData {
    private Integer id;
    private float temperatureInCelsius;
    private int systolicPressure;
    private int diastolicPressure;
    private int heartRateInMinute;
    private String specialNotes;
}
