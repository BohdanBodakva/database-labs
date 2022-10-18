package ua.lviv.iot.database.lab4.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientMedicine {
    private Integer patientId;
    private String medicineId;
    private String specialNotes;
}
