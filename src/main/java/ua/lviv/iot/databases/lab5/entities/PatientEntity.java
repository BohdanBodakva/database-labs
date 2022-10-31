package ua.lviv.iot.databases.lab5.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import ua.lviv.iot.databases.lab5.entities.many_to_many.ConsultationEntity;
import ua.lviv.iot.databases.lab5.entities.many_to_many.PatientMedicineEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "patient")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "registration_date")
    private LocalDate regDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hospital_id")
    private HospitalEntity hospital;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "data_id")
    private DataEntity data;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(
            name = "patient_diagnosis",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "diagnosis_name")
    )
    private List<DiagnosisEntity> diagnoses;

    public void addDiagnosis(DiagnosisEntity diagnosis) {
        this.diagnoses.add(diagnosis);
        diagnosis.getPatients().add(this);
    }

    public void removeDiagnosis(String diagnosisId) {
        DiagnosisEntity diagnosis = this.diagnoses.stream().filter(p -> Objects.equals(p.getName(), diagnosisId))
                .findFirst().orElse(null);
        if (diagnosis != null) {
            this.diagnoses.remove(diagnosis);
            diagnosis.getPatients().remove(this);
        }
    }
}
