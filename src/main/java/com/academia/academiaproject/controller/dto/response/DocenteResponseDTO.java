package com.academia.academiaproject.controller.dto.response;

public record DocenteResponseDTO(
        Long id,
        String nombre,
        String apellido,
        String telefono,
        String especialidad,
        String correo,
        String descripcion
) {}
