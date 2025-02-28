package com.academia.academiaproject.service;



import com.academia.academiaproject.controller.dto.request.DocenteRequestDTO;
import com.academia.academiaproject.controller.dto.response.DocenteResponseDTO;
import com.academia.academiaproject.controller.exception.ResourceNotFoundException;
import com.academia.academiaproject.repository.DocenteRepository;
import com.academia.academiaproject.repository.model.Docente;
import com.academia.academiaproject.service.mapper.DocenteMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocenteService {
    private final DocenteRepository docenteRepository;
    private final DocenteMapper docenteMapper;

    public List<DocenteResponseDTO> obtenerTodos() {
        return docenteRepository.findAll().stream()
                .map(docenteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public DocenteResponseDTO obtenerPorId(Long id) {
        Docente docente = docenteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Docente con ID " + id + " no encontrado."));
        return docenteMapper.toDTO(docente);
    }

    @Transactional
    public DocenteResponseDTO crear(DocenteRequestDTO dto) {
        Docente docente = docenteMapper.toEntity(dto);

        return docenteMapper.toDTO(docenteRepository.save(docente));

    }

    @Transactional
    public DocenteResponseDTO actualizar(Long id, DocenteRequestDTO dto) {
        Docente docente = docenteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Docente con ID " + id + " no encontrado."));
        docente.setNombre(dto.nombre());
        docente.setApellido(dto.apellido());
        docente.setTelefono(dto.telefono());
        docente.setEspecialidad(dto.especialidad());
        docente.setCorreo(dto.correo());
        docente.setDescripcion(dto.descripcion());

        return docenteMapper.toDTO(docenteRepository.save(docente));
    }

    @Transactional
    public void eliminar(Long id) {
        if (!docenteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Docente con ID " + id + " no encontrado.");
        }
        docenteRepository.deleteById(id);
    }
}