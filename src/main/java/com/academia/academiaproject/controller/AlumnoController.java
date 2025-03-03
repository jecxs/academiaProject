package com.academia.academiaproject.controller;

import com.academia.academiaproject.controller.dto.request.AlumnoRequestDTO;
import com.academia.academiaproject.controller.dto.response.AlumnoResponseDTO;
import com.academia.academiaproject.controller.exception.GenericResponse;
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
    public ResponseEntity<GenericResponse<List<AlumnoResponseDTO>>> obtenerTodos() {
        List<AlumnoResponseDTO> alumnos = alumnoService.obtenerTodos();
        return ResponseEntity.ok(new GenericResponse<>("success", alumnos, "Alumnos obtenidos correctamente"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<AlumnoResponseDTO>> obtenerPorId(@PathVariable Long id) {
        AlumnoResponseDTO alumno = alumnoService.obtenerPorId(id);
        return ResponseEntity.ok(new GenericResponse<>("success", alumno, "Alumno obtenido correctamente"));
    }

    @GetMapping("/carrera/{carreraId}")
    public ResponseEntity<GenericResponse<List<AlumnoResponseDTO>>> obtenerPorCarrera(@PathVariable Long carreraId) {
        List<AlumnoResponseDTO> alumnos = alumnoService.obtenerPorCarrera(carreraId);
        return ResponseEntity.ok(new GenericResponse<>("success", alumnos, "Alumnos obtenidos correctamente"));
    }

    @PostMapping
    public ResponseEntity<GenericResponse<AlumnoResponseDTO>> crear(@Valid @RequestBody AlumnoRequestDTO dto) {
        AlumnoResponseDTO nuevoAlumno = alumnoService.crear(dto);
        return ResponseEntity.ok(new GenericResponse<>("success", nuevoAlumno, "Alumno creado correctamente"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<AlumnoResponseDTO>> actualizar(@PathVariable Long id, @Valid @RequestBody AlumnoRequestDTO dto) {
        AlumnoResponseDTO alumnoActualizado = alumnoService.actualizar(id, dto);
        return ResponseEntity.ok(new GenericResponse<>("success", alumnoActualizado, "Alumno actualizado correctamente"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse<Void>> eliminar(@PathVariable Long id) {
        alumnoService.eliminar(id);
        return ResponseEntity.ok(new GenericResponse<>("success", null, "Alumno eliminado correctamente"));
    }
}
