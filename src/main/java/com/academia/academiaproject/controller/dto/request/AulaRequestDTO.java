package com.academia.academiaproject.controller.dto.request;

import jakarta.validation.constraints.*;


public record AulaRequestDTO(
        @NotBlank(message = "El campo nombre no debe estar vacío")
        @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
        String nombre,

        @NotBlank(message = "El campo aforo no debe estar vacío")
        @Pattern(regexp = "^[0-9]+$", message = "El aforo debe ser un número")
        String aforo,

        @NotNull(message = "Debe especificar la sede")
        Long sedeId
) {}
