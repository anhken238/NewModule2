package com.na.service;

import com.na.model.Category;

public interface ICategoryService {
    Iterable<Category> findAll();
    Category   findById(Long id);
    void save(Category category);
    void remove(Long id);
}
