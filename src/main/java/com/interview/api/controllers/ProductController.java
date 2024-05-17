package com.interview.api.controllers;

import com.interview.api.entity.ProductEntity;
import com.interview.api.exceptions.ProductExceptionController;
import com.interview.api.exceptions.ProductNotfoundException;
import com.interview.api.repositories.ProductRepository;
import com.interview.api.services.interfaces.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    Product product;
    @Autowired
    ProductEntity productEntity;


    private final ProductRepository productRepository;

    @Autowired
    ProductExceptionController productExceptionController;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/get/{name}")
     ResponseEntity<Object> get(@PathVariable("name") String name){

        try{

            productEntity = productRepository.findByName(name);

           if(productEntity == null){

               System.out.println("product entity is null");

               throw new ProductNotfoundException();

           }

           return new ResponseEntity<>(productEntity, HttpStatus.OK);

        }catch (HttpServerErrorException.InternalServerError e){

            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }


}
