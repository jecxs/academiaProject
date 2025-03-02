package com.academia.academiaproject.controller.dto.response;

public record UserResponseDTO(
        Long id,
        String username,
        String role,
        String profile
) {}
