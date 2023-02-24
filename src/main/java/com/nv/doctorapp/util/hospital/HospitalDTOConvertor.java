package com.nv.doctorapp.util.hospital;

import org.springframework.stereotype.Component;

import com.nv.doctorapp.dto.hospital.HospitalDTO;
import com.nv.doctorapp.entity.Hospital;

@Component

public class HospitalDTOConvertor {

	public HospitalDTO convertTo(Hospital hospital) {
		
		return new HospitalDTO(hospital.getHospitalId(), hospital.getHospitalName(), hospital.getCity(), hospital.getState(), hospital.getAddress(), hospital.getHospitalRating());
		
	}

}