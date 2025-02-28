package com.academia.academiaproject.controller.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }
}
