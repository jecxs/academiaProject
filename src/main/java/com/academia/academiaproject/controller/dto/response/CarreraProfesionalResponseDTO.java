package com.academia.academiaproject.controller.dto.response;

import java.util.List;

public record CarreraProfesionalResponseDTO(
        Long id,
        String nombre,
        String descripcion,
        List<AlumnoSimpleDTO> alumnos
) {}
