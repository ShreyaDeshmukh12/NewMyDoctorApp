package com.nv.doctorapp.exception.feedback;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nv.doctorapp.dto.feedback.ExceptionDTOResponse;

@ControllerAdvice
public class FeedbackCommonExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ExceptionDTOResponse> invalidName(InvalidDataException e) {
		ExceptionDTOResponse dto = new ExceptionDTOResponse();
		dto.setErrorMsg(e.toString());
		dto.setDateTime(LocalDateTime.now() + "");
		return new ResponseEntity<ExceptionDTOResponse>(dto, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<ExceptionDTOResponse> invalidId(NullPointerException e) {
		ExceptionDTOResponse dto = new ExceptionDTOResponse();
		dto.setErrorMsg(e.toString());
		dto.setDateTime(LocalDateTime.now() + "");
		return new ResponseEntity<ExceptionDTOResponse>(dto, HttpStatus.BAD_REQUEST);
	}

}
