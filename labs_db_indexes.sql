-- Create database
create database if not exists labs_db;

-- Use database
use labs_db;



-- Drop tables if exist
DROP TABLE IF EXISTS patient_medicine;
DROP TABLE IF EXISTS patient_diagnosis;
DROP TABLE IF EXISTS doctor_position;
DROP TABLE IF EXISTS consultation;
DROP TABLE IF EXISTS patient;
DROP TABLE IF EXISTS doctor;
DROP TABLE IF EXISTS hospital;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS medicine;
DROP TABLE IF EXISTS diagnosis;
DROP TABLE IF EXISTS region;
DROP TABLE IF EXISTS work_position;
DROP TABLE IF EXISTS `data`;



-- Create Tables
-- Table: city
CREATE TABLE city (
    `name` varchar(70) NOT NULL,
    region_name varchar(70) NOT NULL,
    CONSTRAINT city_pk PRIMARY KEY (`name`)
);

-- Table: consultation
CREATE TABLE consultation (
    patient_id int NOT NULL,
    doctor_id int NOT NULL,
    `date` date NOT NULL,
    conclusion text NOT NULL,
    CONSTRAINT consultation_pk PRIMARY KEY (patient_id,doctor_id,`date`)
);

-- Table: data
CREATE TABLE `data` (
    id int NOT NULL auto_increment,
    temperature_in_celsius float NOT NULL,
    systolic_pressure int NOT NULL,
    diastolic_pressure int NOT NULL,
    heart_rate_in_minute int NOT NULL,
    special_notes text NULL,
    CONSTRAINT data_pk PRIMARY KEY (id)
);

-- Table: diagnosis
CREATE TABLE diagnosis (
    `name` varchar(90) NOT NULL,
    CONSTRAINT diagnosis_pk PRIMARY KEY (`name`)
);

-- Table: doctor
CREATE TABLE doctor (
    id int NOT NULL auto_increment,
    surname varchar(50) NOT NULL,
    `name` varchar(50) NOT NULL,
    previous_experience_in_years int NOT NULL,
    hire_date date NOT NULL,
    hospital_id int NOT NULL,
    salary_in_hrn int NOT NULL,
    CONSTRAINT doctor_pk PRIMARY KEY (id)
);

-- Table: doctor_position
CREATE TABLE doctor_position (
    doctor_id int NOT NULL,
    position_name varchar(90) NOT NULL,
    CONSTRAINT doctor_position_pk PRIMARY KEY (doctor_id,position_name)
);

-- Table: hospital
CREATE TABLE hospital (
    id int NOT NULL auto_increment,
    `name` varchar(100) NOT NULL,
    address varchar(100) NOT NULL,
    city_name varchar(70) NOT NULL,
    CONSTRAINT hospital_pk PRIMARY KEY (id)
);

-- Table: medicine
CREATE TABLE medicine (
    `name` varchar(100) NOT NULL,
    CONSTRAINT medicine_pk PRIMARY KEY (`name`)
);

-- Table: patient
CREATE TABLE patient (
    id int NOT NULL auto_increment,
    surname varchar(50) NOT NULL,
    `name` varchar(50) NOT NULL,
    registration_date date NOT NULL,
    data_id int NOT NULL,
    hospital_id int NOT NULL,
    CONSTRAINT patient_pk PRIMARY KEY (id)
);

-- Table: patient_diagnosis
CREATE TABLE patient_diagnosis (
    patient_id int NOT NULL,
    diagnosis_name varchar(90) NOT NULL,
    CONSTRAINT patient_diagnosis_pk PRIMARY KEY (patient_id,diagnosis_name)
);

-- Table: patient_medicine
CREATE TABLE patient_medicine (
    patient_id int NOT NULL,
    medicine_name varchar(100) NOT NULL,
    special_notes text NULL,
    CONSTRAINT patient_medicine_pk PRIMARY KEY (patient_id,medicine_name)
);

-- Table: region
CREATE TABLE region (
    `name` varchar(70) NOT NULL,
    CONSTRAINT region_pk PRIMARY KEY (`name`)
);

