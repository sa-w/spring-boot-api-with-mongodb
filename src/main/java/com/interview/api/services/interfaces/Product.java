package com.interview.api.services.interfaces;

import com.interview.api.entity.ProductEntity;

import java.util.List;

public interface Product {

    void add(String name, int quantity);

    ProductEntity get(String name);

    void delete(String id);

    List<ProductEntity> getAll();

}
