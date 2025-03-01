package com.academia.academiaproject.service.mapper;

import com.academia.academiaproject.controller.dto.request.AulaRequestDTO;
import com.academia.academiaproject.controller.dto.response.AulaResponseDTO;
import com.academia.academiaproject.repository.model.Aula;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AulaMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "sede", ignore = true)
    Aula toEntity(AulaRequestDTO dto);


    @Mapping(target = "sedeNombre", source = "sede.nombre")
    AulaResponseDTO toDTO(Aula aula);
}