package com.learncode.springsecurity.springsecurity3.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.learncode.springsecurity.springsecurity3.entity.Product;

import jakarta.annotation.PostConstruct;

@Service
public class ProductService {
    
    private List<Product> products = null;


    @PostConstruct
    public void initialize(){
        products = IntStream.range(1, 100)
                    .mapToObj(i -> new Product(String.valueOf(i),"Product_"+ String.valueOf(i)))
                    .collect(Collectors.toList());
                   
                    
    }

    public List<Product> getProducts(){
        return this.products;
    }

    public Product getProduct(String id){
        return products.stream().filter(p->p.getId().equals(id))
        .findAny()
        .orElseThrow(()-> new RuntimeException("Product "+id+" not found"));
    }
}
