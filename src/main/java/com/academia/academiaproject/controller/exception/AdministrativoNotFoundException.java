package com.academia.academiaproject.controller.exception;

public class AdministrativoNotFoundException extends RuntimeException{
    public AdministrativoNotFoundException(){
        super("No se ha encontrado el administrativo: ");
    }

}
