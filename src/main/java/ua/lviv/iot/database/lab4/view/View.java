package ua.lviv.iot.database.lab4.view;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import ua.lviv.iot.database.lab4.controllers.*;
import ua.lviv.iot.database.lab4.models.*;

import java.time.LocalDate;
import java.util.*;

@Component
public class View {
    private final MedicineController medicineController;
    private final DiagnosisController diagnosisController;
    private final RegionController regionController;
    private final CityController cityController;
    private final WorkPositionController workPositionController;
    private final PatientDataController patientDataController;
    private final PatientController patientController;
    private final HospitalController hospitalController;
    private final DoctorController doctorController;
    private final PatientMedicineController patientMedicineController;
    private final PatientDiagnosisController patientDiagnosisController;
    private final DoctorPositionController doctorPositionController;
    private final ConsultationController consultationController;

    @Autowired
    public View(MedicineController medicineController, DiagnosisController diagnosisController,
                RegionController regionController, CityController cityController,
                WorkPositionController workPositionController, PatientDataController patientDataController,
                PatientController patientController, HospitalController hospitalController,
                DoctorController doctorController, PatientMedicineController patientMedicineController,
                PatientDiagnosisController patientDiagnosisController, DoctorPositionController doctorPositionController,
                ConsultationController consultationController) {
        this.medicineController = medicineController;
        this.diagnosisController = diagnosisController;
        this.regionController = regionController;
        this.cityController = cityController;
        this.workPositionController = workPositionController;
        this.patientDataController = patientDataController;
        this.patientController = patientController;
        this.hospitalController = hospitalController;
        this.doctorController = doctorController;
        this.patientMedicineController = patientMedicineController;
        this.patientDiagnosisController = patientDiagnosisController;
        this.doctorPositionController = doctorPositionController;
        this.consultationController = consultationController;


        this.menu = new HashMap<>();
        this.methodsMenu = new HashMap<>();

        menu.put("1", "1 - Table: Medicine");
        menu.put("11", "11 - find all Medicine");
        menu.put("12", "12 - find Medicine by name");
        menu.put("13", "13 - create Medicine");
        menu.put("14", "14 - update Medicine");
        menu.put("15", "15 - delete Medicine");

        methodsMenu.put("11", this::getAllMedicine);
        methodsMenu.put("12", this::getAllMedicineByNameTemplate);
        methodsMenu.put("13", this::createMedicine);
        methodsMenu.put("14", this::updateMedicine);
        methodsMenu.put("15", this::deleteMedicineByName);

        menu.put("2", "2 - Table: Diagnosis");
        menu.put("21", "21 - find all Diagnosis");
        menu.put("22", "22 - find Diagnosis by name");
        menu.put("23", "23 - create Diagnosis");
        menu.put("24", "24 - update Diagnosis");
        menu.put("25", "25 - delete Diagnosis");

        methodsMenu.put("21", this::getAllDiagnosis);
        methodsMenu.put("22", this::getAllDiagnosisByNameTemplate);
        methodsMenu.put("23", this::createDiagnosis);
        methodsMenu.put("24", this::updateDiagnosis);
        methodsMenu.put("25", this::deleteDiagnosisByName);

        menu.put("3", "3 - Table: WorkPosition");
        menu.put("31", "31 - find all WorkPositions");
        menu.put("32", "32 - find WorkPositions by name");
        menu.put("33", "33 - create WorkPosition");
        menu.put("34", "34 - update WorkPosition");
        menu.put("35", "35 - delete WorkPosition");

        methodsMenu.put("31", this::getAllWorkPositions);
        methodsMenu.put("32", this::getAllWorkPositionsByNameTemplate);
        methodsMenu.put("33", this::createWorkPosition);
        methodsMenu.put("34", this::updateWorkPosition);
        methodsMenu.put("35", this::deleteWorkPositionByName);

        menu.put("4", "4 - Table: City");
        menu.put("41", "41 - find all Cities");
        menu.put("42", "42 - find Cities by name");
        menu.put("43", "43 - create City");
        menu.put("44", "44 - update City");
        menu.put("45", "45 - delete City");

        methodsMenu.put("41", this::getAllCities);
        methodsMenu.put("42", this::getAllCitiesByNameTemplate);
        methodsMenu.put("43", this::createCity);
        methodsMenu.put("44", this::updateCity);
        methodsMenu.put("45", this::deleteCityByName);

        menu.put("5", "5 - Table: Region");
        menu.put("51", "51 - find all Regions");
        menu.put("52", "52 - find Regions by name");
        menu.put("53", "53 - create Region");
        menu.put("54", "54 - update Region");
        menu.put("55", "55 - delete Region");
        menu.put("56", "56 - find all cities from Region");

        methodsMenu.put("51", this::getAllRegions);
        methodsMenu.put("52", this::getAllRegionsByNameTemplate);
        methodsMenu.put("53", this::createRegion);
        methodsMenu.put("54", this::updateRegion);
        methodsMenu.put("55", this::deleteRegionByName);
        methodsMenu.put("56", this::getAllCitiesFromRegionByRegionName);

        menu.put("6", "6 - Table: Doctor");
        menu.put("61", "61 - find all Doctors");
        menu.put("62", "62 - find Doctor by id");
        menu.put("63", "63 - find Doctors by surname");
        menu.put("64", "64 - create Doctor");
        menu.put("65", "65 - update Doctor");
        menu.put("66", "66 - delete Doctor");
        menu.put("67", "67 - find Doctors by experience");
        menu.put("68", "68 - find Doctors from hospital");

        methodsMenu.put("61", this::getAllDoctors);
        methodsMenu.put("62", this::getDoctorById);
        methodsMenu.put("63", this::getAllDoctorsBySurnameTemplate);
        methodsMenu.put("64", this::createDoctor);
        methodsMenu.put("65", this::updateDoctor);
        methodsMenu.put("66", this::deleteDoctorById);
        methodsMenu.put("67", this::getAllDoctorsWithExperienceMoreThan);
        methodsMenu.put("68", this::getAllDoctorsFromHospitalByHospitalId);

        menu.put("7", "7 - Table: Data");
        menu.put("71", "72 - find all Data");
        menu.put("72", "72 - find Data by id");
        menu.put("73", "73 - update Data");

        methodsMenu.put("71", this::getAllPatientData);
        methodsMenu.put("72", this::getPatientDataById);
        methodsMenu.put("73", this::updatePatientDataById);

        menu.put("8", "2 - Table: Patient");
        menu.put("81", "81 - find all Patients");
        menu.put("82", "82 - find Patient by id");
        menu.put("83", "83 - find Patients by surname");
        menu.put("84", "84 - create Patient");
        menu.put("85", "85 - update Patient");
        menu.put("86", "86 - delete Patient");
        menu.put("87", "87 - find patients from hospital");

        methodsMenu.put("81", this::getAllPatients);
        methodsMenu.put("82", this::getPatientById);
        methodsMenu.put("83", this::getAllPatientsBySurnameTemplate);
        methodsMenu.put("84", this::createPatient);
        methodsMenu.put("85", this::updatePatient);
        methodsMenu.put("86", this::deletePatientById);
        methodsMenu.put("87", this::getAllPatientsFromHospitalByHospitalId);

        menu.put("9", "9 - Table: Hospital");
        menu.put("91", "91 - find Hospital by id");
        menu.put("92", "92 - find all Hospitals");
        menu.put("93", "93 - find Hospitals by name");
        menu.put("94", "94 - create Hospital");
        menu.put("95", "95 - update Hospital");
        menu.put("96", "96 - delete Hospital");

        methodsMenu.put("91", this::getAllHospitals);
        methodsMenu.put("92", this::getHospitalById);
        methodsMenu.put("93", this::getAllHospitalsByNameTemplate);
        methodsMenu.put("94", this::createHospital);
        methodsMenu.put("95", this::updateHospital);
        methodsMenu.put("96", this::deleteHospitalById);

//        menu.put("10", "10 - Table: Consultation");
//        menu.put("101", "101 - find all Consultations");
//        menu.put("102", "102 - find Consultation by id");
//        menu.put("103", "103 - create Consultation");
//        menu.put("104", "104 - update Consultation");
//        menu.put("105", "105 - delete Consultation");

    }

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet()) {
            if (key.length() == 1) {
                System.out.println(menu.get(key));
            }
        }
    }

    private void outputSubMenu(String fig) {
        System.out.println("\nSubMENU:");
        for (String key : menu.keySet()){
            if (key.length() == 2  && !key.equals("10") && key.substring(0, 1).equals(fig)){
                System.out.println(menu.get(key));
            }
        }

    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point:");
            keyMenu = scanner.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point:");
                keyMenu = scanner.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (!keyMenu.equals("q"));
    }


    private final Scanner scanner = new Scanner(System.in);
    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;



