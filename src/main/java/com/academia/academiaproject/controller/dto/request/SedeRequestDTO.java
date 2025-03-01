package com.academia.academiaproject.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SedeRequestDTO(
        @NotBlank(message = "El nombre no puede estar vacío")
        @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
        String nombre,

        @NotBlank(message = "La dirección no puede estar vacía")
        @Size(min = 10, max = 200, message = "La dirección debe tener entre 5 y 200 caracteres")
        String direccion
) {
}
