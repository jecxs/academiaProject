package com.academia.academiaproject.service;

import com.academia.academiaproject.controller.dto.request.SedeRequestDTO;
import com.academia.academiaproject.controller.dto.response.SedeResponseDTO;
import com.academia.academiaproject.controller.exception.ResourceNotFoundException;
import com.academia.academiaproject.repository.SedeRepository;
import com.academia.academiaproject.repository.model.Sede;
import com.academia.academiaproject.service.mapper.SedeMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SedeService {
    private final SedeRepository sedeRepository;
    private final SedeMapper sedeMapper;

    public List<SedeResponseDTO> obtenerTodas() {
        return sedeRepository.findAll().stream().map(sedeMapper::toDTO).toList();
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
    public void eliminar(Long id) {
        if (!sedeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Sede con ID " + id + " no encontrada.");
        }
        sedeRepository.deleteById(id);
    }
}