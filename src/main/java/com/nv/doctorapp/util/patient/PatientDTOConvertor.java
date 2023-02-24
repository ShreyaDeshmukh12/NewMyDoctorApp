package com.nv.doctorapp.util.patient;

import org.springframework.stereotype.Component;

import com.nv.doctorapp.dto.patient.PatientResponseDTO;
import com.nv.doctorapp.entity.Patient;

@Component
public class PatientDTOConvertor {

	public PatientResponseDTO convertTo(Patient patient) {
		return new PatientResponseDTO(patient.getPatientId(), patient.getPatientName(),patient.getPatientCity(),patient.getPatientAge(),patient.getPatientGender(),patient.getPatientDisease(),patient.getPatientPhoneNumber(),patient.getPatientBloodGroup());
	}

}