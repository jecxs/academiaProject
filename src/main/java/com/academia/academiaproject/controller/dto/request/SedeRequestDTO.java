package com.academia.academiaproject.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SedeRequestDTO(
        @NotBlank(message = "El campo nombre no debe estar vacío")
        @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
        String nombre,

        @NotBlank(message = "El campo dirección no debe estar vacío")
        @Size(min = 5, max = 200, message = "La dirección debe tener entre 5 y 200 caracteres")
        String direccion
) {}
