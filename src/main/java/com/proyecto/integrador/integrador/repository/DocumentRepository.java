package com.proyecto.integrador.integrador.repository;

import com.proyecto.integrador.integrador.entity.DocumentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends MongoRepository<DocumentEntity, Long> {
}
