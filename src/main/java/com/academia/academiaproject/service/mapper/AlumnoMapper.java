package com.academia.academiaproject.service.mapper;

import com.academia.academiaproject.controller.dto.request.AlumnoRequestDTO;
import com.academia.academiaproject.controller.dto.response.AlumnoResponseDTO;
import com.academia.academiaproject.controller.dto.response.AlumnoSimpleDTO;
import com.academia.academiaproject.controller.dto.response.CarreraSimpleDTO;
import com.academia.academiaproject.repository.model.Alumno;
import com.academia.academiaproject.repository.model.CarreraProfesional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AlumnoMapper {
    AlumnoMapper INSTANCE = Mappers.getMapper(AlumnoMapper.class);

    @Mapping(target = "carrera", ignore = true)
    Alumno toEntity(AlumnoRequestDTO dto);

    @Mapping(target = "carrera", source = "carrera")
    AlumnoResponseDTO toDTO(Alumno alumno);

    AlumnoSimpleDTO toSimpleDTO(Alumno alumno);

    default CarreraSimpleDTO carreraToSimpleDTO(CarreraProfesional carrera) {
        if (carrera == null) {
            return null;
        }
        return new CarreraSimpleDTO(carrera.getId(), carrera.getNombre());
    }
}
