package com.academia.academiaproject.controller.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CargoException.class)
    public ResponseEntity<GenericErrorResponse> exception(Exception e, HttpServletRequest request) {
        GenericErrorResponse response = new GenericErrorResponse("Error",e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(AdministrativoNotFoundException.class)
    public ResponseEntity<GenericErrorResponse> exception2(Exception e, HttpServletRequest request) {
        GenericErrorResponse response = new GenericErrorResponse("Error",e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }



}
