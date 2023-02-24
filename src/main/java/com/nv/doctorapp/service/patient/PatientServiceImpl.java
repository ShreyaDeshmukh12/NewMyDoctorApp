package com.nv.doctorapp.service.patient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nv.doctorapp.entity.Patient;
import com.nv.doctorapp.exception.patient.InvalidPatientException;
import com.nv.doctorapp.repository.patient.IPatientRepository;

@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private IPatientRepository patientRepository;

	@Override
	public Patient registerPatient(Patient patient) throws Exception {

		if (patient.getPatientName().equals("")) {
			throw new InvalidPatientException("Invalid Patient Name");
		}

		if (patient.getPatientCity().equals("")) {
			throw new InvalidPatientException("Invalid City");
		}
		
		if (patient.getPatientPhoneNumber().length() != 10)
			throw new InvalidPatientException("Invalid Phone Number Length");
		
		if(patient.getPatientPhoneNumber().length() == 10) {
			for(int i =0; i<patient.getPatientPhoneNumber().length();i++) {
				if(Character.isDigit(patient.getPatientPhoneNumber().charAt(i))) {
					continue;
				}else {
					throw new InvalidPatientException("Invalid Phone Number");
				}
			}
		}
		
			return patientRepository.save(patient);

	}

	@Override
	public Patient updatepatientDetailsById(int patientId) {

		Patient updatedPatient = patientRepository.getReferenceById(patientId);
		patientRepository.save(updatedPatient);
		return updatedPatient;
	}

	@Override
	public List<Patient> getAllPatients() {

		return patientRepository.findAll();
	}

	@Override
	public Patient getPatientById(int patientId) {

		return patientRepository.getReferenceById(patientId);
	}

	@Override
	public List<Patient> getPatientByCity(String patientCity) {

		List<Patient> allPatients = patientRepository.findAll();
		List<Patient> requiredPatients = new ArrayList<>();
		for (Patient obj : allPatients) {
			if (obj.getPatientCity().equalsIgnoreCase(patientCity)) {
				requiredPatients.add(obj);
			}
		}
		return requiredPatients;

	}

	@Override
	public List<Patient> getPatientByName(String patientName) {

		List<Patient> allPatients = patientRepository.findAll();
		List<Patient> requiredPatients = new ArrayList<>();
		for (Patient obj : allPatients) {
			if (obj.getPatientName().equalsIgnoreCase(patientName)) {
				requiredPatients.add(obj);
			}
		}
		return requiredPatients;

	}

	@Override
	public List<Patient> getPatientByAge(int patientAge) {

		List<Patient> allPatients = patientRepository.findAll();
		List<Patient> requiredPatients = new ArrayList<>();
		for (Patient obj : allPatients) {
			if (obj.getPatientAge() == (patientAge)) {
				requiredPatients.add(obj);
			}
		}
		return requiredPatients;
	}
	

	@Override
	public List<Patient> getPatientByDisease(String patientDisease) {

		List<Patient> allPatients = patientRepository.findAll();
		List<Patient> requiredPatients = new ArrayList<>();
		for (Patient obj : allPatients) {
			if (obj.getPatientDisease().equalsIgnoreCase(patientDisease)) {
				requiredPatients.add(obj);
			}
		}
		return requiredPatients;
	}
}