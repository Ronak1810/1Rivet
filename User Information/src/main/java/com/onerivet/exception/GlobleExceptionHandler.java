package com.onerivet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.onerivet.model.response.GenericResponse;


public class GlobleExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<GenericResponse<?>> resourseNotFoundException(ResourceNotFoundException exception) {
		GenericResponse<?> genericResponse = new GenericResponse<>(null, exception.getMessage());
		return new ResponseEntity<>(genericResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<GenericResponse<?>> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
		GenericResponse<?> genericResponse = new GenericResponse<>(null, exception.getMessage());
		return new ResponseEntity<>(genericResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<GenericResponse<?>> exceptionHandler(Exception exception) {
		GenericResponse<?> genericResponse = new GenericResponse<>(null, exception.getMessage());
		return new ResponseEntity<>(genericResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
