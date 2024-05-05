package com.proyecto.integrador.integrador.service;

import com.proyecto.integrador.integrador.dto.UserDto;

import java.util.List;

public interface UserService {


    List<UserDto> all();

    UserDto findById(Long id);

    UserDto save(UserDto userDto);

    UserDto update(UserDto userDto, Long userId);

    void deleteById(Long id);


}
