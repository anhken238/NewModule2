package com.gym.service;

import com.gym.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
    void update(int id, Product product);
    void save(Product product);
    void remove(int id);
}