//    Medicine
    public void getAllMedicine(){
        List<Medicine> medicine = medicineController.findAll();
        for(Medicine med : medicine){
            System.out.println(med);
        }
    }
    public void getAllMedicineByNameTemplate(){
        System.out.println("\nEnter name: ");
        String nameTemplate = scanner.nextLine();
        List<Medicine> medicine = medicineController.getAllMedicineByName(nameTemplate);
        for(Medicine med : medicine){
            System.out.println(med);
        }
    }
    public void createMedicine(){
        try {
            System.out.println("\nEnter name: ");
            String name = scanner.nextLine();
            System.out.println(medicineController.create(new Medicine(name)));
        }catch (DuplicateKeyException e){
            System.out.println("Such medicine already exists!");
        }

    }
    public void updateMedicine(){
        System.out.println("\nEnter medicine name to update: ");
        String medicineNameToUpdate = scanner.nextLine();
        System.out.println("\nEnter new medicine name: ");
        String newMedicineName = scanner.nextLine();
        System.out.println(medicineController.update(medicineNameToUpdate, new Medicine(newMedicineName)));
    }
    public void deleteMedicineByName(){
        System.out.println("\nEnter name: ");
        String name = scanner.nextLine();
        System.out.println(medicineController.delete(name));
    }


//    Diagnosis
    public void getAllDiagnosis(){
        List<Diagnosis> diagnoses = diagnosisController.findAll();
        for(Diagnosis d : diagnoses){
            System.out.println(d);
        }
    }
    public void getAllDiagnosisByNameTemplate(){
        System.out.println("\nEnter name: ");
        String nameTemplate = scanner.nextLine();
        List<Diagnosis> diagnoses = diagnosisController.getAllDiagnosisByName(nameTemplate);
        for(Diagnosis d : diagnoses){
            System.out.println(d);
        }
    }
    public void createDiagnosis(){
        try {
            System.out.println("\nEnter name: ");
            String name = scanner.nextLine();
            System.out.println(diagnosisController.create(new Diagnosis(name)));
        }catch (DuplicateKeyException e){
            System.out.println("Such diagnosis already exists!");
        }
    }
    public void updateDiagnosis(){
        System.out.println("\nEnter diagnosis name to update: ");
        String diagnosisNameToUpdate = scanner.nextLine();
        System.out.println("\nEnter new diagnosis name: ");
        String newDiagnosisName = scanner.nextLine();
        System.out.println(diagnosisController.update(diagnosisNameToUpdate, new Diagnosis(newDiagnosisName)));
    }
    public void deleteDiagnosisByName(){
        System.out.println("\nEnter name: ");
        String name = scanner.nextLine();
        System.out.println(diagnosisController.delete(name));
    }