-- Table: work_position
CREATE TABLE work_position (
    `name` varchar(90) NOT NULL,
    CONSTRAINT work_position_pk PRIMARY KEY (`name`)
);



-- Add foreign keys
-- Reference: city_region (table: city)
ALTER TABLE city ADD CONSTRAINT city_region FOREIGN KEY city_region (region_name)
    REFERENCES region (`name`) ON DELETE CASCADE;

-- Reference: consultation_doctor (table: consultation)
ALTER TABLE consultation ADD CONSTRAINT consultation_doctor FOREIGN KEY consultation_doctor (doctor_id)
    REFERENCES doctor (id) ON DELETE CASCADE;

-- Reference: consultation_patient (table: consultation)
ALTER TABLE consultation ADD CONSTRAINT consultation_patient FOREIGN KEY consultation_patient (patient_id)
    REFERENCES patient (id) ON DELETE CASCADE;

-- Reference: doctor_hospital (table: doctor)
ALTER TABLE doctor ADD CONSTRAINT doctor_hospital FOREIGN KEY doctor_hospital (hospital_id)
    REFERENCES hospital (id) ON DELETE CASCADE;

-- Reference: doctor_position_doctor (table: doctor_position)
ALTER TABLE doctor_position ADD CONSTRAINT doctor_position_doctor FOREIGN KEY doctor_position_doctor (doctor_id)
    REFERENCES doctor (id) ON DELETE CASCADE;

-- Reference: doctor_position_position (table: doctor_position)
ALTER TABLE doctor_position ADD CONSTRAINT doctor_position_position FOREIGN KEY doctor_position_position (position_name)
    REFERENCES work_position (name) ON DELETE CASCADE;

-- Reference: hospital_city (table: hospital)
ALTER TABLE hospital ADD CONSTRAINT hospital_city FOREIGN KEY hospital_city (city_name)
    REFERENCES city (`name`) ON DELETE CASCADE;

-- Reference: patient_data (table: patient)
ALTER TABLE patient ADD CONSTRAINT patient_data FOREIGN KEY patient_data (data_id)
    REFERENCES `data` (id) ON DELETE CASCADE;

-- Reference: patient_diagnosis_diagnosis (table: patient_diagnosis)
ALTER TABLE patient_diagnosis ADD CONSTRAINT patient_diagnosis_diagnosis FOREIGN KEY patient_diagnosis_diagnosis (diagnosis_name)
    REFERENCES diagnosis (`name`) ON DELETE CASCADE;

-- Reference: patient_diagnosis_patient (table: patient_diagnosis)
ALTER TABLE patient_diagnosis ADD CONSTRAINT patient_diagnosis_patient FOREIGN KEY patient_diagnosis_patient (patient_id)
    REFERENCES patient (id) ON DELETE CASCADE;

-- Reference: patient_hospital (table: patient)
ALTER TABLE patient ADD CONSTRAINT patient_hospital FOREIGN KEY patient_hospital (hospital_id)
    REFERENCES hospital (id) ON DELETE CASCADE;

-- Reference: patient_medicine_medicine (table: patient_medicine)
ALTER TABLE patient_medicine ADD CONSTRAINT patient_medicine_medicine FOREIGN KEY patient_medicine_medicine (medicine_name)
    REFERENCES medicine (`name`) ON DELETE CASCADE;

-- Reference: patient_medicine_patient (table: patient_medicine)
ALTER TABLE patient_medicine ADD CONSTRAINT patient_medicine_patient FOREIGN KEY patient_medicine_patient (patient_id)
    REFERENCES patient (id) ON DELETE CASCADE;           
    
    
    
-- Create indexes  
CREATE INDEX city_name_idx ON city(`name`);   
CREATE INDEX hospital_name_idx ON hospital(`name`); 
CREATE INDEX patient_surname_name_idx ON patient(surname,`name`);  
CREATE INDEX doctor_surname_name_idx ON doctor(surname,`name`);        
    
    
    
