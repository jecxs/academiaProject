package com.academia.academiaproject.controller.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AdministrativoRequestDTO(
        @NotBlank(message = "El nombre no debe estar vacío")
        @Size(min = 2, max = 25, message = "El nombre debe tener entre 2 y 25 caracteres")
        String nombre,

        @NotBlank(message = "El apellido no debe estar vacío")
        String apellido,

        String telefono,

        @Email(message = "El correo debe ser válido")
        String email,

        @NotBlank(message = "El cargo no debe estar vacío")
        String cargo
) {


}
