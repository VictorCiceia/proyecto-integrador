package com.proyecto.integrador.integrador.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Schema(description = "Objeto que representa a un Usuario")
public class UserDto {

    @Schema(
            description = "Identificador unico",
            type = "string",
            example = "1")
    private long id;

    @Schema(
            description = "Nombre",
            type = "string",
            example = "Juan")
    private String name;

    @Schema(
            description = "Apellido",
            type = "string",
            example = "Perez")
    private String lastName;

    @Schema(
            description = "Email",
            type = "string",
            example = "usuario@email.com")
    private String email;

    @Schema(
            description = "Fecha de creacion",
            type = "Date",
            example = "2024-05-04T23:51:14.243Z")
    private Date createdAt;

    public UserDto(long id, String name, String lastName, String email, Date createdAt) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.createdAt = createdAt;
    }

    public UserDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
