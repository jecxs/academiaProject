package com.academia.academiaproject.controller;

import com.academia.academiaproject.controller.dto.request.AdministrativoRequestDTO;
import com.academia.academiaproject.controller.dto.response.AdministrativoResponseDTO;
import com.academia.academiaproject.service.AdministrativoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/administrativos")
@RequiredArgsConstructor
public class AdministrativoController {
    private final AdministrativoService administrativoService;

    @GetMapping
    public ResponseEntity<List<AdministrativoResponseDTO>> obtenerTodos() {
        return ResponseEntity.ok(administrativoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministrativoResponseDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(administrativoService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<AdministrativoResponseDTO> crear(@Valid @RequestBody AdministrativoRequestDTO dto) {
        return ResponseEntity.ok(administrativoService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdministrativoResponseDTO> actualizar(@PathVariable Long id, @RequestBody AdministrativoRequestDTO dto) {
        return ResponseEntity.ok(administrativoService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        administrativoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
