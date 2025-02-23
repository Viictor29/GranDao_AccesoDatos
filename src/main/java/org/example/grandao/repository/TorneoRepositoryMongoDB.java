package org.example.grandao.repository;

import org.example.grandao.dtos.TorneoMongoDB;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TorneoRepositoryMongoDB extends MongoRepository<TorneoMongoDB, String> {
}
