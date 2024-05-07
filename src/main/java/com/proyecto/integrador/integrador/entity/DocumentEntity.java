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
public class DocumentEntity {

    private long id;

    private String name;

    private String description;

    private String path;

    private Date createdAt;


}
