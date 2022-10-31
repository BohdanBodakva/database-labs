package ua.lviv.iot.databases.lab5.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.lviv.iot.databases.lab5.entities.many_to_many.PatientMedicineEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "medicine")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicineEntity {
    @Id
    @Column(name = "name")
    private String name;
}
