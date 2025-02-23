package org.example.grandao.repository;

import org.example.grandao.dtos.JugadorMongoDB;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JugadorRepositoryMongoDB extends MongoRepository<JugadorMongoDB, String> {
}