//    Work-Position
    public void getAllWorkPositions(){
        List<WorkPosition> workPositions = workPositionController.findAll();
        for(WorkPosition wp : workPositions){
            System.out.println(wp);
        }
    }
    public void getAllWorkPositionsByNameTemplate(){
        System.out.println("\nEnter name: ");
        String nameTemplate = scanner.nextLine();
        List<WorkPosition> workPositions = workPositionController.getAllWorkPositionsByName(nameTemplate);
        for(WorkPosition wp : workPositions){
            System.out.println(wp);
        }
    }
    public void createWorkPosition(){
        try {
            System.out.println("\nEnter name: ");
            String name = scanner.nextLine();
            System.out.println(workPositionController.create(new WorkPosition(name)));
        }catch (DuplicateKeyException e){
            System.out.println("Such position already exists!");
        }
    }
    public void updateWorkPosition(){
        System.out.println("\nEnter position name to update: ");
        String workPositionNameToUpdate = scanner.nextLine();
        System.out.println("\nEnter new position name: ");
        String newWorkPositionName = scanner.nextLine();
        System.out.println(workPositionController.update(workPositionNameToUpdate,
                                    new WorkPosition(newWorkPositionName)));
    }
    public void deleteWorkPositionByName(){
        System.out.println("\nEnter name: ");
        String name = scanner.nextLine();
        System.out.println(workPositionController.delete(name));
    }


