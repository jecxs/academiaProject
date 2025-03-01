package com.academia.academiaproject.controller.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AulaRequestDTO(
        @NotBlank(message = "El nombre no puede estar vacío")
        @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
        String nombre,


        @Min(value = 1, message = "El aforo debe ser al menos 1")
        String aforo,

        @NotNull(message = "Debe especificar la sede")
        Long sedeId
) {
}
