package com.learnjava.springboot.restservice.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.learnjava.springboot.restservice.exception.AppException;
import com.learnjava.springboot.restservice.exception.ErrorResponse;

@ControllerAdvice
public class AppAdvice {

	@ExceptionHandler(AppException.class)
	public ResponseEntity<ErrorResponse> appExceptionHandler(AppException appExp) {
		
		System.out.println("called controlleradvice");
		
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode("5050");
		errorResponse.setHhtpStatus(HttpStatus.NOT_FOUND.toString());
		errorResponse.setErrorMsg(appExp.getMessage());
		
		ResponseEntity<ErrorResponse> responseEntity = new ResponseEntity<>(errorResponse, HttpStatus.ACCEPTED);
			return responseEntity;
	}

}
