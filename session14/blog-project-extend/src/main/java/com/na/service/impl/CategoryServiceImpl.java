package com.na.service.impl;

import com.na.model.Category;
import com.na.repository.ICategoryRepository;
import com.na.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Override
    public Iterable<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return iCategoryRepository.findOne(id);
    }

    @Override
    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public void remove(Long id) {
    iCategoryRepository.delete(id);
    }
}
