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
@Schema(description = "Objeto que representa a un Documento")
public class DocumentDto {

    @Schema(
            description = "Identificador unico",
            type = "string",
            example = "1")
    private long id;

    @Schema(
            description = "Nombre",
            type = "string",
            example = "Algebra de Baldor")
    private String name;

    @Schema(
            description = "Descripcion",
            type = "string",
            example = "Libro de matematicas")
    private String description;

    @Schema(
            description = "Path",
            type = "string",
            example = "/mate/libro1.pdf")
    private String path;

    @Schema(
            description = "Fecha de creacion",
            type = "Date",
            example = "2024-05-04T23:51:14.243Z")
    private Date createdAt;

}
