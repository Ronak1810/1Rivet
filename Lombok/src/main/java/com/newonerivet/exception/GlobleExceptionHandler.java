package com.newonerivet.exception;

import java.time.LocalDateTime;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.newonerivet.payload.ApiResponse;

@RestControllerAdvice
public class GlobleExceptionHandler extends RuntimeException{
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ApiResponse resourceNotFoundHandler(ResourceNotFoundException ex) {
		
		String message = ex.getMessage();
		LocalDateTime now = LocalDateTime.now();
		ApiResponse apiResponse = new ApiResponse(message, now);
		
		return apiResponse;
		
		
		
	}
}
