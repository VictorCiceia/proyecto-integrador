package com.proyecto.integrador.integrador.service.mapper;

import com.proyecto.integrador.integrador.dto.UserDto;
import com.proyecto.integrador.integrador.entity.UserEntity;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {

    public UserDto toDto(UserEntity entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setLastName(entity.getLastName());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    public UserEntity toEntity(UserDto dto) {
        UserEntity entity = new UserEntity();
        entity.setName(dto.getName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        return entity;

    }

}
