package org.example.grandao.repository;

import org.example.grandao.dtos.ProductoMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Producto repository mongo.
 */
@Repository
public interface ProductoRepositoryMongo extends MongoRepository<ProductoMongo, String> {
}
