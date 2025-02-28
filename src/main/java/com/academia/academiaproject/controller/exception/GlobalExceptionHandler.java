package com.academia.academiaproject.controller.exception;

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

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<GenericErrorResponse> manejarRecursoNoEncontrado(ResourceNotFoundException ex) {
        GenericErrorResponse respuesta = new GenericErrorResponse("Recurso no encontrado", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GenericErrorResponse> validaciones(MethodArgumentNotValidException ex) {
       Map<String, String> errores = new HashMap<>();
       ex.getBindingResult().getFieldErrors().forEach(fieldError -> errores.put(fieldError.getField(), fieldError.getDefaultMessage()));
        GenericErrorResponse respuesta = new GenericErrorResponse("Existen errores en la peticion", errores);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
    }



}
