package ua.lviv.iot.databases.lab5.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "hospital")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class HospitalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_name")
    private CityEntity city;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "hospital")
    private List<PatientEntity> patients = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "hospital")
    private List<DoctorEntity> doctors = new ArrayList<>();

    public void addPatient(PatientEntity patient){
        patients.add(patient);
        patient.setHospital(this);
    }

    public void deletePatient(int patientId){
        PatientEntity patient = this.patients.stream().filter(p -> Objects.equals(p.getId(), patientId))
                .findFirst().orElse(null);
        if (patient != null) {
            this.patients.remove(patient);
        }
    }

    public void addDoctor(DoctorEntity doctor){
        doctors.add(doctor);
        doctor.setHospital(this);
    }

    public void deleteDoctor(int doctorId){
        DoctorEntity doctor = this.doctors.stream().filter(p -> Objects.equals(p.getId(), doctorId))
                .findFirst().orElse(null);
        if (doctor != null) {
            this.doctors.remove(doctor);
        }
    }
}
