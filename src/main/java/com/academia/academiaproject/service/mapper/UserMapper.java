package com.academia.academiaproject.service.mapper;

import com.academia.academiaproject.controller.dto.request.UserRequestDTO;
import com.academia.academiaproject.controller.dto.response.UserResponseDTO;
import com.academia.academiaproject.repository.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toEntity(UserRequestDTO dto);

    UserResponseDTO toDTO(User user);
}