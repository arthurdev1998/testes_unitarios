package com.arthur.testes.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.arthur.testes.exceptions.ExceptionResponse;
import com.arthur.testes.exceptions.ResourcesNotFoundException;



@ControllerAdvice
@RestController
public class CustomizeExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ResourcesNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundException(Exception ex, WebRequest request){
		ExceptionResponse  excepcionResponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(excepcionResponse, HttpStatus.NOT_FOUND);
	}
	

}