//    City
    public void getAllCities(){
        List<City> cities =  cityController.findAll();
        for(City c : cities){
            System.out.println(c);
        }
    }
    public void getAllCitiesByNameTemplate(){
        System.out.println("\nEnter name: ");
        String nameTemplate = scanner.nextLine();
        List<City> cities =  cityController.getAllCitiesByName(nameTemplate);
        for(City c : cities){
            System.out.println(c);
        }
    }
    public void createCity(){
        try {
            System.out.println("\nEnter city name: ");
            String cityName = scanner.nextLine();
            System.out.println("\nEnter region name: ");
            String regionName = scanner.nextLine();
            System.out.println(cityController.create(new City(cityName, regionName)));
        }catch (DuplicateKeyException e){
            System.out.println("Such city already exists!");
        }

    }
    public void updateCity(){
        System.out.println("\nEnter city name to update: ");
        String cityNameToUpdate = scanner.nextLine();
        System.out.println("\nEnter new city name: ");
        String newCityName = scanner.nextLine();
        System.out.println("\nEnter new region name: ");
        String newRegionName = scanner.nextLine();
        System.out.println(cityController.update(cityNameToUpdate, new City(newCityName, newRegionName)));
    }
    public void deleteCityByName(){
        System.out.println("\nEnter name: ");
        String name = scanner.nextLine();
        System.out.println(cityController.delete(name));
    }


//   Region
    public void getAllRegions(){
        List<Region> regions =  regionController.findAll();
        for(Region r : regions){
            System.out.println(r);
        }
    }
    public void getAllRegionsByNameTemplate(){
        System.out.println("\nEnter name: ");
        String nameTemplate = scanner.nextLine();
        List<Region> regions =  regionController.getAllRegionsByName(nameTemplate);
        for(Region r : regions){
            System.out.println(r);
        }
    }
    public void createRegion(){
        try {
            System.out.println("\nEnter name: ");
            String name = scanner.nextLine();
            System.out.println(regionController.create(new Region(name)));
        }catch (DuplicateKeyException e){
            System.out.println("Such region already exists!");
        }

    }
    public void updateRegion(){
        System.out.println("\nEnter region name to update: ");
        String regionNameToUpdate = scanner.nextLine();
        System.out.println("\nEnter new region name: ");
        String newRegionName = scanner.nextLine();
        System.out.println(regionController.update(regionNameToUpdate, new Region(newRegionName)));
    }
    public void deleteRegionByName(){
        System.out.println("\nEnter name: ");
        String name = scanner.nextLine();
        System.out.println(regionController.delete(name));
    }
    public void getAllCitiesFromRegionByRegionName(){
        System.out.println("\nEnter region name: ");
        String regionName = scanner.nextLine();
        List<City> cities = cityController.getAllCitiesFromRegionByRegionId(regionName);
        for (City c : cities){
            System.out.println(c);
        }
    }


