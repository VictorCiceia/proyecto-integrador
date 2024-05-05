package com.proyecto.integrador.integrador.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private long id;

    private String name;

    private String lastName;

    private String email;

    private Date createdAt;

}
