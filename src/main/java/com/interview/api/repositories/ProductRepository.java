package com.interview.api.repositories;

import com.interview.api.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, String> {

    @Query("{name:'?0'}")
    ProductEntity findByName(String name);

    List<ProductEntity> findAll();

}
