package com.academia.academiaproject.controller;

import com.academia.academiaproject.controller.dto.request.CarreraProfesionalRequestDTO;
import com.academia.academiaproject.controller.dto.response.CarreraProfesionalResponseDTO;
import com.academia.academiaproject.controller.dto.response.CarreraProfesionalSimpleResponseDTO;
import com.academia.academiaproject.controller.exception.GenericResponse;
import com.academia.academiaproject.service.CarreraProfesionalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carreras")
@RequiredArgsConstructor
public class CarreraProfesionalController {
    private final CarreraProfesionalService carreraProfesionalService;

    @GetMapping
    public ResponseEntity<GenericResponse<List<CarreraProfesionalSimpleResponseDTO>>> obtenerTodas() {
        List<CarreraProfesionalSimpleResponseDTO> carreras = carreraProfesionalService.obtenerTodas();
        return ResponseEntity.ok(new GenericResponse<>("success", carreras, "Carreras Profesionales obtenidas correctamente"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<CarreraProfesionalResponseDTO>> obtenerPorId(@PathVariable Long id) {
        CarreraProfesionalResponseDTO carrera = carreraProfesionalService.obtenerPorId(id);
        return ResponseEntity.ok(new GenericResponse<>("success", carrera, "Carrera Profesional obtenida correctamente"));
    }

    @PostMapping
    public ResponseEntity<GenericResponse<CarreraProfesionalResponseDTO>> crear(@Valid @RequestBody CarreraProfesionalRequestDTO dto) {
        CarreraProfesionalResponseDTO nuevaCarrera = carreraProfesionalService.crear(dto);
        return ResponseEntity.ok(new GenericResponse<>("success", nuevaCarrera, "Carrera Profesional creada correctamente"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<CarreraProfesionalResponseDTO>> actualizar(@PathVariable Long id, @Valid @RequestBody CarreraProfesionalRequestDTO dto) {
        CarreraProfesionalResponseDTO carreraActualizada = carreraProfesionalService.actualizar(id, dto);
        return ResponseEntity.ok(new GenericResponse<>("success", carreraActualizada, "Carrera Profesional actualizada correctamente"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse<Void>> eliminar(@PathVariable Long id) {
        carreraProfesionalService.eliminar(id);
        return ResponseEntity.ok(new GenericResponse<>("success", null, "Carrera Profesional eliminada correctamente"));
    }
}

