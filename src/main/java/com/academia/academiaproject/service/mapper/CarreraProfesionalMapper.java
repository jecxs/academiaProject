package com.academia.academiaproject.service.mapper;

import com.academia.academiaproject.controller.dto.request.CarreraProfesionalRequestDTO;
import com.academia.academiaproject.controller.dto.response.AlumnoSimpleDTO;
import com.academia.academiaproject.controller.dto.response.CarreraProfesionalResponseDTO;
import com.academia.academiaproject.controller.dto.response.CarreraProfesionalSimpleResponseDTO;
import com.academia.academiaproject.repository.model.Alumno;
import com.academia.academiaproject.repository.model.CarreraProfesional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CarreraProfesionalMapper {
    CarreraProfesionalMapper INSTANCE = Mappers.getMapper(CarreraProfesionalMapper.class);

    @Mapping(target = "alumnos", ignore = true)
    CarreraProfesional toEntity(CarreraProfesionalRequestDTO dto);

    @Mapping(target = "alumnos", expression = "java(mapAlumnosToSimpleDTO(carrera.getAlumnos()))")
    CarreraProfesionalResponseDTO toDTO(CarreraProfesional carrera);

    CarreraProfesionalSimpleResponseDTO toSimpleDTO(CarreraProfesional carrera);

    default List<AlumnoSimpleDTO> mapAlumnosToSimpleDTO(List<Alumno> alumnos) {
        if (alumnos == null) {
            return java.util.Collections.emptyList();
        }
        return alumnos.stream()
                .map(alumno -> new AlumnoSimpleDTO(alumno.getId(), alumno.getNombre(), alumno.getApellido()))
                .collect(Collectors.toList());
    }
}

