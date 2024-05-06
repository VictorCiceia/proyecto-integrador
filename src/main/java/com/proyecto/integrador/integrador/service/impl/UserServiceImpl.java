package com.proyecto.integrador.integrador.service.impl;

import com.proyecto.integrador.integrador.dto.UserDto;
import com.proyecto.integrador.integrador.entity.UserEntity;
import com.proyecto.integrador.integrador.exception.ResourceNotFoundException;
import com.proyecto.integrador.integrador.repository.UserRepository;
import com.proyecto.integrador.integrador.service.UserService;
import com.proyecto.integrador.integrador.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> all() {
        return this.userRepository.findAll()
                .stream().map(this.userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(final Long id) {
        final UserEntity user = this.findEntityById(id);
        return this.userMapper.toDto(user);
    }

    @Override
    public UserDto save(final UserDto userDto) {
        final UserEntity entity = this.userMapper.toEntity(userDto);
        entity.setCreatedAt(new Date());
        return this.userMapper.toDto(this.userRepository.save(entity));
    }

    @Override
    public UserDto update(final UserDto userDto, final Long userId) {
        final UserEntity user = this.findEntityById(userId);
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        return this.userMapper.toDto(this.userRepository.save(user));
    }

    @Override
    public void deleteById(final Long id) {
        final UserEntity entity = this.findEntityById(id);
        this.userRepository.delete(entity);
    }

    private UserEntity findEntityById(final Long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "ID", id.toString()));
    }
}
