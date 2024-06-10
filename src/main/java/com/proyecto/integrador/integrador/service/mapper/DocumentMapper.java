package com.proyecto.integrador.integrador.service.mapper;

import com.proyecto.integrador.integrador.dto.DocumentDto;
import com.proyecto.integrador.integrador.entity.DocumentEntity;
import org.springframework.stereotype.Component;

@Component
public class DocumentMapper {

    public DocumentDto toDto(DocumentEntity entity) {
        DocumentDto dto = new DocumentDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPath(entity.getPath());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public DocumentEntity toEntity(DocumentDto dto) {
        DocumentEntity entity = new DocumentEntity();
        entity.setName(dto.getName());
        entity.setPath(dto.getPath());
        entity.setDescription(dto.getDescription());
        return entity;
    }

}
