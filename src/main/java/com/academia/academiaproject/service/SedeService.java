package com.academia.academiaproject.service;

import com.academia.academiaproject.controller.dto.request.SedeRequestDTO;
import com.academia.academiaproject.controller.dto.response.SedeResponseDTO;
import com.academia.academiaproject.controller.dto.response.SedeSimpleDTO;
import com.academia.academiaproject.controller.exception.ResourceNotFoundException;
import com.academia.academiaproject.repository.SedeRepository;
import com.academia.academiaproject.repository.model.Sede;
import com.academia.academiaproject.service.mapper.SedeMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SedeService {
    private final SedeRepository sedeRepository;
    private final SedeMapper sedeMapper;

    public List<SedeResponseDTO> obtenerTodas() {
        return sedeRepository.findAll().stream()
                .map(sedeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SedeResponseDTO obtenerPorId(Long id) {
        Sede sede = sedeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sede con ID " + id + " no encontrada."));
        return sedeMapper.toDTO(sede);
    }

    @Transactional
    public SedeResponseDTO crear(SedeRequestDTO dto) {
        Sede sede = sedeMapper.toEntity(dto);
        return sedeMapper.toDTO(sedeRepository.save(sede));
    }

    @Transactional
    public SedeResponseDTO actualizar(Long id, SedeRequestDTO dto) {
        Sede sede = sedeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sede con ID " + id + " no encontrada."));
        sede.setNombre(dto.nombre());
        sede.setDireccion(dto.direccion());

        return sedeMapper.toDTO(sedeRepository.save(sede));
    }

    @Transactional
    public void eliminar(Long id) {
        if (!sedeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Sede con ID " + id + " no encontrada.");
        }
        sedeRepository.deleteById(id);
    }

    public SedeSimpleDTO obtenerSimplePorId(Long id) {
        Sede sede = sedeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sede con ID " + id + " no encontrada."));
        return sedeMapper.toSimpleDTO(sede);
    }
}