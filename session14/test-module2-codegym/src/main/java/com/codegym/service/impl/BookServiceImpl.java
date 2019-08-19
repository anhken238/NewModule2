package com.codegym.service.impl;

import com.codegym.model.Book;
import com.codegym.repository.BookRepository;
import com.codegym.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findOne(id);
    }

    @Override
    public void save(Book employeeGroup) {
        bookRepository.save(employeeGroup);
    }

    @Override
    public void remove(Long id) {
        bookRepository.delete(id);
    }

    @Override
    public Page<Book> findAllById(Long id, Pageable pageable) {
        return bookRepository.findAllById(id, pageable);
    }
}