//   Doctor
    public void getAllDoctors(){
        List<Doctor> doctors = doctorController.findAll();
        for(Doctor d : doctors){
            System.out.println(d);
        }
    }
    public void getDoctorById(){
        try{
            System.out.println("\nEnter id: ");
            Integer id = scanner.nextInt();
            System.out.println(doctorController.findById(id));
        }catch (NullPointerException e){
            System.out.println("Doctor with such id doesn't exist!");
        }

    }
    public void getAllDoctorsBySurnameTemplate(){
        System.out.println("\nEnter surname: ");
        String surnameTemplate = scanner.nextLine();
        List<Doctor> doctors = doctorController.getAllDoctorsBySurname(surnameTemplate);
        for(Doctor d : doctors){
            System.out.println(d);
        }
    }
    public void createDoctor(){
        System.out.println("\nEnter surname: ");
        String surname = scanner.nextLine();
        System.out.println("\nEnter name: ");
        String name = scanner.nextLine();
        System.out.println("\nEnter experience: ");
        Integer experience = scanner.nextInt();
        System.out.println("\nEnter hire date: ");
        String hireDate = scanner.nextLine();
        System.out.println("\nEnter hospital id: ");
        Integer hospitalId = scanner.nextInt();
        System.out.println("\nEnter salary: ");
        Integer salary = scanner.nextInt();
        System.out.println(doctorController.create(new Doctor(null, surname, name, experience, LocalDate.parse(hireDate),
                                                    hospitalId, salary)));
    }
    public void updateDoctor(){
        System.out.println("\nEnter doctor id to update: ");
        Integer doctorIdToUpdate = scanner.nextInt();
        System.out.println("\nEnter surname: ");
        String surname = scanner.nextLine();
        System.out.println("\nEnter name: ");
        String name = scanner.nextLine();
        System.out.println("\nEnter experience: ");
        Integer experience = scanner.nextInt();
        System.out.println("\nEnter hire date: ");
        String hireDate = scanner.nextLine();
        System.out.println("\nEnter hospital id: ");
        Integer hospitalId = scanner.nextInt();
        System.out.println("\nEnter salary: ");
        Integer salary = scanner.nextInt();
        System.out.println(doctorController.update(doctorIdToUpdate, new Doctor(null, surname, name, experience,
                                                                        LocalDate.parse(hireDate),
                                                                        hospitalId, salary)));
    }
    public void deleteDoctorById(){
        System.out.println("\nEnter doctor id: ");
        Integer id = scanner.nextInt();
        System.out.println(doctorController.delete(id));
    }
    public void getAllDoctorsWithExperienceMoreThan(){
        System.out.println("\nEnter experience: ");
        Integer experience = scanner.nextInt();
        List<Doctor> doctors = doctorController.getAllDoctorsWithExperienceMoreThan(experience);
        for(Doctor d : doctors){
            System.out.println(d);
        }
    }
    public void getAllDoctorsFromHospitalByHospitalId(){
        System.out.println("\nEnter hospital id: ");
        Integer hospitalId = scanner.nextInt();
        List<Doctor> doctors = doctorController.getAllDoctorsFromHospitalByHospitalId(hospitalId);
        for(Doctor d : doctors){
            System.out.println(d);
        }
    }


//   PatientData
    public void getAllPatientData(){
        List<PatientData> patientData = patientDataController.findAll();
        for(PatientData pd : patientData){
            System.out.println(pd);
        }
    }
    public void getPatientDataById(){
        try{
            System.out.println("\nEnter id: ");
            Integer id = scanner.nextInt();
            System.out.println(patientDataController.findById(id));
        }catch (NullPointerException e){
            System.out.println("Data with such id doesn't exist!");
        }


    }
    public void updatePatientDataById(){
        System.out.println("\nEnter data id to update: ");
        Integer patientDataIdToUpdate = scanner.nextInt();
        System.out.println("\nEnter temperature: ");
        Float temperature = scanner.nextFloat();
        System.out.println("\nEnter systolic pressure: ");
        Integer systPressure = scanner.nextInt();
        System.out.println("\nEnter diastolic pressure: ");
        Integer diastPressure = scanner.nextInt();
        System.out.println("\nEnter heart rate: ");
        Integer heartRate = scanner.nextInt();
        System.out.println("\nEnter special notes: ");
        String specialNotes = scanner.nextLine();
        System.out.println(patientDataController.update(patientDataIdToUpdate, new PatientData(null, temperature,
                                                                                systPressure, diastPressure,
                                                                                heartRate, specialNotes)));
    }


