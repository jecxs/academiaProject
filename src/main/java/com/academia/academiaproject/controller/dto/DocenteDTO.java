package com.academia.academiaproject.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DocenteDTO(
        Long id,

        @NotBlank(message = "El nombre no puede estar vacío")
        String nombre,

        @NotBlank(message = "El apellido no puede estar vacío")
        String apellido,

        String telefono,

        @NotBlank(message = "La especialidad no puede estar vacía")
        String especialidad,

        @Email(message = "Correo no válido")
        @NotBlank(message = "El correo no puede estar vacío")
        String correo,

        @Size(max = 500, message = "La descripción no puede exceder 500 caracteres")
        String descripcion
) {}