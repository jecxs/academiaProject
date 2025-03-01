package com.academia.academiaproject.service;

import com.academia.academiaproject.controller.dto.response.CarreraProfesionalResponseDTO;
import com.academia.academiaproject.repository.CarreraProfesionalRepository;
import com.academia.academiaproject.service.mapper.CarreraProfesionalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarreraProfesionalService {
    private final CarreraProfesionalRepository carreraRepository;
    private final CarreraProfesionalMapper carreraMapper;

    public List<CarreraProfesionalResponseDTO> obtenerTodas() {
        return carreraRepository.findAll().stream()
                .map(carreraMapper::toDTO)
                .collect(Collectors.toList());
    }
}