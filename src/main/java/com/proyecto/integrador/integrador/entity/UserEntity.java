package com.proyecto.integrador.integrador.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    private long id;

    private String name;

    private String lastName;

    private String email;

    private Date createdAt;

}
