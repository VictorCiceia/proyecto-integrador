package com.proyecto.integrador.integrador.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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

}