//   Patient
    public void getAllPatients(){
        List<Patient> patients = patientController.findAll();
        for(Patient p : patients){
            System.out.println(p);
        }
    }
    public void getPatientById(){
        try{
            System.out.println("\nEnter id: ");
            Integer id = scanner.nextInt();
            System.out.println(patientController.findById(id));
        }catch (NullPointerException e){
            System.out.println("Patient with such id doesn't exist!");
        }


    }
    public void getAllPatientsBySurnameTemplate(){
        System.out.println("\nEnter surname: ");
        String surnameTemplate = scanner.nextLine();
        List<Patient> patients = patientController.getAllPatientsBySurname(surnameTemplate);
        for(Patient p : patients){
            System.out.println(p);
        }
    }
    public void createPatient(){
        System.out.println("\nEnter surname: ");
        String surname = scanner.nextLine();
        System.out.println("\nEnter name: ");
        String name = scanner.nextLine();
        System.out.println("\nEnter register date: ");
        String registerDate = scanner.nextLine();
        System.out.println("\nEnter hospital id: ");
        Integer hospitalId = scanner.nextInt();
        System.out.println(patientController.create(new Patient(null, surname, name, LocalDate.parse(registerDate),
                                                            null, hospitalId)));
    }
    public void updatePatient(){
        System.out.println("\nEnter patient id to update: ");
        Integer patientIdToUpdate = scanner.nextInt();
        System.out.println("\nEnter surname: ");
        String surname = scanner.nextLine();
        System.out.println("\nEnter name: ");
        String name = scanner.nextLine();
        System.out.println("\nEnter register date: ");
        String registerDate = scanner.nextLine();
        System.out.println("\nEnter hospital id: ");
        Integer hospitalId = scanner.nextInt();
        System.out.println(patientController.update(patientIdToUpdate, new Patient(null, surname, name,
                                            LocalDate.parse(registerDate), null, hospitalId)));
    }
    public void deletePatientById(){
        System.out.println("\nEnter id");
        Integer id  = scanner.nextInt();
        System.out.println(patientController.delete(id));
    }
    public void getAllPatientsFromHospitalByHospitalId(){
        System.out.println("\nEnter hospital id: ");
        Integer hospitalId = scanner.nextInt();
        List<Patient> patients = patientController.getAllPatientsFromHospitalByHospitalId(hospitalId);
        for(Patient p : patients){
            System.out.println(p);
        }
    }


//   Hospital
    public void getAllHospitals(){
        List<Hospital> hospitals = hospitalController.findAll();
        for (Hospital h : hospitals){
            System.out.println(h);
        }
    }
    public void getHospitalById(){
        try{
            System.out.println("Enter id: ");
            Integer id = scanner.nextInt();
            System.out.println(hospitalController.findById(id));
        }catch (NullPointerException e){
            System.out.println("Hospital with such id doesn't exist!");
        }

    }
    public void getAllHospitalsByNameTemplate(){
        System.out.println("Enter name: ");
        String nameTemplate = scanner.nextLine();
        List<Hospital> hospitals = hospitalController.getAllHospitalsByName(nameTemplate);
        for (Hospital h : hospitals){
            System.out.println(h);
        }
    }
    public void createHospital(){
        System.out.println("\nEnter name: ");
        String name = scanner.nextLine();
        System.out.println("\nEnter address: ");
        String address = scanner.nextLine();
        System.out.println("\nEnter city name: ");
        String cityName = scanner.nextLine();
        System.out.println(hospitalController.create(new Hospital(null, name, address, cityName)));
    }
    public void updateHospital(){
        System.out.println("\nEnter hospital id to update: ");
        Integer hospitalIdToUpdate = scanner.nextInt();
        System.out.println("\nEnter name: ");
        String name = scanner.nextLine();
        System.out.println("\nEnter address: ");
        String address = scanner.nextLine();
        System.out.println("\nEnter city name: ");
        String cityName = scanner.nextLine();
        System.out.println(hospitalController.update(hospitalIdToUpdate, new Hospital(null, name, address, cityName)));
    }
    public void deleteHospitalById(){
        System.out.println("\nEnter id: ");
        Integer id = scanner.nextInt();
        System.out.println(hospitalController.delete(id));
    }
    public void getAllHospitalsFromCityByCityName(){
        System.out.println("\nEnter city name: ");
        String cityName = scanner.nextLine();
        List<Hospital> hospitals = hospitalController.getAllHospitalsFromCityByCityId(cityName);
        for (Hospital h : hospitals){
            System.out.println(h);
        }
    }


//   Consultation
    public List<Consultation> getAllConsultations(){
        return consultationController.findAll();
    }
    public Consultation getConsultationById(Integer doctorId, Integer patientId){
        return consultationController.findById(doctorId, patientId);
    }
    public String createConsultation(Integer doctorId, Integer patientId,
                                     String date, String conclusion){
        return consultationController.create(new Consultation(doctorId, patientId,
                                        LocalDate.parse(date), conclusion));
    }
    public String updateConsultation(Integer doctorIdToUpdate, Integer patientIdToUpdate,
                                            Integer newDoctorId, Integer newPatientId,
                                            String date, String conclusion){
        return consultationController.update(doctorIdToUpdate, patientIdToUpdate,
                                            new Consultation(newDoctorId, newPatientId,
                                                LocalDate.parse(date), conclusion));
    }
    public String deleteConsultationById(Integer doctorId, Integer patientId){
        return consultationController.delete(doctorId, patientId);
    }



}
