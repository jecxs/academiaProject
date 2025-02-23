package com.academia.academiaproject.service;


import com.academia.academiaproject.controller.dto.DocenteDTO;
import com.academia.academiaproject.mapper.DocenteMapper;
import com.academia.academiaproject.repository.DocenteRepository;
import com.academia.academiaproject.repository.model.Docente;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocenteService {

    private final DocenteRepository docenteRepository;
    private final DocenteMapper docenteMapper;

    public List<DocenteDTO> listar() {
        return docenteRepository.findAll()
                .stream()
                .map(docenteMapper::toDto)
                .collect(Collectors.toList());
    }

    public DocenteDTO guardar(DocenteDTO dto) {
        Docente docente = docenteMapper.toEntity(dto);
        return docenteMapper.toDto(docenteRepository.save(docente));
    }

    public DocenteDTO buscarPorId(Long id) {
        Docente docente = docenteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Docente no encontrado"));
        return docenteMapper.toDto(docente);
    }

    public void eliminar(Long id) {
        docenteRepository.deleteById(id);
    }
}