package com.proyecto.integrador.integrador.service.impl;

import com.proyecto.integrador.integrador.dto.DocumentDto;
import com.proyecto.integrador.integrador.entity.DocumentEntity;
import com.proyecto.integrador.integrador.exception.ResourceNotFoundException;
import com.proyecto.integrador.integrador.repository.DocumentRepository;
import com.proyecto.integrador.integrador.service.mapper.DocumentMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DocumentServiceImplTest {

    @Mock
    private DocumentMapper documentMapper;

    @Mock
    private DocumentRepository documentRepository;

    @InjectMocks
    private DocumentServiceImpl documentService;

    private DocumentEntity documentEntity;
    private DocumentDto documentDto;

    @BeforeEach
    void setUp() {
        documentEntity = new DocumentEntity();
        documentEntity.setId("1");
        documentEntity.setName("Ingles");
        documentEntity.setDescription("Libro de ingles");
        documentEntity.setPath("/libros");
        documentEntity.setCreatedAt(new Date());

        documentDto = new DocumentDto();
        documentDto.setName("Ingles");
        documentDto.setDescription("Libro de ingles");
        documentDto.setPath("/libros");
    }

    @Test
    void buscarTodosResultadoExitoso() {
        List<DocumentEntity> entities = new ArrayList<>();
        entities.add(documentEntity);

        when(documentRepository.findAll()).thenReturn(entities);
        when(documentMapper.toDto(any(DocumentEntity.class))).thenReturn(documentDto);

        List<DocumentDto> dtos = documentService.all();

        assertNotNull(dtos);
        assertEquals(1, dtos.size());
        verify(documentRepository, times(1)).findAll();
        verify(documentMapper, times(1)).toDto(documentEntity);
    }

    @Test
    void buscarPorIdResultadoExitoso() {
        when(documentRepository.findById(1L)).thenReturn(Optional.of(documentEntity));
        when(documentMapper.toDto(any(DocumentEntity.class))).thenReturn(documentDto);

        DocumentDto dto = documentService.findById(1L);

        assertNotNull(dto);
        assertEquals("Ingles", dto.getName());
        assertEquals("Libro de ingles", dto.getDescription());
        assertEquals("/libros", dto.getPath());
        verify(documentRepository, times(1)).findById(1L);
        verify(documentMapper, times(1)).toDto(documentEntity);
    }

    @Test
    void buscarPorIdInvalidoResultadoNoExitoso() {
        when(documentRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> documentService.findById(1L));

        verify(documentRepository, times(1)).findById(1L);
        verify(documentMapper, times(0)).toDto(any(DocumentEntity.class));
    }

    @Test
    void guardarResultadoExitoso() {
        when(documentMapper.toEntity(any(DocumentDto.class))).thenReturn(documentEntity);
        when(documentRepository.save(any(DocumentEntity.class))).thenReturn(documentEntity);
        when(documentMapper.toDto(any(DocumentEntity.class))).thenReturn(documentDto);

        DocumentDto savedDto = documentService.save(documentDto);

        assertNotNull(savedDto);
        assertEquals("Ingles", savedDto.getName());
        assertEquals("Libro de ingles", savedDto.getDescription());
        assertEquals("/libros", savedDto.getPath());
        verify(documentMapper, times(1)).toEntity(documentDto);
        verify(documentRepository, times(1)).save(documentEntity);
        verify(documentMapper, times(1)).toDto(documentEntity);
    }

    @Test
    void actualizarResultadoExitoso() {
        when(documentRepository.findById(1L)).thenReturn(Optional.of(documentEntity));
        when(documentRepository.save(any(DocumentEntity.class))).thenReturn(documentEntity);
        when(documentMapper.toDto(any(DocumentEntity.class))).thenReturn(documentDto);

        DocumentDto updatedDto = documentService.update(documentDto, 1L);

        assertNotNull(updatedDto);
        assertEquals("Ingles", updatedDto.getName());
        assertEquals("Libro de ingles", updatedDto.getDescription());
        assertEquals("/libros", updatedDto.getPath());
        verify(documentRepository, times(1)).findById(1L);
        verify(documentRepository, times(1)).save(documentEntity);
        verify(documentMapper, times(1)).toDto(documentEntity);
    }

    @Test
    void actualizarNoExistenteResultadoExitoso() {
        when(documentRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> documentService.update(documentDto, 1L));

        verify(documentRepository, times(1)).findById(1L);
        verify(documentMapper, times(0)).toDto(any(DocumentEntity.class));
    }

    @Test
    void borrarExistenteResultadoExitoso() {
        when(documentRepository.findById(1L)).thenReturn(Optional.of(documentEntity));

        documentService.deleteById(1L);

        verify(documentRepository, times(1)).findById(1L);
        verify(documentRepository, times(1)).delete(documentEntity);
    }

    @Test
    void borrarNoExistenteResultadoExitoso() {
        when(documentRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> documentService.deleteById(1L));

        verify(documentRepository, times(1)).findById(1L);
        verify(documentRepository, times(0)).delete(any(DocumentEntity.class));
    }

}
