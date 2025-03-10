package com.academia.academiaproject.service;

import com.academia.academiaproject.controller.dto.request.AlumnoRequestDTO;
import com.academia.academiaproject.controller.dto.response.AlumnoResponseDTO;
import com.academia.academiaproject.controller.exception.ResourceNotFoundException;
import com.academia.academiaproject.repository.AlumnoRepository;
import com.academia.academiaproject.repository.CarreraProfesionalRepository;
import com.academia.academiaproject.repository.model.Alumno;
import com.academia.academiaproject.repository.model.CarreraProfesional;
import com.academia.academiaproject.service.mapper.AlumnoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlumnoService {
    private final AlumnoRepository alumnoRepository;
    private final CarreraProfesionalRepository carreraProfesionalRepository;
    private final AlumnoMapper alumnoMapper;

    public List<AlumnoResponseDTO> obtenerTodos() {
        return alumnoRepository.findAll().stream()
                .map(alumnoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AlumnoResponseDTO obtenerPorId(Long id) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alumno con ID " + id + " no encontrado."));
        return alumnoMapper.toDTO(alumno);
    }

    public List<AlumnoResponseDTO> obtenerPorCarrera(Long carreraId) {
        if (!carreraProfesionalRepository.existsById(carreraId)) {
            throw new ResourceNotFoundException("Carrera Profesional con ID " + carreraId + " no encontrada.");
        }
        return alumnoRepository.findByCarreraId(carreraId).stream()
                .map(alumnoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public AlumnoResponseDTO crear(AlumnoRequestDTO dto) {
        CarreraProfesional carrera = carreraProfesionalRepository.findById(dto.carreraId())
                .orElseThrow(() -> new ResourceNotFoundException("Carrera Profesional con ID " + dto.carreraId() + " no encontrada."));

        Alumno alumno = alumnoMapper.toEntity(dto);
        alumno.setCarrera(carrera);

        return alumnoMapper.toDTO(alumnoRepository.save(alumno));
    }

    @Transactional
    public AlumnoResponseDTO actualizar(Long id, AlumnoRequestDTO dto) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Alumno con ID " + id + " no encontrado."));

        CarreraProfesional carrera = carreraProfesionalRepository.findById(dto.carreraId())
                .orElseThrow(() -> new ResourceNotFoundException("Carrera Profesional con ID " + dto.carreraId() + " no encontrada."));

        alumno.setNombre(dto.nombre());
        alumno.setApellido(dto.apellido());
        alumno.setTelefono(dto.telefono());
        alumno.setTelefonoSecundario(dto.telefonoSecundario());
        alumno.setCarrera(carrera);

        return alumnoMapper.toDTO(alumnoRepository.save(alumno));
    }

    @Transactional
    public void eliminar(Long id) {
        if (!alumnoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Alumno con ID " + id + " no encontrado.");
        }
        alumnoRepository.deleteById(id);
    }
}