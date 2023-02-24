package com.nv.doctorapp.exception.doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvalidDoctorException extends Exception{

	String msg;

	@Override
	public String toString() {
		return "InvalidDoctorException [msg=" + msg + "]";
	}
	
	
}
