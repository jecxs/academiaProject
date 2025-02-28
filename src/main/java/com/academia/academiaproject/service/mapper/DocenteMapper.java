package com.academia.academiaproject.service.mapper;

import com.academia.academiaproject.controller.dto.request.DocenteRequestDTO;
import com.academia.academiaproject.controller.dto.response.DocenteResponseDTO;
import com.academia.academiaproject.repository.model.Docente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DocenteMapper {
    DocenteMapper INSTANCE = Mappers.getMapper(DocenteMapper.class);


    Docente toEntity(DocenteRequestDTO dto);

    DocenteResponseDTO toDTO(Docente docente);
}
