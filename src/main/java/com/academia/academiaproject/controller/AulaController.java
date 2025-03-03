package com.academia.academiaproject.controller;

import com.academia.academiaproject.controller.dto.request.AulaRequestDTO;
import com.academia.academiaproject.controller.dto.response.AulaResponseDTO;
import com.academia.academiaproject.service.AulaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/aulas")
@RequiredArgsConstructor
public class AulaController {
    private final AulaService aulaService;

    @GetMapping
    public ResponseEntity<List<AulaResponseDTO>> obtenerTodas() {
        return ResponseEntity.ok(aulaService.obtenerTodas());
    }

    @GetMapping("/sede/{sedeId}")
    public ResponseEntity<List<AulaResponseDTO>> obtenerPorSedeId(@PathVariable Long sedeId) {
        return ResponseEntity.ok(aulaService.obtenerPorSedeId(sedeId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AulaResponseDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(aulaService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<AulaResponseDTO> crear(@Valid @RequestBody AulaRequestDTO dto) {
        return ResponseEntity.ok(aulaService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AulaResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody AulaRequestDTO dto) {
        return ResponseEntity.ok(aulaService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        aulaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
