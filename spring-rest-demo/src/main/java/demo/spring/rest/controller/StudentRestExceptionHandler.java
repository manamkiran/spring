package demo.spring.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {

		return getErrorResponse(HttpStatus.NOT_FOUND, ex);
	}

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {

		return getErrorResponse(HttpStatus.BAD_REQUEST, ex);

	}

	private ResponseEntity<StudentErrorResponse> getErrorResponse(HttpStatus httpStatus, Exception ex) {
		StudentErrorResponse response = new StudentErrorResponse();
		response.setStatus(httpStatus.value());
		response.setMessage("NANI!!!!" + ex.getMessage());
		response.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(response, httpStatus);
	}

}
