package com.academia.academiaproject.controller.exception;

import com.academia.academiaproject.controller.dto.response.AdministrativoResponseDTO;
import com.academia.academiaproject.controller.dto.response.UserResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class GenericResponse<T> {
    private String uuid;
    private String status;
    private T data;
    private String message;

    public GenericResponse(String status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
        this.uuid= UUID.randomUUID().toString();
    }

    public static GenericResponse<UserResponseDTO> success(String usuarioCreadoCorrectamente, UserResponseDTO nuevoUsuario) {
        return new GenericResponse<UserResponseDTO>(usuarioCreadoCorrectamente,nuevoUsuario,null);

    }
}