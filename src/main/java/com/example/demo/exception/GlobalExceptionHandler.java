package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(BoException.class)
	public ResponseEntity<ErrorDetails> handleBookNotFoundException (BoException ex) {
		ErrorDetails error = new ErrorDetails();
		error.setMessage(ex.getMessage());
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setDt(LocalDateTime.now());
		 
		ResponseEntity<ErrorDetails> res = new ResponseEntity<> (error,HttpStatus.NOT_FOUND);
		return res;
		
	}

}
