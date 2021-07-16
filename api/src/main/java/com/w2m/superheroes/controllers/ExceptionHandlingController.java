package com.w2m.superheroes.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.w2m.superheroes.constants.Constants;
import com.w2m.superheroes.dto.ResponseDTO;
import com.w2m.superheroes.exceptions.InvalidParameterException;

@ControllerAdvice
public class ExceptionHandlingController {

	@ExceptionHandler(MissingRequestHeaderException.class)
	public <T> ResponseEntity<ResponseDTO<T>> handleTokenMissing(MissingRequestHeaderException ex) {
		Boolean success = Boolean.FALSE;
		String message = Constants.ResponseInfo.FORBIDDEN;
		ResponseDTO<T> error = new ResponseDTO<T>(success, message, null);
		return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(InvalidParameterException.class)
	public <T> ResponseEntity<ResponseDTO<T>> handleMethodArgumentNotValidException(InvalidParameterException ex) {
		Boolean success = Boolean.FALSE;
		String message = Constants.ResponseInfo.BAD_REQUEST;
		ResponseDTO<T> error = new ResponseDTO<T>(success, message + ": " + ex.getMessage(), null);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public <T> ResponseEntity<ResponseDTO<T>> handleMethodArgumentNotValidException(
			MissingServletRequestParameterException ex) {
		Boolean success = Boolean.FALSE;
		String message = Constants.ResponseInfo.BAD_REQUEST;
		ResponseDTO<T> error = new ResponseDTO<T>(success, message, null);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public <T> ResponseEntity<ResponseDTO<T>> handleUnexpectedException(Exception ex) {
		Boolean success = Boolean.FALSE;
		String message = ex.getMessage()!=null?ex.getMessage():Constants.ResponseInfo.BAD_REQUEST;
		ResponseDTO<T> error = new ResponseDTO<T>(success, message, null);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
