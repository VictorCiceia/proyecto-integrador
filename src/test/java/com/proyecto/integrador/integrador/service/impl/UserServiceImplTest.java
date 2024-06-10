package com.proyecto.integrador.integrador.service.impl;

import com.proyecto.integrador.integrador.dto.UserDto;
import com.proyecto.integrador.integrador.entity.UserEntity;
import com.proyecto.integrador.integrador.exception.ResourceNotFoundException;
import com.proyecto.integrador.integrador.repository.UserRepository;
import com.proyecto.integrador.integrador.service.mapper.UserMapper;
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
public class UserServiceImplTest {

    @Mock
    private UserMapper userMapper;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private UserEntity userEntity;
    private UserDto userDto;

    @BeforeEach
    void setUp() {
        userEntity = new UserEntity();
        userEntity.setId("1");
        userEntity.setName("Victor");
        userEntity.setLastName("Ciceia");
        userEntity.setEmail("victor@test.com");
        userEntity.setCreatedAt(new Date());

        userDto = new UserDto();
        userDto.setName("Victor");
        userDto.setLastName("Ciceia");
        userDto.setEmail("victor@test.com");
    }

    @Test
    void buscarTodosResultadoExitoso() {
        final List<UserEntity> entities = new ArrayList<>();
        entities.add(userEntity);

        when(userRepository.findAll()).thenReturn(entities);
        when(userMapper.toDto(any(UserEntity.class))).thenReturn(userDto);

        final List<UserDto> dtos = userService.all();
        assertNotNull(dtos);
        assertEquals(1, dtos.size());
        verify(userRepository, times(1)).findAll();
        verify(userMapper, times(1)).toDto(userEntity);
    }

    @Test
    void buscarPorIdResultadoExitoso() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity));
        when(userMapper.toDto(any(UserEntity.class))).thenReturn(userDto);

        UserDto dto = userService.findById(1L);

        assertNotNull(dto);
        assertEquals("Victor", dto.getName());
        assertEquals("Ciceia", dto.getLastName());
        assertEquals("victor@test.com", dto.getEmail());
        verify(userRepository, times(1)).findById(1L);
        verify(userMapper, times(1)).toDto(userEntity);
    }

    @Test
    void buscarPorIdInvalidoResultadoNoExitoso() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> userService.findById(1L));

        verify(userRepository, times(1)).findById(1L);
        verify(userMapper, times(0)).toDto(any(UserEntity.class));
    }

    @Test
    void guardarResultadoExitoso() {
        when(userMapper.toEntity(any(UserDto.class))).thenReturn(userEntity);
        when(userRepository.save(any(UserEntity.class))).thenReturn(userEntity);
        when(userMapper.toDto(any(UserEntity.class))).thenReturn(userDto);

        UserDto savedDto = userService.save(userDto);

        assertNotNull(savedDto);
        assertEquals("Victor", savedDto.getName());
        assertEquals("Ciceia", savedDto.getLastName());
        assertEquals("victor@test.com", savedDto.getEmail());
        verify(userMapper, times(1)).toEntity(userDto);
        verify(userRepository, times(1)).save(userEntity);
        verify(userMapper, times(1)).toDto(userEntity);
    }

    @Test
    void actualizarResultadoExitoso() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity));
        when(userRepository.save(any(UserEntity.class))).thenReturn(userEntity);
        when(userMapper.toDto(any(UserEntity.class))).thenReturn(userDto);

        UserDto updatedDto = userService.update(userDto, 1L);

        assertNotNull(updatedDto);
        assertEquals("Victor", updatedDto.getName());
        assertEquals("Ciceia", updatedDto.getLastName());
        assertEquals("victor@test.com", updatedDto.getEmail());
        verify(userRepository, times(1)).findById(1L);
        verify(userRepository, times(1)).save(userEntity);
        verify(userMapper, times(1)).toDto(userEntity);
    }

    @Test
    void actualizarNoExistenteResultadoExitoso() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> userService.update(userDto, 1L));

        verify(userRepository, times(1)).findById(1L);
        verify(userMapper, times(0)).toDto(any(UserEntity.class));
    }

    @Test
    void borrarExistenteResultadoExitoso() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity));

        userService.deleteById(1L);

        verify(userRepository, times(1)).findById(1L);
        verify(userRepository, times(1)).delete(userEntity);
    }

    @Test
    void borrarNoExistenteResultadoExitoso() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> userService.deleteById(1L));

        verify(userRepository, times(1)).findById(1L);
        verify(userRepository, times(0)).delete(any(UserEntity.class));
    }

}
