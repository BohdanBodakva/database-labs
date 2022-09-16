use labs_db;

-- 1 (patients with diagnosis pneumonia)
select surname, name, registration_date from patient as p join patient_diagnosis as p_d on p.id=p_d.patient_id 
where p_d.diagnosis_name='pneumonia'; 

-- 2 (doctors from hospitals in Rivne region)
select d.surname, d.name from doctor as d 
join hospital as h on d.hospital_id=h.id
join city on city.name=h.city_name
join region as r on city.region_name=r.name
where r.name='Rivne region';

-- 3 (positions of doctors, who consulted patient #1)
select w_p.name from patient as p
join consultation as c on c.patient_id=p.id
join doctor as d on d.id=c.doctor_id
join doctor_position as d_p on d_p.doctor_id=d.id
join work_position as w_p on w_p.name=d_p.position_name
where p.id=1;

-- 4 (count how many patients were registered each day in ascending order)
select registration_date, count(*) from patient group by registration_date ;

-- 5 (count patients from each hospital)
select h.name, count(*) from patient as p join hospital as h on h.id=p.hospital_id
group by h.name;

-- 6 (all patients and their diagnosis)
select p.surname, p.name, d.name from patient as p join patient_diagnosis as p_d on p_d.patient_id=p.id
join diagnosis as d on d.name=p_d.diagnosis_name;

-- 7 (count patients with each diagnosis)
select d.name, count(*) from patient as p join patient_diagnosis as p_d on p_d.patient_id=p.id
join diagnosis as d on d.name=p_d.diagnosis_name
group by d.name;

-- 8 (how much consultaions have every doctor)
select d.surname, d.name, count(*) as consultations from doctor as d join consultation as c on d.id=c.doctor_id
group by d.id
order by consultations desc;

-- 9 (patients with temperature >= 39 degrees by Celsius)
select p.surname, p.name, d.temperature_in_celsius as °C from patient as p join data as d on p.data_id=d.id
where d.temperature_in_celsius >= 39;

-- 10 (medicines that are described to diagnosis: pneumonia (in ascending order))
select p_d.diagnosis_name as diagnosis, p_m.medicine_name as medicine from patient_medicine as p_m join patient as p on p.id=p_m.patient_id
join patient_diagnosis as p_d on p.id=p_d.patient_id
order by diagnosis;
   
