package com.proyecto.integrador.integrador.service.impl;

import com.proyecto.integrador.integrador.dto.UserDto;
import com.proyecto.integrador.integrador.entity.UserEntity;
import com.proyecto.integrador.integrador.exception.ResourceNotFoundException;
import com.proyecto.integrador.integrador.service.UserService;
import com.proyecto.integrador.integrador.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    final HashMap<Long, UserEntity> hashMap = new HashMap<>();
    Long id = 1L;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDto> all() {
        return new ArrayList<>(
                this.hashMap.values().stream().map((u) -> this.userMapper.toDto(u))
                        .toList()
        );
    }

    @Override
    public UserDto findById(final Long id) {
        final UserEntity user = this.findEntityById(id);
        return this.userMapper.toDto(user);
    }

    @Override
    public UserDto save(final UserDto userDto) {
        final UserEntity entity = this.userMapper.toEntity(userDto);
        entity.setId(this.id);
        entity.setCreatedAt(new Date());
        this.hashMap.put(this.id++, entity);
        return this.userMapper.toDto(entity);
    }

    @Override
    public UserDto update(final UserDto userDto, final Long userId) {
        final UserEntity user = this.findEntityById(userId);
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        return this.userMapper.toDto(user);
    }

    @Override
    public void deleteById(final Long id) {
        this.findEntityById(id);
        this.hashMap.remove(id);
    }

    private UserEntity findEntityById(final Long id) {
        final UserEntity user = hashMap.get(id);
        if (user == null)
            throw new ResourceNotFoundException("Usuario", "ID", id.toString());
        return user;
    }
}