-- Insert values into tables
-- Region
insert into region(`name`) values('Kyiv region'); 
insert into region(`name`) values('Lviv region');
insert into region(`name`) values('Rivne region');
insert into region(`name`) values('Odesa region');
insert into region(`name`) values('Volyn region');
insert into region(`name`) values('Ternopil region');
insert into region(`name`) values('Ivano-Frankivsk region');
insert into region(`name`) values('Kropyvnytskyi region');
insert into region(`name`) values('Zhytomyr region');
insert into region(`name`) values('Mykolaiv region');
insert into region(`name`) values('Zakarpattia region');
insert into region(`name`) values('Kherson region');

-- Diagnosis
insert into diagnosis(`name`) values('pneumonia');
insert into diagnosis(`name`) values('bronchitis');
insert into diagnosis(`name`) values('flu');
insert into diagnosis(`name`) values('poisoning');
insert into diagnosis(`name`) values('allergy');
insert into diagnosis(`name`) values('acetonemia');
insert into diagnosis(`name`) values('cystitic');
insert into diagnosis(`name`) values('candidiasis');
insert into diagnosis(`name`) values('stomatitis');

-- City
insert into city(`name`, region_name) values('Rivne', 'Rivne region');
insert into city(`name`, region_name) values('Korets', 'Rivne region');
insert into city(`name`, region_name) values('Kyiv', 'Kyiv region');
insert into city(`name`, region_name) values('Bila Tserkva', 'Kyiv region');
insert into city(`name`, region_name) values('Kalush', 'Ivano-Frankivsk region');
insert into city(`name`, region_name) values('Ivano-Frankivsk', 'Ivano-Frankivsk region');
insert into city(`name`, region_name) values('Lutsk', 'Volyn region');
insert into city(`name`, region_name) values('Kherson', 'Kherson region');
insert into city(`name`, region_name) values('Zhytomyr', 'Zhytomyr region');
insert into city(`name`, region_name) values('Ternopil', 'Ternopil region');
insert into city(`name`, region_name) values('Pochaiv', 'Ternopil region');
insert into city(`name`, region_name) values('Mykolaiv', 'Mykolaiv region');

-- Work_Position
insert into work_position(`name`) values('virologist');
insert into work_position(`name`) values('therapist');
insert into work_position(`name`) values('bacteriologist');
insert into work_position(`name`) values('urologist');
insert into work_position(`name`) values('dentist');
insert into work_position(`name`) values('pediatrician');
insert into work_position(`name`) values('allergist');
insert into work_position(`name`) values('pulmonologist');
insert into work_position(`name`) values('ENT doctor');
insert into work_position(`name`) values('infectious disease specialist');

-- Hospital
insert into hospital(`name`, address, city_name) values('Rivne Regional Hospital', 'Makarova street, 10', 'Rivne');
insert into hospital(`name`, address, city_name) values('Rivne Health Centre', 'Kyivska street, 4', 'Rivne');
insert into hospital(`name`, address, city_name) values('Kyiv City Clinical Hospital', 'Khreshchatyk street, 154', 'Kyiv');
insert into hospital(`name`, address, city_name) values('Zhytomyr Military hospital', 'Military street, 15', 'Zhytomyr');
insert into hospital(`name`, address, city_name) values('Ternopil Hospital №1', 'Shpytalna street, 9', 'Ternopil');
insert into hospital(`name`, address, city_name) values('Pochaiv District Komunalna Likarnya', 'Hospitalna street, 6', 'Pochaiv');
insert into hospital(`name`, address, city_name) values('Mykolaiv Hospital for War Veterans', 'Kyivska street, 1', 'Mykolaiv');
insert into hospital(`name`, address, city_name) values('Korets Tsentralna Rayonna Likarnya', 'Volodymirska street, 14a', 'Korets');
insert into hospital(`name`, address, city_name) values('Bilotserkivsʹkyy Viysʹkovyy Hospital', 'Bulvar Oleksandriivskii, 109', 'Bila Tserkva');
insert into hospital(`name`, address, city_name) values('Lutsk Municipal Clinical Hospital', 'Vidrodzennia avenue, 13', 'Lutsk');
insert into hospital(`name`, address, city_name) values('Kalush Central District Hospital', 'Medychna street, 6', 'Kalush');
insert into hospital(`name`, address, city_name) values('Ivano-Frankivsk Regional Clinical Hospital', 'Fedkovicha street, 91', 'Ivano-Frankivsk');
insert into hospital(`name`, address, city_name) values('Kherson City Clinical Hospital', 'Krymska street, 138', 'Kherson');

