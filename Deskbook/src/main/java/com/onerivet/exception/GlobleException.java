package com.onerivet.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onerivet.model.dtos.ApiResponse;

@RestControllerAdvice
public class GlobleException extends RuntimeException {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ApiResponse resourceNotFoundHandler(ResourceNotFoundException ex) {
		String message = ex.getMessage();
		LocalDateTime now = LocalDateTime.now();
		ApiResponse apiResponse = new ApiResponse(message, now);
		
		return apiResponse;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> method(MethodArgumentNotValidException mex){
		Map<String, String> response = new HashMap<String, String>();
		mex.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			response.put(fieldName, message);
		});
		return response;	
	}
}

