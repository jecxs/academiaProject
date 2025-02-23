package com.academia.academiaproject.mapper;


import com.academia.academiaproject.controller.dto.DocenteDTO;
import com.academia.academiaproject.repository.model.Docente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DocenteMapper {
    DocenteMapper INSTANCE = Mappers.getMapper(DocenteMapper.class);

    DocenteDTO toDto(Docente docente);
    Docente toEntity(DocenteDTO docenteDTO);
}