-- Doctor
insert into doctor(surname, `name`, previous_experience_in_years, hire_date, hospital_id, salary_in_hrn) values('Vasylkovskii', 'Roman', 4, '2010-01-04', 2, 16500);
insert into doctor(surname, `name`, previous_experience_in_years, hire_date, hospital_id, salary_in_hrn) values('Kozak', 'Denys', 2, '2018-11-05', 7, 11200);
insert into doctor(surname, `name`, previous_experience_in_years, hire_date, hospital_id, salary_in_hrn) values('Lyulka', 'Vladyslav', 17, '2017-12-12', 4, 27700);
insert into doctor(surname, `name`, previous_experience_in_years, hire_date, hospital_id, salary_in_hrn) values('Borylyuk', 'Vladyslav', 7, '2016-10-10', 4, 20000);
insert into doctor(surname, `name`, previous_experience_in_years, hire_date, hospital_id, salary_in_hrn) values('Samanchuk', 'Iryna', 3, '2020-02-17', 7, 10000);
insert into doctor(surname, `name`, previous_experience_in_years, hire_date, hospital_id, salary_in_hrn) values('Ivanenko', 'Oleksandr', 0, '2022-11-11', 2, 7500);
insert into doctor(surname, `name`, previous_experience_in_years, hire_date, hospital_id, salary_in_hrn) values('Dovbenko', 'Ilarion', 1, '2021-07-21', 2, 12500);
insert into doctor(surname, `name`, previous_experience_in_years, hire_date, hospital_id, salary_in_hrn) values('Zenkivskyi', 'Bohdan', 8, '2019-09-19', 4, 13000);
insert into doctor(surname, `name`, previous_experience_in_years, hire_date, hospital_id, salary_in_hrn) values('Pobozhna', 'Oksana', 2, '2019-09-24', 7, 8000);
insert into doctor(surname, `name`, previous_experience_in_years, hire_date, hospital_id, salary_in_hrn) values('Shokalo', 'Natalia', 2, '2014-04-09', 7, 14400);

-- Doctor_Position
insert into doctor_position(doctor_id, position_name) values(1, 'virologist');
insert into doctor_position(doctor_id, position_name) values(1, 'therapist');
insert into doctor_position(doctor_id, position_name) values(2, 'therapist');
insert into doctor_position(doctor_id, position_name) values(3, 'bacteriologist');
insert into doctor_position(doctor_id, position_name) values(4, 'urologist');
insert into doctor_position(doctor_id, position_name) values(5, 'dentist');
insert into doctor_position(doctor_id, position_name) values(6, 'bacteriologist');
insert into doctor_position(doctor_id, position_name) values(6, 'pediatrician');
insert into doctor_position(doctor_id, position_name) values(7, 'pulmonologist');
insert into doctor_position(doctor_id, position_name) values(7, 'ENT doctor');
insert into doctor_position(doctor_id, position_name) values(8, 'ENT doctor');
insert into doctor_position(doctor_id, position_name) values(9, 'infectious disease specialist');
insert into doctor_position(doctor_id, position_name) values(10, 'allergist');

