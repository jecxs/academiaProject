package com.academia.academiaproject.controller.exception;

import java.util.UUID;


public class GenericErrorResponse <T> {
    private String error;
    private T detalle;
    private String uuid;

    public GenericErrorResponse(String error, T detalle) {
        this.error = error;
        this.detalle = detalle;
        this.uuid = UUID.randomUUID().toString();
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getDetalle() {
        return detalle;
    }

    public void setDetalle(T detalle) {
        this.detalle = detalle;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}