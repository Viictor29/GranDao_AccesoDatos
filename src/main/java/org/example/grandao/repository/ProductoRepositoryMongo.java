package org.example.grandao.repository;

import org.example.grandao.dtos.ProductoMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositoryMongo extends MongoRepository<ProductoMongo, String> {
}
