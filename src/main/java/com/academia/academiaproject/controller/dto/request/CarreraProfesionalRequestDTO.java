package com.academia.academiaproject.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CarreraProfesionalRequestDTO(
        @NotBlank(message = "El nombre no debe estar vacío")
        @Size(min = 2, max = 50, message = "El nombre debe tener 2 caracteres como mínimo y 50 como máximo")
        String nombre,

        @Size(max = 255, message = "La descripción no debe exceder los 255 caracteres")
        String descripcion
) {}
