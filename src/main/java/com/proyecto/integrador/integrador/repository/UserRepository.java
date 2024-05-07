package com.proyecto.integrador.integrador.repository;

import com.proyecto.integrador.integrador.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, Long> {
}
