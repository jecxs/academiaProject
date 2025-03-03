package com.academia.academiaproject.controller;

import com.academia.academiaproject.controller.dto.request.SedeRequestDTO;
import com.academia.academiaproject.controller.dto.response.SedeResponseDTO;
import com.academia.academiaproject.service.SedeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sedes")
@RequiredArgsConstructor
public class SedeController {
    private final SedeService sedeService;

    @GetMapping
    public ResponseEntity<List<SedeResponseDTO>> obtenerTodas() {
        return ResponseEntity.ok(sedeService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SedeResponseDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(sedeService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<SedeResponseDTO> crear(@Valid @RequestBody SedeRequestDTO dto) {
        return ResponseEntity.ok(sedeService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SedeResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody SedeRequestDTO dto) {
        return ResponseEntity.ok(sedeService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        sedeService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
