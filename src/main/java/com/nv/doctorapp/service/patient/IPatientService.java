package com.nv.doctorapp.service.patient;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nv.doctorapp.entity.Patient;

@Service
public interface IPatientService {

	public Patient registerPatient(Patient patient) throws Exception;

	public Patient updatepatientDetailsById(int patientId);

	public Patient getPatientById(int patientId);

	public List<Patient> getAllPatients();

	public List<Patient> getPatientByCity(String patientCity);

	public List<Patient> getPatientByName(String patientName);

	public List<Patient> getPatientByDisease(String patientDisease);
	
	public List<Patient> getPatientByAge(int patientAge);
	
}