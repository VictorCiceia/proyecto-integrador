package com.proyecto.integrador.integrador.service.impl;

import com.proyecto.integrador.integrador.dto.DocumentDto;
import com.proyecto.integrador.integrador.entity.DocumentEntity;
import com.proyecto.integrador.integrador.exception.ResourceNotFoundException;
import com.proyecto.integrador.integrador.repository.DocumentRepository;
import com.proyecto.integrador.integrador.service.DocumentService;
import com.proyecto.integrador.integrador.service.mapper.DocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentMapper documentMapper;

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public List<DocumentDto> all() {
        return this.documentRepository.findAll()
                .stream().map(this.documentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DocumentDto findById(Long id) {
        final DocumentEntity doc = this.findEntityById(id);
        return this.documentMapper.toDto(doc);
    }

    @Override
    public DocumentDto save(DocumentDto documentDto) {
        final DocumentEntity entity = this.documentMapper.toEntity(documentDto);
        entity.setCreatedAt(new Date());
        return this.documentMapper.toDto(this.documentRepository.save(entity));
    }

    @Override
    public DocumentDto update(DocumentDto documentDto, Long userId) {
        final DocumentEntity doc = this.findEntityById(userId);
        doc.setName(documentDto.getName());
        doc.setDescription(documentDto.getDescription());
        doc.setPath(documentDto.getPath());
        return this.documentMapper.toDto(this.documentRepository.save(doc));
    }

    @Override
    public void deleteById(Long id) {
        final DocumentEntity entity = this.findEntityById(id);
        this.documentRepository.delete(entity);
    }

    private DocumentEntity findEntityById(final Long id) {
        return this.documentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Documento", "ID", id.toString()));
    }
}
