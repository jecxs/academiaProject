package com.academia.academiaproject.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AlumnoRequestDTO(
        @NotBlank(message = "El nombre no debe estar vacío")
        @Size(min = 2, max = 25, message = "El nombre debe tener 2 caracteres como mínimo y 25 como máximo")
        String nombre,

        @NotBlank(message = "El apellido no debe estar vacío")
        @Size(min = 2, max = 25, message = "El apellido debe tener 2 caracteres como mínimo y 25 como máximo")
        String apellido,

        @Pattern(regexp = "^\\+?\\d{1,3}?[-.\\s]?\\(?\\d{1,4}\\)?[-.\\s]?\\d{3,4}[-.\\s]?\\d{3,4}$",
                message = "El teléfono debe tener un formato preestablecido, ejemplos: +51 999-888-777/ " +
                        "+1 (800) 123-4567/ 987654321 / 01-2345-6789")
        String telefono,

        String telefonoSecundario,

        @NotNull(message = "La carrera profesional es requerida")
        Long carreraId
) {}

