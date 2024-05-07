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
@Document(collection = "document_collection")
public class DocumentEntity {

    @Id
    private String id;

    private String name;

    private String description;

    private String path;

    private Date createdAt;

}
