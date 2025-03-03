package com.academia.academiaproject.controller.dto.response;

public record AlumnoResponseDTO(
        Long id,
        String nombre,
        String apellido,
        String telefono,
        String telefonoSecundario,
        CarreraSimpleDTO carrera
) {}

