package com.academia.academiaproject.service;

import com.academia.academiaproject.controller.dto.request.AulaRequestDTO;
import com.academia.academiaproject.controller.dto.response.AulaResponseDTO;
import com.academia.academiaproject.controller.exception.ResourceNotFoundException;
import com.academia.academiaproject.repository.AulaRepository;
import com.academia.academiaproject.repository.SedeRepository;
import com.academia.academiaproject.repository.model.Aula;
import com.academia.academiaproject.repository.model.Sede;
import com.academia.academiaproject.service.mapper.AulaMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AulaService {
    private final AulaRepository aulaRepository;
    private final SedeRepository sedeRepository;
    private final AulaMapper aulaMapper;

    public List<AulaResponseDTO> obtenerTodas() {
        return aulaRepository.findAll().stream()
                .map(aulaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AulaResponseDTO obtenerPorId(Long id) {
        Aula aula = aulaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aula con ID " + id + " no encontrada."));
        return aulaMapper.toDTO(aula);
    }

    @Transactional
    public AulaResponseDTO crear(AulaRequestDTO dto) {
        Sede sede = sedeRepository.findById(dto.sedeId())
                .orElseThrow(() -> new ResourceNotFoundException("Sede con ID " + dto.sedeId() + " no encontrada."));

        Aula aula = aulaMapper.toEntity(dto);
        aula.setSede(sede);

        return aulaMapper.toDTO(aulaRepository.save(aula));
    }

    @Transactional
    public AulaResponseDTO actualizar(Long id, AulaRequestDTO dto) {
        Aula aula = aulaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aula con ID " + id + " no encontrada."));

        Sede sede = sedeRepository.findById(dto.sedeId())
                .orElseThrow(() -> new ResourceNotFoundException("Sede con ID " + dto.sedeId() + " no encontrada."));

        aula.setNombre(dto.nombre());
        aula.setAforo(dto.aforo());
        aula.setSede(sede);

        return aulaMapper.toDTO(aulaRepository.save(aula));
    }

    @Transactional
    public void eliminar(Long id) {
        if (!aulaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Aula con ID " + id + " no encontrada.");
        }
        aulaRepository.deleteById(id);
    }
}