package com.springboot.zinkworks.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@ResponseBody
public class ATMExceptionHandler {

	  @ExceptionHandler(value = {ResourceNotFoundException.class})
	  public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
				 ErrorMessage message = new ErrorMessage(
	    			        HttpStatus.NOT_FOUND.value(),
	    			        new Date(),
	    			        ex.getMessage(),
	    			        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	  }
	
	@ExceptionHandler(value = {AccountException.class})
	  public ResponseEntity<ErrorMessage> accountException(AccountException ex, WebRequest request) {
				 ErrorMessage message = new ErrorMessage(
	    			        HttpStatus.BAD_REQUEST.value(),
	    			        new Date(),
	    			        ex.getMessage(),
	    			        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
	  }
	
	@ExceptionHandler(value = {ATMException.class})
	  public ResponseEntity<ErrorMessage> atmException(AccountException ex, WebRequest request) {
				 ErrorMessage message = new ErrorMessage(
	    			        HttpStatus.OK.value(),
	    			        new Date(),
	    			        ex.getMessage(),
	    			        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorMessage>(message,HttpStatus.OK);
	  }
	
	@ExceptionHandler(Exception.class)
	  public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	        HttpStatus.INTERNAL_SERVER_ERROR.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	
	
}
