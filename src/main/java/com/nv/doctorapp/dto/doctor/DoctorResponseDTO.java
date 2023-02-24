package com.nv.doctorapp.dto.doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorResponseDTO {

	private int doctorId;
	private String doctorName;
	private String speciality;
	private double chargePerVisit;
	
}