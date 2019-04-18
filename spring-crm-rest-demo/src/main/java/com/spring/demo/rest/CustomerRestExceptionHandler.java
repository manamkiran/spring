package com.spring.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException ex) {
		return getErrorResponse(HttpStatus.NOT_FOUND, ex);
	}

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception ex) {

		return getErrorResponse(HttpStatus.BAD_REQUEST, ex);

	}

	private ResponseEntity<CustomerErrorResponse> getErrorResponse(HttpStatus httpStatus, Exception ex) {
		CustomerErrorResponse response = new CustomerErrorResponse();
		response.setStatus(httpStatus.value());
		response.setMessage(ex.getMessage());
		response.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(response, httpStatus);
	}

}
