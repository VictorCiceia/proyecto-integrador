package com.proyecto.integrador.integrador.service;

import com.proyecto.integrador.integrador.dto.DocumentDto;

import java.util.List;

public interface DocumentService {


    List<DocumentDto> all();

    DocumentDto findById(Long id);

    DocumentDto save(DocumentDto documentDto);

    DocumentDto update(DocumentDto documentDto, Long userId);

    void deleteById(Long id);

}
