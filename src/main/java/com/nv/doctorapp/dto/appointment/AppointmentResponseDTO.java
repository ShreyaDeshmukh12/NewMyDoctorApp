package com.nv.doctorapp.dto.appointment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResponseDTO {
	
	
	private int appointmentId;
	private String date;
	private String status;
	private String remark;
	

}