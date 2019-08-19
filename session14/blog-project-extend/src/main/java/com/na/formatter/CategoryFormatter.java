package com.na.formatter;

import com.na.model.Category;
import com.na.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CategoryFormatter implements Formatter<Category> {

    ICategoryService iCategoryService;

    @Autowired
    public CategoryFormatter(ICategoryService iCategoryService) {
        this.iCategoryService = iCategoryService;
    }

    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        return iCategoryService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Category object, Locale locale) {

        return "["+ object.getId() + object.getNameCategory()+"]";
    }
}
