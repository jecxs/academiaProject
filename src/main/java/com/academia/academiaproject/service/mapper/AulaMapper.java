package com.academia.academiaproject.service.mapper;

import com.academia.academiaproject.controller.dto.request.AulaRequestDTO;
import com.academia.academiaproject.controller.dto.response.AulaResponseDTO;
import com.academia.academiaproject.controller.dto.response.SedeSimpleDTO;
import com.academia.academiaproject.repository.model.Aula;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AulaMapper {
    AulaMapper INSTANCE = Mappers.getMapper(AulaMapper.class);

    @Mapping(target = "sede", ignore = true)
    Aula toEntity(AulaRequestDTO dto);

    default AulaResponseDTO toDTO(Aula aula) {
        if (aula == null) {
            return null;
        }

        SedeSimpleDTO sedeSimpleDTO = aula.getSede() != null ?
                new SedeSimpleDTO(
                        aula.getSede().getId(),
                        aula.getSede().getNombre(),
                        aula.getSede().getDireccion()
                ) :
                null;

        return new AulaResponseDTO(
                aula.getId(),
                aula.getNombre(),
                aula.getAforo(),
                sedeSimpleDTO
        );
    }
}