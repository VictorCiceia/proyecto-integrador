package com.proyecto.integrador.integrador.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;


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

    public DocumentDto(long id, String name, String description, String path, Date createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.path = path;
        this.createdAt = createdAt;
    }

    public DocumentDto() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
