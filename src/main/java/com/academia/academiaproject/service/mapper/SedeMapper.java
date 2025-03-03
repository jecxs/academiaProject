package com.academia.academiaproject.service.mapper;

import com.academia.academiaproject.controller.dto.request.SedeRequestDTO;
import com.academia.academiaproject.controller.dto.response.AulaSimpleDTO;
import com.academia.academiaproject.controller.dto.response.SedeResponseDTO;
import com.academia.academiaproject.controller.dto.response.SedeSimpleDTO;
import com.academia.academiaproject.repository.model.Aula;
import com.academia.academiaproject.repository.model.Sede;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SedeMapper {
    SedeMapper INSTANCE = Mappers.getMapper(SedeMapper.class);

    @Mapping(target = "aulas", ignore = true)
    Sede toEntity(SedeRequestDTO dto);

    SedeSimpleDTO toSimpleDTO(Sede sede);

    default SedeResponseDTO toDTO(Sede sede) {
        if (sede == null) {
            return null;
        }

        List<AulaSimpleDTO> aulaSimpleDTOs = sede.getAulas() != null ?
                sede.getAulas().stream()
                        .map(this::aulaToAulaSimpleDTO)
                        .toList() :
                List.of();

        return new SedeResponseDTO(
                sede.getId(),
                sede.getNombre(),
                sede.getDireccion(),
                aulaSimpleDTOs
        );
    }

    default AulaSimpleDTO aulaToAulaSimpleDTO(Aula aula) {
        if (aula == null) {
            return null;
        }

        return new AulaSimpleDTO(
                aula.getId(),
                aula.getNombre(),
                aula.getAforo()
        );
    }
}