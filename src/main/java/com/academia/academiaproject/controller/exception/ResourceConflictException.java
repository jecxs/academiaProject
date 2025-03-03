package com.academia.academiaproject.controller.exception;

public class ResourceConflictException extends RuntimeException {
    public ResourceConflictException(String mensaje) {
        super(mensaje);
    }
}
