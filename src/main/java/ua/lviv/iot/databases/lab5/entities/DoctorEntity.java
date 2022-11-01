package ua.lviv.iot.databases.lab5.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import ua.lviv.iot.databases.lab5.entities.many_to_many.ConsultationEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "doctor")
@Data
@RequiredArgsConstructor
public class DoctorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "previous_experience_in_years")
    private int experience;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @Column(name = "salary_in_hrn")
    private int salary;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hospital_id")
    private HospitalEntity hospital;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(
            name = "doctor_position",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "position_name")
    )
    private List<WorkPositionEntity> positions;

    public void addPosition(WorkPositionEntity workPosition) {
        this.positions.add(workPosition);
        workPosition.getDoctors().add(this);
    }

    public void removePosition(String positionId) {
        WorkPositionEntity position = this.positions.stream().filter(p -> Objects.equals(p.getName(), positionId))
                .findFirst().orElse(null);
        if (position != null) {
            this.positions.remove(position);
            position.getDoctors().remove(this);
        }
    }

}
