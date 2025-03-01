package com.academia.academiaproject.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AlumnoRequestDTO(
        @NotBlank(message = "El nombre no debe estar vacío")
        @Size(min = 2, max = 25, message = "El nombre debe tener entre 2 y 25 caracteres")
        String nombre,

        @NotBlank(message = "El apellido no debe estar vacío")
        @Size(min = 2, max = 25, message = "El apellido debe tener entre 2 y 25 caracteres")
        String apellido,

        @Pattern(regexp = "^\\+?\\d{1,3}?[-.\\s]?\\(?\\d{1,4}\\)?[-.\\s]?\\d{3,4}[-.\\s]?\\d{3,4}$",
                message = "El teléfono debe tener un formato válido")
        String telefono,

        @Pattern(regexp = "^\\+?\\d{1,3}?[-.\\s]?\\(?\\d{1,4}\\)?[-.\\s]?\\d{3,4}[-.\\s]?\\d{3,4}$",
                message = "El teléfono secundario debe tener un formato válido")
        String telefonoSecundario,

        Long carreraId
) {
}
