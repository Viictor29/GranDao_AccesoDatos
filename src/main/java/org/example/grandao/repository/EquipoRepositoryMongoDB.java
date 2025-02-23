package org.example.grandao.repository;

import org.example.grandao.dtos.EquipoMongoDB;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EquipoRepositoryMongoDB extends MongoRepository<EquipoMongoDB, String> {
}
