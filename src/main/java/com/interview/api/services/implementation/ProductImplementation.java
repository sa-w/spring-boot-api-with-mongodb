package com.interview.api.services.implementation;

import com.interview.api.entity.ProductEntity;
import com.interview.api.repositories.ProductRepository;
import com.interview.api.services.interfaces.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProductImplementation implements Product {

    @Autowired
    ProductEntity productEntity;
    @Autowired
    ProductRepository productRepository;

    @Override
    public void add(String name, int quantity) {
        productEntity.setName(name);
        productEntity.setQuantity(quantity);
        productRepository.save(productEntity);
    }

    @Override
    public ProductEntity get(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<ProductEntity> getAll() {
        return productRepository.findAll();
    }


    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }

}
