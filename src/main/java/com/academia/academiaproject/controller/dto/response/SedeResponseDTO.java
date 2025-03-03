package com.academia.academiaproject.controller.dto.response;

import java.util.List;

public record SedeResponseDTO(
        Long id,
        String nombre,
        String direccion,
        List<AulaSimpleDTO> aulas
) {}
