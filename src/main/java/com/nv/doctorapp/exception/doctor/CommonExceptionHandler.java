package com.nv.doctorapp.exception.doctor;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nv.doctorapp.dto.doctor.ExceptionDTOResponse;

@ControllerAdvice
public class CommonExceptionHandler {
	
	@ExceptionHandler
	
	public ResponseEntity<ExceptionDTOResponse> invalidName(InvalidDoctorException e)
	{
		ExceptionDTOResponse dto = new ExceptionDTOResponse();
		dto.setErrorMsg(e.toString());
		dto.setDateTime(LocalDateTime.now()+"");
		return new ResponseEntity<ExceptionDTOResponse>(dto,HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<ExceptionDTOResponse> invalidEmail(InvalidDoctorException e)
	{
		ExceptionDTOResponse dto = new ExceptionDTOResponse();
		dto.setErrorMsg(e.toString());
		dto.setDateTime(LocalDateTime.now()+"");
		return new ResponseEntity<ExceptionDTOResponse>(dto,HttpStatus.BAD_REQUEST);
	}

}