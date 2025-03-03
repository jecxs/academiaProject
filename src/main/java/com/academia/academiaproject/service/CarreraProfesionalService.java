package com.academia.academiaproject.service;

import com.academia.academiaproject.controller.dto.request.CarreraProfesionalRequestDTO;
import com.academia.academiaproject.controller.dto.response.CarreraProfesionalResponseDTO;
import com.academia.academiaproject.controller.dto.response.CarreraProfesionalSimpleResponseDTO;
import com.academia.academiaproject.controller.exception.ResourceConflictException;
import com.academia.academiaproject.controller.exception.ResourceNotFoundException;
import com.academia.academiaproject.repository.CarreraProfesionalRepository;
import com.academia.academiaproject.repository.model.CarreraProfesional;
import com.academia.academiaproject.service.mapper.CarreraProfesionalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarreraProfesionalService {
    private final CarreraProfesionalRepository carreraProfesionalRepository;
    private final CarreraProfesionalMapper carreraProfesionalMapper;

    public List<CarreraProfesionalSimpleResponseDTO> obtenerTodas() {
        return carreraProfesionalRepository.findAll().stream()
                .map(carreraProfesionalMapper::toSimpleDTO)
                .collect(Collectors.toList());
    }

    public CarreraProfesionalResponseDTO obtenerPorId(Long id) {
        CarreraProfesional carrera = carreraProfesionalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carrera Profesional con ID " + id + " no encontrada."));
        return carreraProfesionalMapper.toDTO(carrera);
    }

    @Transactional
    public CarreraProfesionalResponseDTO crear(CarreraProfesionalRequestDTO dto) {
        // Verificar si ya existe una carrera con el mismo nombre
        if (carreraProfesionalRepository.existsByNombre(dto.nombre())) {
            throw new ResourceConflictException("Ya existe una Carrera Profesional con el nombre: " + dto.nombre());
        }

        CarreraProfesional carrera = carreraProfesionalMapper.toEntity(dto);
        carrera = carreraProfesionalRepository.save(carrera);

        return carreraProfesionalMapper.toDTO(carrera);
    }

    @Transactional
    public CarreraProfesionalResponseDTO actualizar(Long id, CarreraProfesionalRequestDTO dto) {
        CarreraProfesional carrera = carreraProfesionalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carrera Profesional con ID " + id + " no encontrada."));

        // Verificar si ya existe otra carrera con el mismo nombre
        carreraProfesionalRepository.findByNombre(dto.nombre())
                .ifPresent(existingCarrera -> {
                    if (!existingCarrera.getId().equals(id)) {
                        throw new ResourceConflictException("Ya existe otra Carrera Profesional con el nombre: " + dto.nombre());
                    }
                });

        carrera.setNombre(dto.nombre());
        carrera.setDescripcion(dto.descripcion());

        return carreraProfesionalMapper.toDTO(carreraProfesionalRepository.save(carrera));
    }

    @Transactional
    public void eliminar(Long id) {
        CarreraProfesional carrera = carreraProfesionalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carrera Profesional con ID " + id + " no encontrada."));

        if (carrera.getAlumnos() != null && !carrera.getAlumnos().isEmpty()) {
            throw new ResourceConflictException("No se puede eliminar la Carrera Profesional porque tiene alumnos asociados");
        }

        carreraProfesionalRepository.deleteById(id);
    }
}
