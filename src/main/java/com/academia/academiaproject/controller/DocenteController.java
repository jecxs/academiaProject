package com.academia.academiaproject.controller;

import com.academia.academiaproject.controller.dto.request.DocenteRequestDTO;
import com.academia.academiaproject.controller.dto.response.DocenteResponseDTO;
import com.academia.academiaproject.service.DocenteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/docentes")
@RequiredArgsConstructor
public class DocenteController {
    private final DocenteService docenteService;

    @GetMapping
    public ResponseEntity<List<DocenteResponseDTO>> obtenerTodos() {
        return ResponseEntity.ok(docenteService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocenteResponseDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(docenteService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<DocenteResponseDTO> crear(@Valid @RequestBody DocenteRequestDTO dto) {
        return ResponseEntity.ok(docenteService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocenteResponseDTO> actualizar(@PathVariable Long id, @RequestBody DocenteRequestDTO dto) {
        return ResponseEntity.ok(docenteService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        docenteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}