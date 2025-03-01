package com.academia.academiaproject.service.mapper;


import com.academia.academiaproject.controller.dto.request.AlumnoRequestDTO;
import com.academia.academiaproject.controller.dto.response.AlumnoResponseDTO;
import com.academia.academiaproject.repository.model.Alumno;
import com.academia.academiaproject.repository.model.CarreraProfesional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AlumnoMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "carrera", ignore = true)
    Alumno toEntity(AlumnoRequestDTO dto);

    @Mapping(target = "carrera", expression = "java(alumno.getCarrera() != null ? alumno.getCarrera().getNombre() : null)")
    AlumnoResponseDTO toDTO(Alumno alumno);
}