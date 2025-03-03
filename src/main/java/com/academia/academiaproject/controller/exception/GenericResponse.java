package com.academia.academiaproject.controller.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class GenericResponse<T> {
    private String status;
    private String message;
    private T data;
    private String uuid;
    private LocalDateTime timestamp;

    public GenericResponse(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.uuid = UUID.randomUUID().toString();
        this.timestamp = LocalDateTime.now();
    }

    public static <T> GenericResponse<T> success(String message, T data) {
        return new GenericResponse<>("success", message, data);
    }

    public static <T> GenericResponse<T> success(T data) {
        return new GenericResponse<>("success", "Operación realizada con éxito", data);
    }
}