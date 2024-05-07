package com.proyecto.integrador.integrador.service.mapper;

import com.proyecto.integrador.integrador.dto.DocumentDto;
import com.proyecto.integrador.integrador.entity.DocumentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DocumentMapper {

    DocumentDto toDto(DocumentEntity entity);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "path", source = "path")
    DocumentEntity toEntity(DocumentDto dto);

}
