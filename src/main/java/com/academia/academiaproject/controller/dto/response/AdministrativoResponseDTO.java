package com.academia.academiaproject.controller.dto.response;

public record AdministrativoResponseDTO(
        Long id,
        String nombre,
        String apellido,
        String telefono,
        String email,
        String cargo
) {
}
