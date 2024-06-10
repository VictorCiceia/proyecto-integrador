package com.proyecto.integrador.integrador.entity;

import java.util.Date;

public class DocumentEntity {

    private long id;

    private String name;

    private String description;

    private String path;

    private Date createdAt;

    public DocumentEntity(long id, String name, String description, String path, Date createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.path = path;
        this.createdAt = createdAt;
    }

    public DocumentEntity() {
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