-- Data
insert into data(temperature_in_celsius, systolic_pressure, diastolic_pressure, heart_rate_in_minute) values(38.6, 130, 75, 74);
insert into data(temperature_in_celsius, systolic_pressure, diastolic_pressure, heart_rate_in_minute, special_notes) values(40.4, 150, 90, 89, 'patient needs urgent medical intervention');
insert into data(temperature_in_celsius, systolic_pressure, diastolic_pressure, heart_rate_in_minute) values(38.0, 124, 70, 65);
insert into data(temperature_in_celsius, systolic_pressure, diastolic_pressure, heart_rate_in_minute) values(39.0, 140, 80, 77);
insert into data(temperature_in_celsius, systolic_pressure, diastolic_pressure, heart_rate_in_minute) values(37.8, 140, 98, 65);
insert into data(temperature_in_celsius, systolic_pressure, diastolic_pressure, heart_rate_in_minute) values(36.9, 95, 69, 59);
insert into data(temperature_in_celsius, systolic_pressure, diastolic_pressure, heart_rate_in_minute) values(38.0, 145, 70, 81);
insert into data(temperature_in_celsius, systolic_pressure, diastolic_pressure, heart_rate_in_minute, special_notes) values(41.5, 165, 92, 90, 'patient needs urgent medical intervention');
insert into data(temperature_in_celsius, systolic_pressure, diastolic_pressure, heart_rate_in_minute) values(38.0, 140, 80, 77);
insert into data(temperature_in_celsius, systolic_pressure, diastolic_pressure, heart_rate_in_minute) values(39.4, 140, 80, 69);

-- Medicine
insert into medicine(`name`) values('penicillin');
insert into medicine(`name`) values('molnupiravir');
insert into medicine(`name`) values('flixotide');
insert into medicine(`name`) values('agropyron');
insert into medicine(`name`) values('enterosgel');
insert into medicine(`name`) values('cetirizine');
insert into medicine(`name`) values('subalin');
insert into medicine(`name`) values('furamag');
insert into medicine(`name`) values('clotrimazole');
insert into medicine(`name`) values('chlorophyllipt');

-- Patient
insert into patient(surname, `name`, registration_date, data_id, hospital_id) values('Shevchenko', 'Bohdan', '2022-08-12', 1, 2);
insert into patient(surname, `name`, registration_date, data_id, hospital_id) values('Dovzhenko', 'Ostap', '2022-08-13', 2, 2);
insert into patient(surname, `name`, registration_date, data_id, hospital_id) values('Starchuk', 'Oleksandra', '2022-07-11', 3, 7);
insert into patient(surname, `name`, registration_date, data_id, hospital_id) values('Zhuk', 'Ivan', '2022-06-01', 4, 7);
insert into patient(surname, `name`, registration_date, data_id, hospital_id) values('Sashenko', 'Ignatiy', '2022-08-25', 5, 4);
insert into patient(surname, `name`, registration_date, data_id, hospital_id) values('Ukrainets', 'Oksana', '2022-09-02', 6, 4);
insert into patient(surname, `name`, registration_date, data_id, hospital_id) values('Polonska', 'Margaryta', '2022-09-03', 7, 4);
insert into patient(surname, `name`, registration_date, data_id, hospital_id) values('Zhabchak', 'Roman', '2022-08-29', 8, 2);
insert into patient(surname, `name`, registration_date, data_id, hospital_id) values('Golovinskyi', 'Igor', '2022-08-27', 9, 7);
insert into patient(surname, `name`, registration_date, data_id, hospital_id) values('Ignatenko', 'Ksenia', '2022-09-01', 10, 7);

-- Patient_Medicine
insert into patient_medicine(patient_id, medicine_name) values(1, 'penicillin');
insert into patient_medicine(patient_id, medicine_name) values(1, 'molnupiravir');
insert into patient_medicine(patient_id, medicine_name) values(2, 'molnupiravir');
insert into patient_medicine(patient_id, medicine_name) values(2, 'flixotide');
insert into patient_medicine(patient_id, medicine_name, special_notes) values(3, 'agropyron', 'extend the course for 3 days');
insert into patient_medicine(patient_id, medicine_name) values(4, 'enterosgel');
insert into patient_medicine(patient_id, medicine_name) values(4, 'agropyron');
insert into patient_medicine(patient_id, medicine_name) values(5, 'agropyron');
insert into patient_medicine(patient_id, medicine_name) values(6, 'cetirizine');
insert into patient_medicine(patient_id, medicine_name, special_notes) values(6, 'subalin', 'extend the course for 10 days');
insert into patient_medicine(patient_id, medicine_name, special_notes) values(7, 'molnupiravir', 'extend the course for 1 day');
insert into patient_medicine(patient_id, medicine_name, special_notes) values(8, 'furamag', 'extend the course for 21 days');
insert into patient_medicine(patient_id, medicine_name) values(9, 'chlorophyllipt');
insert into patient_medicine(patient_id, medicine_name, special_notes) values(10, 'subalin', 'extend the course for 4 days');

