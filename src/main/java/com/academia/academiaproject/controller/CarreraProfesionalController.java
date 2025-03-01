package com.academia.academiaproject.controller;

import com.academia.academiaproject.controller.dto.response.CarreraProfesionalResponseDTO;
import com.academia.academiaproject.service.CarreraProfesionalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carreras")
@RequiredArgsConstructor
public class CarreraProfesionalController {
    private final CarreraProfesionalService carreraService;

    @GetMapping
    public ResponseEntity<List<CarreraProfesionalResponseDTO>> obtenerTodas() {
        return ResponseEntity.ok(carreraService.obtenerTodas());
    }
}
