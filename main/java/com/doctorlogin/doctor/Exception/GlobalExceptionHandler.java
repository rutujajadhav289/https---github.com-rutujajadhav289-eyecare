package com.doctorlogin.doctor.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	//handle specific exceptions
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResorceNotFoundException
			(ResourceNotFoundException exception, WebRequest request){
				
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	//handle API exceptions
		@ExceptionHandler(APIException.class)
		public ResponseEntity<?> handleAPIException
				(APIException exception, WebRequest request){
					
			ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
			return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
		}
		
	//handle global exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException
			(Exception exception, WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