-- Patient_Diagnosis
insert into patient_diagnosis(patient_id, diagnosis_name) values(1, 'pneumonia');
insert into patient_diagnosis(patient_id, diagnosis_name) values(2, 'bronchitis');
insert into patient_diagnosis(patient_id, diagnosis_name) values(3, 'pneumonia');
insert into patient_diagnosis(patient_id, diagnosis_name) values(4, 'poisoning');
insert into patient_diagnosis(patient_id, diagnosis_name) values(5, 'stomatitis');
insert into patient_diagnosis(patient_id, diagnosis_name) values(6, 'acetonemia');
insert into patient_diagnosis(patient_id, diagnosis_name) values(7, 'acetonemia');
insert into patient_diagnosis(patient_id, diagnosis_name) values(8, 'acetonemia');
insert into patient_diagnosis(patient_id, diagnosis_name) values(9, 'cystitic');
insert into patient_diagnosis(patient_id, diagnosis_name) values(10, 'poisoning');

-- Consultation
insert into consultation(patient_id, doctor_id, `date`, conclusion) values(1, 1, '2022-08-12', 'treatment was prescribed');
insert into consultation(patient_id, doctor_id, `date`, conclusion) values(1, 6, '2022-08-13', 'treatment was prescribed');
insert into consultation(patient_id, doctor_id, `date`, conclusion) values(2, 6, '2022-08-13', 'treatment was prescribed');
insert into consultation(patient_id, doctor_id, `date`, conclusion) values(2, 7, '2022-08-17', 'treatment was prescribed');
insert into consultation(patient_id, doctor_id, `date`, conclusion) values(3, 2, '2022-07-11', 'treatment was prescribed');
insert into consultation(patient_id, doctor_id, `date`, conclusion) values(3, 5, '2022-08-24', 'treatment was prescribed');
insert into consultation(patient_id, doctor_id, `date`, conclusion) values(4, 9, '2022-06-01', 'treatment was prescribed');
insert into consultation(patient_id, doctor_id, `date`, conclusion) values(4, 10, '2022-06-30', 'treatment was prescribed');
insert into consultation(patient_id, doctor_id, `date`, conclusion) values(4, 5, '2022-07-21', 'treatment was prescribed');
insert into consultation(patient_id, doctor_id, `date`, conclusion) values(5, 3, '2022-08-25', 'treatment was prescribed');
insert into consultation(patient_id, doctor_id, `date`, conclusion) values(5, 8, '2022-08-30', 'treatment was prescribed');
insert into consultation(patient_id, doctor_id, `date`, conclusion) values(6, 4, '2022-09-02', 'treatment was prescribed');
insert into consultation(patient_id, doctor_id, `date`, conclusion) values(6, 8, '2022-09-03', 'treatment was prescribed');
insert into consultation(patient_id, doctor_id, `date`, conclusion) values(7, 4, '2022-09-03', 'treatment was prescribed');
insert into consultation(patient_id, doctor_id, `date`, conclusion) values(7, 4, '2022-09-05', 'treatment was prescribed');
insert into consultation(patient_id, doctor_id, `date`, conclusion) values(8, 6, '2022-08-29', 'treatment was prescribed');
insert into consultation(patient_id, doctor_id, `date`, conclusion) values(8, 1, '2022-09-01', 'treatment was prescribed');
insert into consultation(patient_id, doctor_id, `date`, conclusion) values(9, 9, '2022-08-28', 'treatment was prescribed');
insert into consultation(patient_id, doctor_id, `date`, conclusion) values(9, 2, '2022-08-29', 'treatment was prescribed');
insert into consultation(patient_id, doctor_id, `date`, conclusion) values(10, 10, '2022-09-01', 'treatment was prescribed');
insert into consultation(patient_id, doctor_id, `date`, conclusion) values(10, 5, '2022-09-04', 'treatment was prescribed');











