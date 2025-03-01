package com.academia.academiaproject.service.mapper;

import com.academia.academiaproject.controller.dto.request.SedeRequestDTO;
import com.academia.academiaproject.controller.dto.response.SedeResponseDTO;
import com.academia.academiaproject.repository.model.Sede;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SedeMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "aulas", ignore = true)
    Sede toEntity(SedeRequestDTO dto);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "direccion", source = "direccion")
    SedeResponseDTO toDTO(Sede sede);
}