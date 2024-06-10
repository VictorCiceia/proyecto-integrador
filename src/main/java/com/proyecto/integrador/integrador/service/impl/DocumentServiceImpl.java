package com.proyecto.integrador.integrador.service.impl;

import com.proyecto.integrador.integrador.dto.DocumentDto;
import com.proyecto.integrador.integrador.entity.DocumentEntity;
import com.proyecto.integrador.integrador.exception.ResourceNotFoundException;
import com.proyecto.integrador.integrador.service.DocumentService;
import com.proyecto.integrador.integrador.service.mapper.DocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class DocumentServiceImpl implements DocumentService {

    final HashMap<Long, DocumentEntity> hashMap = new HashMap<>();
    Long id = 1L;

    @Autowired
    private DocumentMapper documentMapper;

    @Override
    public List<DocumentDto> all() {
        return new ArrayList<>(
                this.hashMap.values().stream().map((d) -> this.documentMapper.toDto(d)).collect(Collectors.toList())
        );
    }

    @Override
    public DocumentDto findById(Long id) {
        final DocumentEntity doc = this.findEntityById(id);
        return this.documentMapper.toDto(doc);
    }

    @Override
    public DocumentDto save(DocumentDto documentDto) {
        final DocumentEntity entity = this.documentMapper.toEntity(documentDto);
        entity.setId(this.id);
        entity.setCreatedAt(new Date());
        this.hashMap.put(this.id++, entity);
        return this.documentMapper.toDto(entity);
    }

    @Override
    public DocumentDto update(DocumentDto documentDto, Long userId) {
        final DocumentEntity doc = this.findEntityById(userId);
        doc.setName(documentDto.getName());
        doc.setDescription(documentDto.getDescription());
        doc.setPath(documentDto.getPath());
        return this.documentMapper.toDto(doc);
    }

    @Override
    public void deleteById(Long id) {
        this.findEntityById(id);
        this.hashMap.remove(id);
    }

    private DocumentEntity findEntityById(final Long id) {
        final DocumentEntity doc = hashMap.get(id);
        if (doc == null)
            throw new ResourceNotFoundException("Documento", "ID", id.toString());
        return doc;
    }
}
