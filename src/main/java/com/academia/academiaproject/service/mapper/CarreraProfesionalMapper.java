package com.academia.academiaproject.service.mapper;

import com.academia.academiaproject.controller.dto.response.CarreraProfesionalResponseDTO;
import com.academia.academiaproject.repository.model.CarreraProfesional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarreraProfesionalMapper {


    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "descripcion", source = "descripcion")
    CarreraProfesionalResponseDTO toDTO(CarreraProfesional carrera);
}
