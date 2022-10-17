package ua.lviv.iot.database.lab4.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientDiagnosis {
    private Integer patientId;
    private Integer diagnosisId;
}
