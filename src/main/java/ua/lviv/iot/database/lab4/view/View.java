package ua.lviv.iot.database.lab4.view;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.lviv.iot.database.lab4.controllers.MedicineController;
import ua.lviv.iot.database.lab4.models.Medicine;

@Component
public class View {
    private final MedicineController medicineController;

    @Autowired
    public View(MedicineController medicineController) {
        this.medicineController = medicineController;
    }

    public void da(String name, Medicine u){
        System.out.println(medicineController.update(name, u));
    }

}
