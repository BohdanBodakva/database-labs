package ua.lviv.iot.database.lab4.view;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.lviv.iot.database.lab4.controllers.MedicineController;
import ua.lviv.iot.database.lab4.controllers.PatientController;
import ua.lviv.iot.database.lab4.models.Medicine;

@Component
public class View {
    private final PatientController patientController;

    @Autowired
    public View(PatientController patientController) {
        this.patientController = patientController;
    }

    public void da(String name){
        System.out.println(patientController.getAllPatientsFromHospitalByHospitalId(2));
    }

}
