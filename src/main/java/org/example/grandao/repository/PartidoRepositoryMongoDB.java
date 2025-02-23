package org.example.grandao.repository;

import org.example.grandao.dtos.PartidoMongoDB;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PartidoRepositoryMongoDB extends MongoRepository<PartidoMongoDB, String> {
}
