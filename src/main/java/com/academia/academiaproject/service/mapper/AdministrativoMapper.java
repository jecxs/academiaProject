package com.academia.academiaproject.service.mapper;

import com.academia.academiaproject.controller.dto.request.AdministrativoRequestDTO;
import com.academia.academiaproject.controller.dto.response.AdministrativoResponseDTO;
import com.academia.academiaproject.repository.model.Administrativo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AdministrativoMapper {
    AdministrativoMapper INSTANCE = Mappers.getMapper(AdministrativoMapper.class);

    Administrativo toEntity(AdministrativoRequestDTO dto);
    AdministrativoResponseDTO toDTO(Administrativo administrativo);
}