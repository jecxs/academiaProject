package com.academia.academiaproject.controller;

import com.academia.academiaproject.controller.dto.request.AlumnoRequestDTO;
import com.academia.academiaproject.controller.dto.response.AlumnoResponseDTO;
import com.academia.academiaproject.service.AlumnoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alumnos")
@RequiredArgsConstructor
public class AlumnoController {
    private final AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<List<AlumnoResponseDTO>> obtenerTodos() {
        return ResponseEntity.ok(alumnoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoResponseDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(alumnoService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<AlumnoResponseDTO> crear(@Valid @RequestBody AlumnoRequestDTO request) {
        return ResponseEntity.ok(alumnoService.crear(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody AlumnoRequestDTO request) {
        return ResponseEntity.ok(alumnoService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        alumnoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}