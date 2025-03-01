package com.academia.academiaproject.controller.dto.response;

public record AulaResponseDTO(
        Long id,
        String nombre,
        String aforo,
        String sedeNombre
) {
}
