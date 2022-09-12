-- Create database
create database if not exists labs_db;

-- Use database
use labs_db;

-- Create Tables
-- Table: city
CREATE TABLE city (
    name varchar(70) NOT NULL,
    region_name varchar(70) NOT NULL,
    CONSTRAINT city_pk PRIMARY KEY (name)
);

-- Table: consultation
CREATE TABLE consultation (
    patient_id int NOT NULL,
    doctor_id int NOT NULL,
    date date NOT NULL,
    conclusion text NOT NULL,
    CONSTRAINT consultation_pk PRIMARY KEY (patient_id,doctor_id,date)
);

-- Table: data
CREATE TABLE data (
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
    name varchar(90) NOT NULL,
    CONSTRAINT diagnosis_pk PRIMARY KEY (name)
);

-- Table: doctor
CREATE TABLE doctor (
    id int NOT NULL auto_increment,
    surname varchar(50) NOT NULL,
    name varchar(50) NOT NULL,
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
    name varchar(100) NOT NULL,
    address varchar(100) NOT NULL,
    city_name varchar(70) NOT NULL,
    CONSTRAINT hospital_pk PRIMARY KEY (id)
);

-- Table: medicine
CREATE TABLE medicine (
    name varchar(100) NOT NULL,
    CONSTRAINT medicine_pk PRIMARY KEY (name)
);

-- Table: patient
CREATE TABLE patient (
    id int NOT NULL auto_increment,
    surname varchar(50) NOT NULL,
    name varchar(50) NOT NULL,
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
    name varchar(70) NOT NULL,
    CONSTRAINT region_pk PRIMARY KEY (name)
);

-- Table: work_position
CREATE TABLE work_position (
    name varchar(90) NOT NULL,
    CONSTRAINT work_position_pk PRIMARY KEY (name)
);

-- foreign keys
-- Reference: city_region (table: city)
ALTER TABLE city ADD CONSTRAINT city_region FOREIGN KEY city_region (region_name)
    REFERENCES region (name);

-- Reference: consultation_doctor (table: consultation)
ALTER TABLE consultation ADD CONSTRAINT consultation_doctor FOREIGN KEY consultation_doctor (doctor_id)
    REFERENCES doctor (id);

-- Reference: consultation_patient (table: consultation)
ALTER TABLE consultation ADD CONSTRAINT consultation_patient FOREIGN KEY consultation_patient (patient_id)
    REFERENCES patient (id);

-- Reference: doctor_hospital (table: doctor)
ALTER TABLE doctor ADD CONSTRAINT doctor_hospital FOREIGN KEY doctor_hospital (hospital_id)
    REFERENCES hospital (id);

-- Reference: doctor_position_doctor (table: doctor_position)
ALTER TABLE doctor_position ADD CONSTRAINT doctor_position_doctor FOREIGN KEY doctor_position_doctor (doctor_id)
    REFERENCES doctor (id);

-- Reference: doctor_position_position (table: doctor_position)
ALTER TABLE doctor_position ADD CONSTRAINT doctor_position_position FOREIGN KEY doctor_position_position (position_name)
    REFERENCES work_position (name);

-- Reference: hospital_city (table: hospital)
ALTER TABLE hospital ADD CONSTRAINT hospital_city FOREIGN KEY hospital_city (city_name)
    REFERENCES city (name);

-- Reference: patient_data (table: patient)
ALTER TABLE patient ADD CONSTRAINT patient_data FOREIGN KEY patient_data (data_id)
    REFERENCES data (id);

-- Reference: patient_diagnosis_diagnosis (table: patient_diagnosis)
ALTER TABLE patient_diagnosis ADD CONSTRAINT patient_diagnosis_diagnosis FOREIGN KEY patient_diagnosis_diagnosis (diagnosis_name)
    REFERENCES diagnosis (name);

-- Reference: patient_diagnosis_patient (table: patient_diagnosis)
ALTER TABLE patient_diagnosis ADD CONSTRAINT patient_diagnosis_patient FOREIGN KEY patient_diagnosis_patient (patient_id)
    REFERENCES patient (id);

-- Reference: patient_hospital (table: patient)
ALTER TABLE patient ADD CONSTRAINT patient_hospital FOREIGN KEY patient_hospital (hospital_id)
    REFERENCES hospital (id);

-- Reference: patient_medicine_medicine (table: patient_medicine)
ALTER TABLE patient_medicine ADD CONSTRAINT patient_medicine_medicine FOREIGN KEY patient_medicine_medicine (medicine_name)
    REFERENCES medicine (name);

-- Reference: patient_medicine_patient (table: patient_medicine)
ALTER TABLE patient_medicine ADD CONSTRAINT patient_medicine_patient FOREIGN KEY patient_medicine_patient (patient_id)
    REFERENCES patient (id);