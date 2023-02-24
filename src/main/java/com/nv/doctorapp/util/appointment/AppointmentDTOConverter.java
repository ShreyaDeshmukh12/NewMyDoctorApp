package com.nv.doctorapp.util.appointment;

import org.springframework.stereotype.Component;

import com.nv.doctorapp.dto.appointment.AppointmentResponseDTO;
import com.nv.doctorapp.entity.Appointment;

@Component
public class AppointmentDTOConverter {
	
	public AppointmentResponseDTO convertTo(Appointment appointment) {
			// TODO Auto-generated constructor stub
		return new AppointmentResponseDTO(appointment.getAppointmentId(), appointment.getDate(), appointment.getStatus(), appointment.getRemark() );
		}

	
	}