package com.proyecto.integrador.integrador.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user_collection")
public class UserEntity {

    @Id
    private String id;

    private String name;

    private String lastName;

    private String email;

    private Date createdAt;

}
