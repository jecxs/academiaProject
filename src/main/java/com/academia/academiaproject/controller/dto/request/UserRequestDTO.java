package com.academia.academiaproject.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(
        @NotBlank(message = "El username no debe estar vacío")
        @Size(min = 4, max = 30, message = "El username debe tener entre 4 y 30 caracteres")
        String username,

        @NotBlank(message = "La contraseña no debe estar vacía")
        @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
                message = "La contraseña debe contener al menos un número, una mayúscula, una minúscula y un carácter especial")
        String password,

        @NotBlank(message = "El rol no debe estar vacío")
        @Pattern(regexp = "^(ADMIN|USER|DOCENTE)$", message = "El rol debe ser ADMIN, USER o DOCENTE")
        String role,

        String profile
) {}
