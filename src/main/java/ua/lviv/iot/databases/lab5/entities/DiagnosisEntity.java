package ua.lviv.iot.databases.lab5.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "diagnosis")
@Data
@NoArgsConstructor
public class DiagnosisEntity {
    @Id
    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH}, mappedBy = "diagnoses")
    private List<PatientEntity> patients;

    public DiagnosisEntity(String name) {
        this.name = name;
    }
}
